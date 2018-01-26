package agh.cs.airly;

import static java.lang.System.exit;
import static java.lang.System.out;


public class ExceptionHandler {

    public static void handle (int message) {

        if (message == 400)
            out.println("Input validation error");
        else if (message == 401	) out.println("Unauthorized");
        else if (message == 403 ) out.println("Forbidden");
        else if ( message == 404 ) out.println("Not Found");
        else out.println("Unexpected error");
        exit(0);

    }

}
