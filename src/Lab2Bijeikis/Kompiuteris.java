package Lab2Bijeikis;

import Laboras2demo.Automobilis;
import studijosKTU.KTUable;
import studijosKTU.Ks;
import studijosKTU.ListKTU;

import java.util.*;

/**
 * Duomenų klasė
 */
public class Kompiuteris implements KTUable<Kompiuteris> {
    private String procesoriausGamintojas;
    private String procesoriausModelis;
    private String ramuKiekis;
    private String kietojoDiskoVieta;
    private int nasumas;
    private double kaina;

    /**
     * Metodas Paimti Kainai
     * @return Kaina
     */
    public double getKaina() {
        return kaina;
    }

    /**
     * Metodas nustatyti kainai
     * @param kaina kainos reiksme
     */
    public void setKaina(double kaina) {
        this.kaina = kaina;
    }
    /**
     * Metodas Paimti Procesoriaus Gamintojui
     * @return procesoriaus gamintojas
     */
    public String getProcesoriausGamintojas() {
        return procesoriausGamintojas;
    }

    /**
     * Metodas nustatyti procesoriaus Gamintoja
     * @param procesoriausGamintojas
     */
    public void setProcesoriausGamintojas(String procesoriausGamintojas) {
        this.procesoriausGamintojas = procesoriausGamintojas;
    }

    /**
     * Metodas Paimti procesoriaus modeli
     * @return procesoriaus modeli
     */
    public String getProcesoriausModelis() {
        return procesoriausModelis;
    }

    /**
     * Metodas nustatyti procesoriaus modeli
     * @param procesoriausModelis
     */
    public void setProcesoriausModelis(String procesoriausModelis) {
        this.procesoriausModelis = procesoriausModelis;
    }

    /**
     * Metodas Paimti nasuma
     * @return nasuma
     */
    public int getNasumas() {
        return nasumas;
    }

    /**
     * Metodas nustatyti Nasumas
     * @param nasumas
     */
    public void setNasumas(int nasumas) {
        this.nasumas = nasumas;
    }

    /**
     * Metodas Paimti ramu kieki
     * @return ramu kieki
     */
    public String getRamuKiekis() {
        return ramuKiekis;
    }

    /**
     * Metodas nustatyti Ramu kieki
     * @param ramuKiekis
     */
    public void setRamuKiekis(String ramuKiekis) {
        this.ramuKiekis = ramuKiekis;
    }
    /**
     * Metodas paimti Kietojo disko vieta
     * @return Kietojo disko vieta
     */
    public String getKietojoDiskoVieta() {
        return kietojoDiskoVieta;
    }

    /**
     * Metodas nustatyti kietojo disko vietai
     * @param kietojoDiskoVieta
     */
    public void setKietojoDiskoVieta(String kietojoDiskoVieta) {
        this.kietojoDiskoVieta = kietojoDiskoVieta;
    }

    /**
     * Tuščias Konstruktorius
     */
    public Kompiuteris(){}

    /**
     * Metodas Kuris nieko nedaro
     * @return null
     */
    public String validate(){
        return null;
    }

    /**
     * Konstruktorius
     * @param procesoriausGamintojas Gamintojas procesoriaus
     * @param procesoriausModelis Procesoriaus Modelis
     * @param ramuKiekis Ramu kiekis
     * @param kietojoDiskoVieta Kietojo disko vieta
     * @param nasumas Nasumas
     * @param kaina Kaina
     */
    public Kompiuteris(String procesoriausGamintojas,String procesoriausModelis, String ramuKiekis,
                       String kietojoDiskoVieta, int nasumas, double kaina){
        this.procesoriausGamintojas = procesoriausGamintojas;
        this.procesoriausModelis = procesoriausModelis;
        this.ramuKiekis = ramuKiekis;
        this.kietojoDiskoVieta = kietojoDiskoVieta;
        this.nasumas = nasumas;
        this.kaina = kaina;
    }

    /**
     * Konstrutorius
     * @param dataString duomenu eilute
     */
    public Kompiuteris(String dataString){
        this.parse(dataString);
    }

    /**
     * Metodas sukurti duomenu Klase
     * @param dataString duomenu eilute
     * @return nauja duomenu klase
     */

    public Kompiuteris create(String dataString) {
        return new Kompiuteris(dataString);
    }

    /**
     * Metodas ivesti duomenis i klase is duomenu eilutes
     * @param dataString duomenu eilute
     */
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

    /**
     * Metodas kuris sukuria duomenu eilute
     * @return duomenu eilute
     */
    @Override
    public String toString() {
        return  String.format("| %-23s | %-20s | %11s | %19s | %7d | %7.2f |\n"+
                        "|--------------------------------------------------------------------------------------------------------|\n",
                        procesoriausGamintojas,procesoriausModelis,ramuKiekis,kietojoDiskoVieta,nasumas,kaina);
    }

    /**
     * Metodas kuris sukuria duomenu masyva
     * @return duomenu masyva
     */
    public String[] toStringArray(){
        String[] array = {procesoriausGamintojas,procesoriausModelis,ramuKiekis,kietojoDiskoVieta,Integer.toString(nasumas),Double.toString(kaina)};
        return array;
    }

    /**
     * Komparatorius pagal gamintoja
     */

    public final static Comparator<Kompiuteris> pagalGamintoja = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = komp1.getProcesoriausGamintojas().compareTo(komp2.getProcesoriausGamintojas());
            return cmp;
        }
    } ;
    /**
     * Komparatorius pagal Modeli
     */
    public final static Comparator<Kompiuteris> pagalModeli = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = komp1.getProcesoriausModelis().compareTo(komp2.getProcesoriausModelis());
            return cmp;
        }
    } ;
    /**
     * Komparatorius pagal Nasuma
     */
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
    /**
     * Komparatorius pagal Kaina
     */
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

    /**
     * Tuscias metodas
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Kompiuteris o) {
        return 0;
    }
}
