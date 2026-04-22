package net.ohjelmointi4.atm.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KortinLukija {
    private File kortti;
    private KirjauduPaneeli kirjaudu;
    public KortinLukija( KirjauduPaneeli kirjaudu){
        this.kirjaudu = kirjaudu;
    }

    public boolean korttiOnOlemassa(){
        char[] pin = kirjaudu.getPinKentta();
        String pinOikea = new String(pin);
        File kortti = new File(pinOikea + ".txt");
        return kortti.exists();

    }

    public double Saldo() throws FileNotFoundException{
        Scanner lukija = new Scanner(kortti);
        double saldo = Double.parseDouble(lukija.nextLine());
        lukija.close();
        return saldo;
    }

    public double NostoMaara() throws FileNotFoundException{
        Scanner lukija = new Scanner(kortti);
        lukija.nextLine();
        double nostoMaara = Double.parseDouble(lukija.nextLine());
        return nostoMaara;
    }
    
}
