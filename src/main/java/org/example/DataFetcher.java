package org.example;

//Important Imports for DataFetcher Class

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;


public class DataFetcher {
    // Api url of exchange rate-api
    public static void datafetch() throws IOException {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/bd43f1dabfa343f9370a7350/latest/USD";

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        // Make string pretty
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(jsonobj.toString());
        String prettyJsonString = gson.toJson(jsonElement);
        // Write organized data (prettyJsonString) in file
        FileWriter data = new FileWriter("data.json");
        data.write(prettyJsonString);
        data.close();
        //Conform result
        System.out.println(req_result);
    }

}
