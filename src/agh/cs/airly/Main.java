package agh.cs.airly;

import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import static java.lang.System.out;

public class Main {

    public static void main (String[] args) {

        OptionsParser optionsParser = new OptionsParser( args );
        optionsParser.parseOptions();

        try {
            UrlMaker urlMaker = new UrlMaker();

            URL url =
                    urlMaker.createURL( optionsParser.getOptions(), optionsParser.getLocation(), optionsParser.getSensor());

            HTTPConnection connection = new HTTPConnection();
            connection.connect(url, optionsParser.getApiKey());
            JSONObject json = connection.createJSON();
            DataParser dataParser = new DataParser(json, optionsParser.getOptions());
            dataParser.parseData();

        }
        catch (MalformedURLException e) {e.getMessage();}
        catch (IOException e) {e.getMessage();}
        catch (Exception e) {e.getMessage();}

    }
}
