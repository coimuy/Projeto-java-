package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon?limit=905"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        ParseJSON(response.body());
    }
        public static void ParseJSON(String list) {
            JSONObject obj = new JSONObject(list);
            List<Pokemon> listPokemon = new ArrayList<Pokemon>();
            JSONArray arr = obj.getJSONArray("results");

            for (int i = 0; i < arr.length(); i++) {
                Pokemon allPokemon = new Pokemon();
                allPokemon.name = arr.getJSONObject(i).getString("name");
                allPokemon.url = arr.getJSONObject(i).getString("url");
                listPokemon.add(allPokemon);
            }
        }
}

