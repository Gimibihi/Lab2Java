package Lab2Bijeikis;

import Laboras2demo.Automobilis;
import studijosKTU.KTUable;
import studijosKTU.Ks;
import studijosKTU.ListKTU;

import java.util.*;

public class Kompiuteris implements KTUable<Kompiuteris> {
    private String procesoriausGamintojas;
    private String procesoriausModelis;
    private String ramuKiekis;
    private String kietojoDiskoVieta;
    private int nasumas;
    private double kaina;

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public String getProcesoriausGamintojas() {
        return procesoriausGamintojas;
    }

    public String getProcesoriausModelis() {
        return procesoriausModelis;
    }

    public int getNasumas() {
        return nasumas;
    }

    public String getRamuKiekis() {
        return ramuKiekis;
    }

    public Kompiuteris(){}
    public Kompiuteris(String procesoriausGamintojas,String procesoriausModelis, String ramuKiekis,
                       String kietojoDiskoVieta, int nasumas, double kaina){
        this.procesoriausGamintojas = procesoriausGamintojas;
        this.procesoriausModelis = procesoriausModelis;
        this.ramuKiekis = ramuKiekis;
        this.kietojoDiskoVieta = kietojoDiskoVieta;
        this.nasumas = nasumas;
        this.kaina = kaina;
    }
    public Kompiuteris(String dataString){
        this.parse(dataString);
    }
    @Override
    public Kompiuteris create(String dataString) {
        return new Kompiuteris(dataString);
    }

    @Override
    public String validate() {
        return null;
    }

    @Override
    public int compareTo(Kompiuteris o) {
        return 0;
    }
    public final void parse(String dataString) {
        try {
            String[] data = dataString.split(";");
            procesoriausGamintojas = data[0];
            procesoriausModelis = data[1];
            ramuKiekis = data[2];
            kietojoDiskoVieta = data[3];
            nasumas = Integer.parseInt(data[4]);
            try {
                setKaina(Double.parseDouble(data[5]));
            }
                catch(NumberFormatException e){
                String line = data[5].replace(',','.');
                setKaina(Double.parseDouble(line));
                }

        } catch (InputMismatchException e) {
            Ks.ern("Blogas duomenų formatas apie kompiuterį -> " + dataString);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie kompiuterį -> " + dataString);
        }
    }

    @Override
    public String toString() {
        return  String.format("| %-23s | %-20s | %11s | %19s | %7d | %7.2f |\n"+
                        "|--------------------------------------------------------------------------------------------------------|\n",
                        procesoriausGamintojas,procesoriausModelis,ramuKiekis,kietojoDiskoVieta,nasumas,kaina);
    }
    public String[] toStringArray(){
        String[] array = {procesoriausGamintojas,procesoriausModelis,ramuKiekis,kietojoDiskoVieta,Integer.toString(nasumas),Double.toString(kaina)};
        return array;
    }

    public final static Comparator<Kompiuteris> pagalGamintoja = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = komp1.getProcesoriausGamintojas().compareTo(komp2.getProcesoriausGamintojas());
            return cmp;
        }
    } ;

    public final static Comparator<Kompiuteris> pagalModeli = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = komp1.getProcesoriausModelis().compareTo(komp2.getProcesoriausModelis());
            return cmp;
        }
    } ;

    public final static Comparator<Kompiuteris> pagalNasuma = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = -1;
            if(komp1.getNasumas() > komp2.getNasumas())
                cmp = 1;
            else if(komp1.getNasumas() == komp2.getNasumas())
                cmp = 0;
            return cmp;
        }
    } ;

    public final static Comparator<Kompiuteris> pagalKaina = new Comparator<Kompiuteris>() {
        @Override
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = -1;
            if(komp1.getKaina() > komp2.getKaina())
                cmp = 1;
            else if(komp1.getKaina() == komp2.getKaina())
                cmp = 0;
            return cmp;
        }
    };
}
