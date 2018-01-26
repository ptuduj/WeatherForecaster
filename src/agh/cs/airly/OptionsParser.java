package agh.cs.airly;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;
import static java.lang.System.out;

public class OptionsParser {

    private String[] args;
    private ApiKey apiKey;
    private Sensor sensor;
    private Location location;
    private HashMap<Options, String> options;


    public OptionsParser(String[] args) {
        this.args = args;
    }


    public void parseOptions () {

        options = new HashMap <>();
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-key":
                        options.put(Options.apiKey, args[++i]);
                        break;

                    case "-longitude":
                        options.put(Options.longitude, args[++i]);
                        break;

                    case "-latitude":
                        options.put(Options.latitude, args[++i]);
                        break;

                    case "-sensor-id":
                        options.put(Options.sensorID, args[++i]);
                        break;

                    case "-history":
                        options.put(Options.history, args[i]);
                        break;

                    case "-help":
                        options.put(Options.help, args[i]);
                        break;
                    default:
                        options.put(Options.invalid, args[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect arguments! ");
            Printer.printHelp();
            exit(0);
        }
        processOptions();
    }



    private void processOptions () {

        if ( options.containsKey(Options.help) || options.containsKey(Options.invalid))
            Printer.printHelp();

        if ( options.containsKey(Options.apiKey) ) {
            this.apiKey = new ApiKey( options.get(Options.apiKey));
        }
        else  {                       // use environmental variable
            this.apiKey = new ApiKey( System.getenv("API_KEY"));
        }


        if ( options.containsKey(Options.sensorID)) {
            this.sensor = new Sensor( options.get(Options.sensorID) );
        }
        else if ( options.containsKey(Options.latitude) && options.containsKey(Options.longitude)) {
            this.location = new Location( options.get(Options.longitude), options.get(Options.latitude));
        }


    }

    // getters
    public HashMap <Options, String> getOptions() { return options; }

    public Location getLocation() { return location; }

    public Sensor getSensor() { return sensor; }

    public ApiKey getApiKey() { return apiKey; }

}