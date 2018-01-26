package agh.cs.airly;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.*;
import java.lang.Exception;


public class HTTPConnection {

    private HttpURLConnection httpURLConnection;


    public void connect(URL url, ApiKey apiKey) throws IOException, Exception {

        this.httpURLConnection = (HttpURLConnection) url.openConnection();
        this.httpURLConnection.setRequestMethod("GET");                     // send GET request

        this.httpURLConnection.setRequestProperty("Accept", "application/json");
        this.httpURLConnection.setRequestProperty("apikey", apiKey.getApiKey());

        if (httpURLConnection.getResponseCode() != 200) {
            ExceptionHandler.handle( httpURLConnection.getResponseCode() );
        }
    }


    public JSONObject createJSON () throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ( (line = br.readLine()) != null ) {
            sb.append(line);
        }

        JSONObject json = new JSONObject(sb.toString());
        return json;


    }


}