package de.groygroy.linuxmagazin.java26;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LazyConstants {

    static final LocalTime START = LocalTime.now();
    static final LazyConstant<LocalTime> LAZY = LazyConstant.of( LocalTime::now);
    static final List<String> NAMEN =
            List.ofLazy(10, i -> createString(i));
    static final DateTimeFormatter ZEIT_FORMAT = DateTimeFormatter.ofPattern("hh:mm:ss.SS");

    private static String createString(int index) {
        var s = Double.toString(Math.pow(2, index));
        System.out.println("   Erzeuge für Index "  + index + " --> '" + s + "'");
        return s;
    }

    void main() throws Exception {

        System.out.println("         Start: " + ZEIT_FORMAT.format(START));
        Thread.currentThread().sleep(10000);
        System.out.println("1. Lesezugriff: " + ZEIT_FORMAT.format(LAZY.get()));
        Thread.currentThread().sleep(10000);
        System.out.println("2. Lesezugriff: " + ZEIT_FORMAT.format(LAZY.get()));

        System.out.println("");

        System.out.println("Wert für 2. " + NAMEN.get(2));

        for (int i = 0; i < 4;i++) {
            System.out.println( "Wert für  " + i + ". -->'" + NAMEN.get(i)+ "'");
        }

//        try {
//            NAMEN.set(3, "geht nicht");
//        } catch ( Exception e) {
//            e.printStackTrace();
//        }


    }


}
