package Lab2Bijeikis;

import studijosKTU.ListKTU;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Klasė greitaveikai testuoti
 */
public class Greitaveika {
    public static void main(String[] args) {
        Generator gen = new Generator();
        gen.Generate(30000);
        ListKTU kompiuteriai = Read();
        long startTime = System.currentTimeMillis();
        Equals(kompiuteriai);
        long endTime = System.currentTimeMillis();
        System.out.printf("Equal metodo greitaveika: "+String.valueOf(endTime-startTime));

        Kompiuteris komp = new Kompiuteris("","","","",0,0);
        startTime = System.currentTimeMillis();
        kompiuteriai.Contains(komp);
        endTime = System.currentTimeMillis();
        System.out.printf("\nContains metodo greitaveika: "+String.valueOf(endTime-startTime));

        startTime = System.currentTimeMillis();
        int index = kompiuteriai.indexOf(komp);
        endTime = System.currentTimeMillis();
        System.out.printf("\nIndexOf metodo greitaveika: "+String.valueOf(endTime-startTime));

        startTime = System.currentTimeMillis();
        Remove(kompiuteriai);
        endTime = System.currentTimeMillis();
        System.out.printf("\nRemove 100 metodo greitaveika: "+String.valueOf(endTime-startTime));

        ListKTU kompClone = kompiuteriai.clone();

        startTime = System.currentTimeMillis();
        kompClone.sortInsertion(Kompiuteris.pagalGamintoja);
        endTime = System.currentTimeMillis();
        System.out.printf("\nRikiavimo metodo greitaveika: "+String.valueOf(endTime-startTime));

        kompClone = kompiuteriai.clone();

        startTime = System.currentTimeMillis();
        kompClone.sortBuble(Kompiuteris.pagalGamintoja);
        endTime = System.currentTimeMillis();
        System.out.printf("\nRikiavimo burb metodo greitaveika: "+String.valueOf(endTime-startTime));

        kompClone = kompiuteriai.clone();

        startTime = System.currentTimeMillis();
        kompClone.sortJava(Kompiuteris.pagalGamintoja);
        endTime = System.currentTimeMillis();
        System.out.printf("\nRikiavimo java metodo greitaveika: "+String.valueOf(endTime-startTime));

    }

    /**
     * Metodas equals metodui tikrinti
     * @param kompiuteriai Duomenų sarasas
     */
    public static void Equals(ListKTU kompiuteriai){
        Kompiuteris komp = new Kompiuteris("","","","",0,0);
        for(int i=0;i<kompiuteriai.size();i++){
            kompiuteriai.getNext();
            kompiuteriai.Equals(komp);
        }
    }

    /**
     * Metodas nuskaityti duomenims iš failo
     * @return Kompiuteriu duomenu sarasa
     */
    public static ListKTU Read(){
        File file = new File("@..//..//Kompiuteriai.txt");
        ListKTU kompiuteriai = new ListKTU();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                Kompiuteris komp = new Kompiuteris();
                komp.parse(sc.nextLine());
                kompiuteriai.add(komp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nepasirinktas joks failas");
        }
        return kompiuteriai;
    }

    /**
     * Metodas tikrinti Remove metodo greitaveika
     * @param kompiuteriai Duomenų sarasas
     */
    public static void Remove(ListKTU kompiuteriai){
        Random random = new Random();
        int index;
        for(int i=0;i<100;i++){
            index = random.nextInt(kompiuteriai.size()-1);
            Kompiuteris komp = (Kompiuteris) kompiuteriai.get(index);
            ListKTU clone = kompiuteriai.clone();
            clone.Remove(komp);
        }
    }
}
