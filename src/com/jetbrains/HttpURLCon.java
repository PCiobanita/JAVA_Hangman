package com.jetbrains;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLCon {
    API_KEY key = new API_KEY();

    public String sendGet() throws Exception {
        String API_KEY = "MBX7GD4X";
        String url = "https://random-word-api.herokuapp.com/word?key=" + key.getApiKey() + "&number=1";
        String randomWord;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Request header
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        System.out.println(response);

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String responseString = response.toString();
        randomWord = responseString.replaceAll("[^A-Za-z]+", "");
        return randomWord;
    }

}
