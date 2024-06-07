package exec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import exec.ODER;
import exec.UND;
import exec.XOR;

public class GatterMain {

    public static void main(String[] args) {



        UND undGatter = new UND();
        UND undGatter2 = new UND();
        ODER orGatter = new ODER();
        XOR xorGatter = new XOR();
        NOT notGatter = new NOT();


        undGatter.setA(1);
        undGatter.setB(1);


        System.out.println("UND Gatter: " + undGatter.getAusgabe());

        undGatter2.setA(0);
        undGatter2.setB(1);

        System.out.println("UND Gatter: " + undGatter2.getAusgabe());


        ArrayList<Gatter> gatterListe = new ArrayList<>();
        gatterListe.add(undGatter);
        gatterListe.add(undGatter2);


        System.out.println(gatterListe);
        for (Gatter gatter : gatterListe){
            System.out.println(gatter);
        }
        int index = 0;
        System.out.println("Das Element am Index " + index + " ist ein: "+  gatterListe.get(index));
/*
        ArrayList<String> gatter = new ArrayList<>();
        gatter.add("UND");
        gatter.add("ODER");
        gatter.add("XOR");

        ArrayList<Boolean> und = new ArrayList<>();
        und.add(undGatter.getA());
        und.add(undGatter.getB());
        und.add(undGatter.getAusgabe());

        System.out.println(und);
        System.out.println("Elemente in der ArrayList:");
        for (String gatterName : gatter){
            System.out.println(gatterName);
        }
        System.out.println(gatter);
*/

    }

}