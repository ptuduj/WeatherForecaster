package agh.cs.airly;

import java.util.List;
import static java.lang.System.out;

public class HistoryPrinter {


    public final static int shortLength = 140 /10;
    private static String line = "+------------------------------------------------------------------------------------------------------------------------------------------+";

    public static void printHistory(List<HistoricalMeasurements> list) {

        out.print(line);
        out.print("\n|    time    |   quality   |     AQ1     |      pm1    |     pm2.5   |     pm10    |    level    |   pressure  |     temp    |   humidity  |");
        out.print("\n" + line);

        for (HistoricalMeasurements hm: list) {
            String s =("\n| "+hm.fromDate + " - " + hm.tillDate);
            printString(s, shortLength);
            s= "| "+ hm.getPollutionInformation();
            printString(s, shortLength);
            s = "| " + hm.getAirQualityIndex();
            printString(s, shortLength);
            s = "| " + hm.getPm1() + hm.pmUnit;
            printString(s, shortLength);
            s = "| " + hm.getPm25() + hm.pmUnit;
            printString(s, shortLength);
            s = "| " + hm.getPm10() + hm.pmUnit ;
            printString(s, shortLength);
            s = "|   " + hm.getPollutionLevel();
            printString(s, shortLength);
            s = "| " + hm.getPressure() + hm.presseureUnit;
            printString(s, shortLength);
            s = "|    " + hm.getTemperature() + hm.percent;
            printString(s, shortLength);
            s = "|    " + hm.getHumidity() + hm.percent;
            printString(s, shortLength);
            out.print("|\n"+line);

        }
    }

    public static void printString(String s, int lineLength) {
        out.print( s );
        for (int i=0; i < (lineLength -  s.length() ); i++) out.print(" ");

    }


}
