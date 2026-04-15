package net.ohjelmointi4.atm.main.java;

import java.io.File;

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
}
