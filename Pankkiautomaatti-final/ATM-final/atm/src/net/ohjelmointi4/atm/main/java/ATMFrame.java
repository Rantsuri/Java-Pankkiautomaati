package net.ohjelmointi4.atm.main.java;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ATMFrame extends JFrame {
    //Paneelien valinta, init ja ohjaus

    private CardLayout layoutti;
    private JPanel paneeli;
    private KortinLukija lukija;
    private KiitosKaynnistaPaneeli ajastin;
    private OtaMassitPaneeli ajastin2;
    private OtaKuitti ajastin3;
    private TapahtumatPaneeli tapahtumat;
    private SaldoPaneeli saldoPaneeli;
    private KirjauduPaneeli kirjaudu;
    final static String NOSTO = "NOSTO";
    final static String ETU = "ETU";
    final static String TAPAHTUMAT = "TAPAH";
    final static String SALDO = "SALDO";
    final static String KIRJAUDU = "KIRJAUDU";
    final static String LOPETA = "LOPETA";
    final static String OTAMASSIT = "OTAMASSIT";
    final static String KIITOSHEI = "KIITOSHEI";
    final static String KUITTI = "OTAKUITTI";

    public ATMFrame() {
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        lukija = new KortinLukija();
        ajastin = new KiitosKaynnistaPaneeli(this);
        layoutti = new CardLayout();
        paneeli = new JPanel(layoutti);
        ajastin2 = new OtaMassitPaneeli(this, ajastin);
        ajastin3 = new OtaKuitti(this, ajastin);
        tapahtumat = new TapahtumatPaneeli(this, ajastin3, ajastin);
        saldoPaneeli = new SaldoPaneeli(this, lukija);
        kirjaudu = new KirjauduPaneeli(this, lukija);

        paneeli.add(new EtuSivuPaneeli(this, tapahtumat), ETU);
        paneeli.add(new NostoPaneeli(this, ajastin2, lukija), NOSTO);
        paneeli.add(kirjaudu, KIRJAUDU);
        paneeli.add(new LopetaKayttoPaneeli(this, ajastin), LOPETA);
        paneeli.add(ajastin2, OTAMASSIT);
        paneeli.add(tapahtumat, TAPAHTUMAT);
        paneeli.add(new KiitosKaynnistaPaneeli(this), KIITOSHEI);
        paneeli.add(saldoPaneeli, SALDO);
        paneeli.add(new OtaKuitti(this, ajastin), KUITTI);

        add(paneeli);
        layoutti.show(paneeli, KIRJAUDU);
        setVisible(true);
    }

    public void naytto(String naytonNimi) {
        layoutti.show(paneeli, naytonNimi);
        if(naytonNimi.equals(ATMFrame.SALDO)){
            saldoPaneeli.saldoJaNostoMaara();
        }
        if(naytonNimi.equals(ATMFrame.KIRJAUDU)){
            kirjaudu.nappainKentta(true);
        }

    }

    
}
