package net.ohjelmointi4.atm.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KortinLukija {

    private File OikeaKortti;
    private String tiliNimi;
    private String OikeaPinKoodi;

    public KortinLukija() {
    }

    public boolean korttiOnOlemassa(String pin) {

        File tiedosto = new File(".");
        File[] kortit = tiedosto.listFiles((d, name) -> name.endsWith(".txt"));
        File kortti1 = kortit[0];
        String pinkoodi = kortti1.getName().replace(".txt", "");
        try {
            Scanner lukija = new Scanner(kortti1);
            tiliNimi = lukija.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if(pinkoodi.equals(pin)){
            OikeaKortti = kortti1;
            OikeaPinKoodi = pin;
            return true;
        }

        return false;

    }

    public String getKortti() {
        return OikeaKortti.getPath();
    }

    public double Saldo() throws FileNotFoundException {
        try {
            Scanner lukija = new Scanner(OikeaKortti);
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
            Scanner lukija = new Scanner(OikeaKortti);
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

    public String tiliNimi()  {
        return tiliNimi;
    }
}
