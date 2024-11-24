package org.example.nasa.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;
import org.example.nasa.provider.NasaProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsteroidJsonConvertor {
    private final String API_KEY = "MzHYWv6eaaxfR5b6unKvncJYTq0jX4br1mhNd7Ib";

    public List<Asteroid> getAsteroids() {
        List<JsonObject> astJson = NasaProvider.getDates(API_KEY);
        List<Asteroid> asteroids = new ArrayList<Asteroid>();

        for (JsonObject ast : astJson) {
            String name = getParameter(ast,"name").getAsString();
            double magnitude = getParameter(ast,"absolute_magnitude_h").getAsDouble();
            boolean dangerous = getParameter(ast,"is_potentially_hazardous_asteroid").getAsBoolean();
            JsonElement kilometers = getSubParameter(ast,"estimated_diameter","kilometers");
            double avgKilometer = 0.5 * (
                    getParameter(kilometers.getAsJsonObject(),"estimated_diameter_min").getAsDouble() +
                    getParameter(kilometers.getAsJsonObject(),"estimated_diameter_max").getAsDouble());
            Asteroid asteroid = new Asteroid(name,magnitude,avgKilometer,dangerous,true);
            asteroid.setAprochments(
                    getAproaches(
                            getParameter(ast,"close_approach_data").getAsJsonArray(), asteroid));
            asteroids.add(asteroid);
        }
        return asteroids;
    }

    public List<Aproach> getAproaches(JsonArray aproaches,Asteroid ast) {
        List<Aproach> returnAproaches = new ArrayList<>();
        for(JsonElement aproach : aproaches){
            LocalDate date = LocalDate.parse(getParameter(aproach.getAsJsonObject(),"close_approach_date").getAsString());
            double velocity = getSubParameter(aproach.getAsJsonObject(),"relative_velocity","kilometers_per_second").getAsDouble();
            double distance = getSubParameter(aproach.getAsJsonObject(),"miss_distance","astronomical").getAsDouble();
            String orbitingBody = getParameter(aproach.getAsJsonObject(),"orbiting_body").getAsString();
            returnAproaches.add(new Aproach(date,velocity,distance,orbitingBody,ast));
        }
        System.out.println(returnAproaches);
        return returnAproaches;
    }

    public JsonElement getParameter(JsonObject json,String parameter) {
        return json.get(parameter);
    }

    public JsonElement getSubParameter(JsonObject json,String parameter,String subParameter) {
        return json.get(parameter).getAsJsonObject()
                .get(subParameter);
    }
}
