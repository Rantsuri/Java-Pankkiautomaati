package net.ohjelmointi4.atm.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KortinLukija {
    private File kortti;
    public KortinLukija( ){
    }

    public boolean korttiOnOlemassa(String pin){
        
        File kortti = new File(pin + ".txt");
        return kortti.exists();

    }

    public double Saldo() throws FileNotFoundException{
        try {
        Scanner lukija = new Scanner(kortti);
        double saldo = Double.parseDouble(lukija.nextLine());
        lukija.close();
        return saldo;
        } catch (Exception e) {
            return 1234;
        }
       
    }

    public double NostoMaara() throws FileNotFoundException{
        Scanner lukija = new Scanner(kortti);
        lukija.nextLine();
        double nostoMaara = Double.parseDouble(lukija.nextLine());
        return nostoMaara;
    }
    
}
