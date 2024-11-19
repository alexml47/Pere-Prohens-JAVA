package org.example.nasa.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.nasa.dao.*;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NasaService{
    AproachDao aproachDao = new AproachDaoImpl();
    AsteroidDao asteroidDao = new AsteroidDaoImpl();


    public List<Asteroid> findAllAsteroids(){
        return asteroidDao.findAll();
    }

    public List<Aproach> findAllAproachesByAsteroidId(Long id){
        return aproachDao.getApproachesByAsteroidId(id);
    }

    public void saveAsteroid(Asteroid asteroid){
        asteroidDao.save(asteroid);
    }

    public Asteroid findAsteroid(int id){
        return asteroidDao.findById(id);
    }

    public void update(Asteroid obj) {
        asteroidDao.update(obj);
    }

    public void delete(Asteroid asteroid) {
        asteroidDao.delete(asteroid);
    }

    public void synchronize() throws URISyntaxException, IOException, InterruptedException {
        String apiKey = "MzHYWv6eaaxfR5b6unKvncJYTq0jX4br1mhNd7Ib";
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=" + apiKey))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        List<JsonObject> returns = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(getResponse.body(), JsonObject.class);
        returns.addAll(jsonObject.get("near_earth_objects")
                .getAsJsonArray()
                .asList()
                .stream()
                .map(JsonElement::getAsJsonObject)
                .toList());

        List<Asteroid> asteroids = new ArrayList<>();

        for (int i = 0; i < returns.size(); i++) {
            // int id, String name, int magnitude, int diameter, boolean dangerous, ArrayList<Aproach > aprochments
            int id = returns.get(i).get("id").getAsInt();

            String name = returns.get(i).get("name").getAsString();

            double magnitude = returns.get(i).get("absolute_magnitude_h").getAsDouble();

            JsonElement kilometers = returns.get(i).get("estimated_diameter").getAsJsonObject().get("kilometers");
            JsonElement minKilom = kilometers.getAsJsonObject().get("estimated_diameter_min");
            JsonElement maxKilom = kilometers.getAsJsonObject().get("estimated_diameter_max");
            double kmAverage = (minKilom.getAsDouble() + maxKilom.getAsDouble()) / 2;

            boolean hazard = returns.get(i).get("is_potentially_hazardous_asteroid").getAsBoolean();

            Asteroid ast = new Asteroid(id,name,magnitude,kmAverage,hazard);

            List<Aproach> aproaches = new ArrayList<>();
            JsonArray dates = returns.get(i)
                    .get("close_approach_data").getAsJsonArray();

            for (int j = 0; j < dates.size(); j++) {
                LocalDate aprochData = LocalDate.parse(
                        dates.get(j).getAsJsonObject()
                                .get("close_approach_date").getAsString()
                );

                double velocidad = dates.get(j).getAsJsonObject()
                        .get("relative_velocity").getAsJsonObject()
                        .get("kilometers_per_second").getAsDouble();

                double distance = dates.get(j).getAsJsonObject()
                        .get("miss_distance").getAsJsonObject()
                        .get("astronomical").getAsDouble();

                String orbit = dates.get(j).getAsJsonObject()
                        .get("orbiting_body").getAsString();

                aproaches.add(new Aproach(aprochData,velocidad,distance,orbit,ast));
            }


            ast.setAprochments(aproaches);

            asteroids.add(ast);


            saveAsteroid(ast);
        }
    }
}
