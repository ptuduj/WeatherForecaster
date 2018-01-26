package agh.cs.airly;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Printer {

    public static void printHelp() {
        out.println("To check air quality for a specyfic location use these options: ");
        out.println("-latitude      set latitude");
        out.println("-longitude     set longitude");
        out.println("-sensor-id     set sensor ID");
        out.println("-history       view historical measurements");
        exit(0);
    }

    public static void printNoData() {
        out.println("Sorry, but we don't have data for this location.");
        exit(0);
    }

    public static void printString(String s, int lineLength) {
        out.print( s );
        for (int i=0; i < (lineLength -  s.length() ); i++) out.print(" ");

    }


}