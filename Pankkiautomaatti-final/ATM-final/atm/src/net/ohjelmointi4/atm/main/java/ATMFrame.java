package net.ohjelmointi4.atm.main.java;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ATMFrame extends JFrame {
    //toimiiko tää

    private CardLayout layoutti;
    private JPanel paneeli;
    private KortinLukija lukija;
    private KiitsJnePaneeli ajastin;
    private OtaMassitPaneeli ajastin2;
    private OtaKuitti ajastin3;
    private TapahtumatPaneeli tapahtumat;
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
        ajastin = new KiitsJnePaneeli(this);
        layoutti = new CardLayout();
        paneeli = new JPanel(layoutti);
        ajastin2 = new OtaMassitPaneeli(this, ajastin);
        ajastin3 = new OtaKuitti(this, ajastin);
        tapahtumat = new TapahtumatPaneeli(this, ajastin3, ajastin);

        paneeli.add(new EtuSivuPaneeli(this, tapahtumat), ETU);
        paneeli.add(new NostoPaneeli(this, ajastin2), NOSTO);
        paneeli.add(new KirjauduPaneeli(this, lukija), KIRJAUDU);
        paneeli.add(new LopetaKayttoPaneeli(this, ajastin), LOPETA);
        paneeli.add(ajastin2, OTAMASSIT);
        paneeli.add(tapahtumat, TAPAHTUMAT);
        paneeli.add(new KiitsJnePaneeli(this), KIITOSHEI);
        paneeli.add(new SaldoPaneeli(this, lukija), SALDO);
        paneeli.add(new OtaKuitti(this, ajastin), KUITTI);

        add(paneeli);
        layoutti.show(paneeli, KIRJAUDU);
        setVisible(true);
    }

    public void naytto(String naytonNimi) {
        layoutti.show(paneeli, naytonNimi);

    }

    public void lopetaKaytto() {
        layoutti.show(paneeli, KIRJAUDU);
    }
}
