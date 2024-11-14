import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=MzHYWv6eaaxfR5b6unKvncJYTq0jX4br1mhNd7Ib"))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString = getResponse.body();



        List<JsonObject> result = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        result.addAll(jsonObject.get("near_earth_objects")
                .getAsJsonArray()
                .asList()
                .stream()
                .map(JsonElement::getAsJsonObject)
                .toList());


        String kim = result.get(0)
                .get("close_approach_data").getAsJsonArray()
                        .get(0).getAsJsonObject()
                .get("close_approach_date_full").toString();

        System.out.println(kim);
    }
}
