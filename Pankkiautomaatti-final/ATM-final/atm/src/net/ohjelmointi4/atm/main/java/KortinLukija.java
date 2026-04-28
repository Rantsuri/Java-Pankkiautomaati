package net.ohjelmointi4.atm.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KortinLukija {

    private File kortti;

    public KortinLukija() {
    }

    public boolean korttiOnOlemassa(String pin) {

        kortti = new File(pin + ".txt");
        return kortti.exists();

    }

    public String getKortti() {
        return kortti.getPath();
    }

    public double Saldo() throws FileNotFoundException {
        try {
            Scanner lukija = new Scanner(kortti);
            lukija.nextLine();
            double saldo = Double.parseDouble(lukija.nextLine());
            lukija.close();
            return saldo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("virhe" + e.getMessage(), e);
        }

    }

    public double nostoMaara() throws FileNotFoundException {
        try {
            Scanner lukija = new Scanner(kortti);
            lukija.nextLine();
            lukija.nextLine();
            double nostoMaara = Double.parseDouble(lukija.nextLine());
            lukija.close();
            return nostoMaara;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("virhe" + e.getMessage());

        }
    }

}
