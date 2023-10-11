package Lab2Bijeikis;

import studijosKTU.ListKTU;

import java.util.Objects;

public class Atranka {

    public Atranka(){};

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

    public ListKTU procesoriausModelis(ListKTU Kompiuteriai, String filtras){
        Kompiuteris element;
        ListKTU KompListNew = new ListKTU();
        for(int i=0;i<Kompiuteriai.size();i++){
            element = (Kompiuteris) Kompiuteriai.get(i);
            if(element.getProcesoriausModelis().compareTo(filtras)==0){
                KompListNew.add(element);
            }
        }
        return KompListNew;
    }

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
