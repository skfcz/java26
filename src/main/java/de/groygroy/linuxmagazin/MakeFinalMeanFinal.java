package de.groygroy.linuxmagazin;

import static java.lang.IO.println;

public class MakeFinalMeanFinal {
    void main() throws Exception {

        var beispiel = new Klasse("Brian");
        System.out.println(beispiel);

        // wird vom Kompiler verhindert:
        // beispiel.x=2;

        // Reflektion Magie auf C.x
        java.lang.reflect.Field f = Klasse.class.getDeclaredField("name");
        // hiermit wird final gebrochen
        f.setAccessible(true);

        f.set(beispiel, "Goetz");
        System.out.println("nach dem Ändern " + beispiel);

        f.set(beispiel, null);
        System.out.println("null gesetzt " + beispiel);

    }

    class Klasse {
        final String name;
        Klasse(String n) { name = n; }

        @Override
        public String toString() {
            return "Klasse{" +
                    "name='" + name +"'}'";
        }
    }
}
