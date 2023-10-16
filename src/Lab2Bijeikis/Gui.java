package Lab2Bijeikis;

import studijosKTU.ListKTU;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gui extends JFrame {
    private JPanel panelMain;
    private JTable table;
    private JLabel label;
    private JMenuBar meniuBaras;
    private static ListKTU kompiuteriai;
    private DefaultTableModel tableModel;
    public Gui() {
        initialize();
    }
    public void initialize(){
        setTitle("Programa");
        setContentPane(panelMain);
        meniuBaras = new JMenuBar();
        setJMenuBar(meniuBaras);
        Font f = new Font("Courier New", Font.PLAIN, 12);
        JMenu mFailai = new JMenu("Failai");
        meniuBaras.add(mFailai);
        JMenu mKomp = new JMenu("Kompiuterių apskaita");
        meniuBaras.add(mKomp);
        JMenuItem miSkaityti = new JMenuItem("Skaityti iš failo...");
        mFailai.add(miSkaityti);
        miSkaityti.addActionListener(e1 -> readFromFile(e1));
        JMenuItem miBaigti = new JMenuItem("Pabaiga");
        mFailai.add(miBaigti);
        table.setFont(f);
        table.setVisible(true);


        miBaigti.addActionListener((ActionEvent e) -> System.exit(0));

        JMenuItem miGamintojas = new JMenuItem("Atranka pagal gamintoją…");
        mKomp.add(miGamintojas);
        miGamintojas.addActionListener(this::atrankaPagalGamintoja);

        JMenuItem miModelis = new JMenuItem("Atranka pagal modeli…");
        mKomp.add(miModelis);
        miModelis.addActionListener(this::atrankaPagalModeli);

        JMenuItem miKaina = new JMenuItem("Surikiuoja pagal kainą");
        mKomp.add(miKaina);
        miKaina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               kompiuteriai.sortBuble(Kompiuteris.pagalKaina);
                displayText("Surikiuoti Duomenys",kompiuteriai);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,900);
        setVisible(true);
    }

    private void atrankaPagalGamintoja(ActionEvent e1) {
        String filter = null;
        filter = JOptionPane.showInputDialog(panelMain,"","Iveskite Gamintoja",1);
        Atranka atr = new Atranka();
        ListKTU atrinktiKompiuteriai = atr.procesoriausGamintojas(kompiuteriai,filter);
        displayText("Atrinkti pagal gamintoja "+filter,atrinktiKompiuteriai);
    }
    private void atrankaPagalModeli(ActionEvent e1) {
        String filter = null;
        filter = JOptionPane.showInputDialog(panelMain,"","Iveskite Modeli",1);
        Atranka atr = new Atranka();
        ListKTU atrinktiKompiuteriai = atr.procesoriausModelis(kompiuteriai,filter);
        displayText("Atrinkti pagal modeli "+filter,atrinktiKompiuteriai);
    }
    private void readFromFile(ActionEvent e1) {
        JFileChooser fc = new JFileChooser(".");
        fc.showOpenDialog(panelMain);
        File file = new File(String.valueOf(fc.getSelectedFile()));
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
        displayText("Pradiniai Duomenys",kompiuteriai);
    }

    public void displayText(String antraste, ListKTU kompiuteriai){
        label.setText("\n"+antraste+"\n");
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Gamintojas");
        tableModel.addColumn("Modelis");
        tableModel.addColumn("Ramų Kiekis");
        tableModel.addColumn("Disko vieta");
        tableModel.addColumn("Nasumas");
        tableModel.addColumn("Kaina");
        if(kompiuteriai.get(0)!=null){
            for(int i=0;i<kompiuteriai.size();i++){
                tableModel.addRow(((Kompiuteris) kompiuteriai.get(i)).toStringArray());
            }
            table.setModel(tableModel);
        }
        else label.setText("Nėra duomenų");
    }


    public static void main(String[] args) {

        kompiuteriai = new ListKTU();
        Gui gui = new Gui();
        /*Kompiuteris komp1 = new Kompiuteris("Intel", "i7", 16, 256, 12508, 1549);
        Kompiuteris komp2 = new Kompiuteris("Intel", "i5", 8, 512, 8508, 899);
        Kompiuteris komp3 = new Kompiuteris("AMD", "Ryzen 5", 32, 1064, 13570, 1299);
        Kompiuteris komp4 = new Kompiuteris("Intel", "Xeon", 256, 8320, 19000, 5499);
        Kompiuteris komp5 = new Kompiuteris("AMD", "Ryzen 7", 64, 1064, 14508, 1349);
        Kompiuteris komp6 = new Kompiuteris("AMD", "Threadripper", 128, 8320, 16508, 3849);

        kompiuteriai.add(komp1);
        kompiuteriai.add(komp2);
        kompiuteriai.add(komp3);
        kompiuteriai.add(komp4);
        kompiuteriai.add(komp5);
        kompiuteriai.add(komp6);
        kompiuteriai.sortBuble(Kompiuteris.pagalGamintoja);
        System.out.println("Rikiavimas Pagal Gamintoja\n");
        System.out.println(kompiuteriai.get(0).toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        kompiuteriai.sortBuble(Kompiuteris.pagalModeli);
        System.out.println("\nRikiavimas Pagal Modeli\n");
        System.out.println(kompiuteriai.get(0).toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        kompiuteriai.sortBuble(Kompiuteris.pagalNasuma);
        System.out.println("\nRikiavimas Pagal Nasuma\n");
        System.out.println(kompiuteriai.get(0).toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString());
        System.out.println(kompiuteriai.getNext().toString()); */
    }
}
