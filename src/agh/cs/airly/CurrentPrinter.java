package agh.cs.airly;

import static java.lang.System.out;
import static java.lang.System.setProperty;

public class CurrentPrinter {

    public static final int lineLength = 45;


    public static void printHistory (HistoricalMeasurements hm) {

        out.print( "|-------------------------------------------------|");
        printString("|");
        String s = "   From time: " + hm.fromDate + " " + "till: " + hm.tillDate;
        printString(s);
        printString("|");
        print(hm);
    }



    public static void print(Measurements measurements) {

        out.print( "|--------------------------------------------|");
        String s = "|              " + measurements.getPollutionInformation();
        printString(s);
        printString("|");
        s= "|    Air quality index:      " + measurements.getAirQualityIndex();
        printString(s);
        s = "|    pm1:                    " + measurements.getPm1() + measurements.pmUnit;
        printString(s);
        s = "|    pm10:                   " + measurements.getPm10() + measurements.pmUnit;
        printString(s);
        s = "|    pm25:                   " + measurements.getPm25() + measurements.pmUnit;
        printString(s);
        s = "|    pressure:               " + measurements.getPressure() + measurements.presseureUnit;
        printString(s);
        s = "|    humidity:               " + measurements.getHumidity() + measurements.percent;
        printString(s);
        s = "|    temperature:            " + measurements.getTemperature() + measurements.temperatureUnit;
        printString(s);
        s = "|    pollution Level:        " + measurements.getPollutionLevel();
        printString(s);
        s = ("|--------------------------------------------");
        printString(s);
    }

    public static void printString(String s) {
        out.print("\n" + s );
        for (int i=0; i < (lineLength -  s.length() ); i++) out.print(" ");
        out.print("|");
    }
}
