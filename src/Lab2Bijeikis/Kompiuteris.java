package Lab2Bijeikis;

import studijosKTU.KTUable;
import studijosKTU.Ks;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
}
