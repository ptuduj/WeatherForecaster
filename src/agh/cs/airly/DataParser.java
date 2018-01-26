package agh.cs.airly;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

public class DataParser {

    public JSONObject jsonObject;
    public HashMap< Options, String > map;


    public DataParser (JSONObject json, HashMap< Options, String> map) {
        this.jsonObject = json;
        this.map = map;
    }


    public void parseData() {
        // current measurements
        if (! map.containsKey(Options.history) ){

            JSONObject object = jsonObject.getJSONObject("currentMeasurements");
            Measurements measurements = fillMeasurements(object);
            if (measurements != null) CurrentPrinter.print (measurements);
            else Printer.printNoData();
        }
        else {                    // historic measurements
            JSONArray jsonArray = jsonObject.getJSONArray("history");
            if (jsonArray != null) {
                List<HistoricalMeasurements> hm =  fillHistoricMeasurements(jsonArray);
                if (hm != null) {
                    hm = cutTime(hm);
                    hm = roundHistValues (hm);
                    HistoryPrinter.printHistory(hm);
                }
            }
            else Printer.printNoData();
        }
    }


    List<HistoricalMeasurements> roundHistValues( List<HistoricalMeasurements> list ) {

        List<HistoricalMeasurements> newList = new ArrayList <>();

        for (HistoricalMeasurements hm: list) {
            newList.add(hm.roundValues());
        }
        return newList;
    }



    public List<HistoricalMeasurements> cutTime (List<HistoricalMeasurements> HMlist) {

        for (HistoricalMeasurements hm: HMlist) {
            hm.fromDate = hm.fromDate.substring(11, 13);
            hm.tillDate = hm.tillDate.substring(11,13);
        }
        return HMlist;
    }



    public Measurements fillMeasurements(JSONObject object) {

        Measurements measurements = null;

        if (object.has("airQualityIndex") && object.has("pm1") && object.has("pm10")
                && object.has("pm25") && object.has("pressure") && object.has("temperature")
                && object.has("pollutionLevel") ) {

            measurements = new Measurements(
                    object.getDouble("airQualityIndex"), object.getDouble("pm1"),
                    object.getDouble("pm10"), object.getDouble("pm25"),
                    object.getDouble("pressure"), object.getDouble("humidity"),
                    object.getDouble("temperature"), object.getDouble("pollutionLevel")
            );
            measurements = measurements.roundValue();
        }
        return measurements;

    }



    public  List<HistoricalMeasurements> fillHistoricMeasurements (JSONArray jsonArray) {

        List<HistoricalMeasurements> measurementsList = new ArrayList<>();

        for (int i=0 ; i< jsonArray.length(); i++) {

            JSONObject object = jsonArray.getJSONObject(i).getJSONObject("measurements") ;

            HistoricalMeasurements hm;

            hm = new HistoricalMeasurements(
                    jsonArray.getJSONObject(i).getString("fromDateTime"),
                    jsonArray.getJSONObject(i).getString("tillDateTime"),
                    object.getDouble("airQualityIndex"), object.getDouble("pm1"),
                    object.getDouble("pm10"), object.getDouble("pm25"),
                    object.getDouble("pressure"), object.getDouble("humidity"),
                    object.getDouble("temperature"), object.getDouble("pollutionLevel")
            ) ;

            if (hm != null) { measurementsList.add(hm); }

        }
        return measurementsList;
    }

}