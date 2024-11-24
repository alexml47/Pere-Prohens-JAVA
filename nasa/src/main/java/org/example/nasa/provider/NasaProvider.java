package org.example.nasa.provider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NasaProvider {

    public static List<JsonObject> getDates(String API_KEY){
        String URL = "https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=" + API_KEY;
        String response = request(URL);
        return toJsonArray(response);
    }
    private static String request(String URL) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            return getResponse.body();
        } catch (InterruptedException | URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<JsonObject> toJsonArray(String response) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response, JsonObject.class);
        return json.get("near_earth_objects")
                .getAsJsonArray()
                .asList()
                .stream()
                .map(JsonElement::getAsJsonObject)
                .toList();
    }
}
