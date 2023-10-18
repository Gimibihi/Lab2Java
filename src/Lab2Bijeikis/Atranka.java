package Lab2Bijeikis;

import studijosKTU.ListKTU;

import java.util.Objects;

/**
 * Klasė atrankom pagal filtra atlikimui
 */
public class Atranka {
    /**
     * Konstruktorius
     */
    public Atranka(){};

    /**
     * Atranka pagal procesoriaus gamintojus
     * @param Kompiuteriai Duomenų sarasas
     * @param filtras Filtras pagal kuri atrinkti
     * @return Naujai sukurta sarara pagal filtra
     */
    public ListKTU procesoriausGamintojas(ListKTU Kompiuteriai, String filtras){
        Kompiuteris element;
        ListKTU KompListNew = new ListKTU();
        for(int i=0;i<Kompiuteriai.size();i++){
            element = (Kompiuteris) Kompiuteriai.get(i);
            if(element.getProcesoriausGamintojas().toLowerCase().compareTo(filtras.toLowerCase())==0){
                KompListNew.add(element);
            }
        }
        return KompListNew;
    }
    /**
     * Atranka pagal procesoriaus Modeli
     * @param Kompiuteriai Duomenų sarasas
     * @param filtras Filtras pagal kuri atrinkti
     * @return Naujai sukurta sarara pagal filtra
     */
    public ListKTU procesoriausModelis(ListKTU Kompiuteriai, String filtras){
        Kompiuteris element;
        ListKTU KompListNew = new ListKTU();
        for(int i=0;i<Kompiuteriai.size();i++){
            element = (Kompiuteris) Kompiuteriai.get(i);
            if(element.getProcesoriausModelis().toLowerCase().compareTo(filtras)==0){
                KompListNew.add(element);
            }
        }
        return KompListNew;
    }
    /**
     * Atranka pagal Ramu Kieki
     * @param Kompiuteriai Duomenų sarasas
     * @param filtras Filtras pagal kuri atrinkti
     * @return Naujai sukurta sarara pagal filtra
     */

    public ListKTU ramKiekis(ListKTU Kompiuteriai, String filtras){
        Kompiuteris element;
        ListKTU KompListNew = new ListKTU();
        for(int i=0;i<Kompiuteriai.size();i++){
            element = (Kompiuteris) Kompiuteriai.get(i);
            if(element.getRamuKiekis() == filtras){
                KompListNew.add(element);
            }
        }
        return KompListNew;
    }
}
