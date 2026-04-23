package net.ohjelmointi4.atm.main.java;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ATMFrame extends JFrame{
 //toimiiko tää
    private CardLayout layoutti;
    private JPanel paneeli;
    private KortinLukija lukija;
    final static String NOSTO = "NOSTO";
    final static String ETU = "ETU";
    final static String TAPAHTUMAT = "TAPAH";
    final static String SALDO = "SALDO";
    final static String KIRJAUDU = "KIRJAUDU";
    final static String LOPETA = "LOPETA";
    final static String OTAMASSIT = "OTAMASSIT";
    final static String KIITOSHEI = "KIITOSHEI";


    public ATMFrame(){
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        lukija = new KortinLukija( );
        layoutti = new CardLayout();
        paneeli = new JPanel(layoutti);
        
        //TODO: navigointi paneeline välillä....
        /*
        
        
        */

        paneeli.add(new EtuSivuPaneeli(this), ETU);
        paneeli.add(new NostoPaneeli(this), NOSTO);
        paneeli.add(new KirjauduPaneeli(this, lukija), KIRJAUDU);
       
        paneeli.add(new LopetaKayttoPaneeli(this), LOPETA);
        paneeli.add(new OtaMassitPaneeli(this) ,OTAMASSIT);
        paneeli.add(new TapahtumatPaneeli(this), TAPAHTUMAT);
        paneeli.add(new KiitsJnePaneeli(this), KIITOSHEI);
        paneeli.add(new SaldoPaneeli(this, lukija), SALDO);
        
        add(paneeli);
        layoutti.show(paneeli, KIRJAUDU);
        setVisible(true);
    }

    public void naytto(String naytonNimi){
        layoutti.show(paneeli, naytonNimi);
    }

    public void lopetaKaytto(){
        layoutti.show(paneeli, KIRJAUDU);
    }
}
