package Lab2Bijeikis;

import Laboras2demo.Automobilis;
import studijosKTU.KTUable;
import studijosKTU.Ks;
import studijosKTU.ListKTU;

import java.util.*;

public class Kompiuteris implements KTUable<Kompiuteris> {
    private String procesoriausGamintojas;
    private String procesoriausModelis;
    private int ramuKiekis;
    private int kietojoDiskoVieta;
    private int nasumas;
    private double kaina;

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public String getProcesoriausGamintojas() {
        return procesoriausGamintojas;
    }

    public Kompiuteris(){}
    public Kompiuteris(String procesoriausGamintojas,String procesoriausModelis, int ramuKiekis,
                       int kietojoDiskoVieta, int nasumas, double kaina){
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
            Scanner ed = new Scanner(dataString);
            ed.useDelimiter(";");
            // numatytieji skirtukai: tarpas, tab, eilutės pabaiga
            // Skiriklius galima pakeisti Scanner klasės metodu useDelimitersr
            //	Pavyzdžiui, ed.useDelimiter(", *"); reikštų, kad skiriklis bus kablelis ir vienas ar daugiau tarpų.
            procesoriausGamintojas = ed.next();
            procesoriausModelis = ed.next();
            ramuKiekis = ed.nextInt();
            kietojoDiskoVieta = ed.nextInt();
            nasumas = ed.nextInt();
            setKaina(ed.nextDouble());
        } catch (InputMismatchException e) {
            Ks.ern("Blogas duomenų formatas apie kompiuterį -> " + dataString);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie kompiuterį -> " + dataString);
        }
    }

    @Override
    public String toString() {
        return "Kompiuteris{" +
                "procesoriausGamintojas='" + procesoriausGamintojas + '\'' +
                ", procesoriausModelis='" + procesoriausModelis + '\'' +
                ", ramuKiekis=" + ramuKiekis +
                ", kietojoDiskoVieta=" + kietojoDiskoVieta +
                ", nasumas=" + nasumas +
                ", kaina=" + kaina +
                '}';
    }

    public final static Comparator<Kompiuteris> pagalGamintoja = new Comparator <Kompiuteris>(){
        public int compare(Kompiuteris komp1, Kompiuteris komp2) {
            int cmp = komp1.getProcesoriausGamintojas().compareTo(komp2.getProcesoriausGamintojas());
            return cmp;
        }
    } ;

    public static void main(String[] args) {
        Kompiuteris komp1 = new Kompiuteris("Intel", "i7",16,256,12508,1549);
        Kompiuteris komp2 = new Kompiuteris("Intel", "i5",8,512,8508,899);
        Kompiuteris komp3 = new Kompiuteris("AMD", "Ryzen 5",32,1064,13570,1299);
        Kompiuteris komp4 = new Kompiuteris("Intel", "Xeon",256,8320,19000,5499);
        Kompiuteris komp5 = new Kompiuteris("AMD", "Ryzen 7",64,1064,14508,1349);
        Kompiuteris komp6 = new Kompiuteris("AMD", "Threadripper",128,8320,16508,3849);
        ListKTU kompiuteriai = new ListKTU();
        kompiuteriai.add(komp1);
        kompiuteriai.add(komp2);
        kompiuteriai.add(komp3);
        kompiuteriai.add(komp4);
        kompiuteriai.add(komp5);
        kompiuteriai.add(komp6);
        kompiuteriai.sortBuble(pagalGamintoja);
        System.out.println(kompiuteriai.get(0).toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
    }
}
