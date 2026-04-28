package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class NostoPaneeli extends JPanel implements ActionListener {
//nosto operaatioon kaikki logiikka ja paneelit ja muut

    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private KortinLukija lukija;
    private ATMFrame frame;
    private JButton MuuSumma, kaksyt, nelkyt, viiskyt, satku, takaisin,
            tuki, lopetaKaytto;
    private boolean tukiOnkoPäällä = false;
    private JWindow tukiIkkuna;
    private OtaMassitPaneeli ajastin;
    private JWindow summaIkkuna;
    private boolean summaIkkunaPaalla = false;

    public NostoPaneeli(ATMFrame frame, OtaMassitPaneeli ajastin, KortinLukija lukija) {
        this.frame = frame;
        this.ajastin = ajastin;
        this.lukija = lukija;
        setLayout(null);

        JLabel label = new JLabel("NOSTO");
        label.setFont(fontti);
        label.setBounds(360, 100, 200, 80);
        label.setForeground(Color.white);

        kaksyt = new JButton("20 Euroa");
        kaksyt.setFont(fontti);
        kaksyt.setBounds(125, 300, 200, 80);
        kaksyt.addActionListener(this);

        nelkyt = new JButton("40 Euroa");
        nelkyt.setBounds(125, 425, 200, 80);
        nelkyt.setFont(fontti);
        nelkyt.addActionListener(this);

        viiskyt = new JButton("50 Euroa");
        viiskyt.setBounds(125, 550, 200, 80);
        viiskyt.setFont(fontti);
        viiskyt.addActionListener(this);

        satku = new JButton("100 Euroa");
        satku.setBounds(500, 300, 200, 80);
        satku.setFont(fontti);
        satku.addActionListener(this);

        MuuSumma = new JButton("Muu summa");
        MuuSumma.setBounds(500, 425, 200, 80);
        MuuSumma.setFont(fontti);
        MuuSumma.addActionListener(this);

        lopetaKaytto = new JButton("Lopeta Käyttö");
        lopetaKaytto.setBounds(500, 675, 200, 80);
        lopetaKaytto.setFont(fontti);
        lopetaKaytto.addActionListener(this);

        takaisin = new JButton("Takaisin");
        takaisin.addActionListener(this);
        takaisin.setBounds(125, 675, 200, 80);
        takaisin.setFont(fontti);

        tuki = new JButton("Tuki");
        tuki.addActionListener(this);
        tuki.setBounds(500, 550, 200, 80);
        tuki.setFont(fontti);

        add(label);
        add(takaisin);
        add(kaksyt);
        add(nelkyt);
        add(viiskyt);
        add(satku);
        add(MuuSumma);
        add(tuki);
        add(lopetaKaytto);
        setBackground(Color.blue);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            //jos tukidialogi on päällä niin takaisin
            //  painamalla pääsee paneeleja takaisin
            if (tukiOnkoPäällä) {
                tukiDialogipaalla(false);
            } else if (summaIkkunaPaalla) {
                nostoSummaIkkuna(false);
            } else {
                frame.naytto(ATMFrame.ETU);
            }

        } else if (e.getSource() == tuki) {
            tukiDialogipaalla(true);
        } else if (e.getSource() == kaksyt) {
            nostoTapahtuma(20);
            frame.naytto(ATMFrame.OTAMASSIT);
            ajastin.NayttoAjastin();
        } else if (e.getSource() == nelkyt) {
            frame.naytto(ATMFrame.OTAMASSIT);
            nostoTapahtuma(40);
            ajastin.NayttoAjastin();

        } else if (e.getSource() == viiskyt) {
            nostoTapahtuma(50);
            frame.naytto(ATMFrame.OTAMASSIT);
            ajastin.NayttoAjastin();
        } else if (e.getSource() == satku) {
            nostoTapahtuma(100);
            frame.naytto(ATMFrame.OTAMASSIT);
            ajastin.NayttoAjastin();
        } else if (e.getSource() == MuuSumma) {
            nostoSummaIkkuna(true);

        } else if (e.getSource() == lopetaKaytto) {
            frame.naytto(ATMFrame.LOPETA);
        }
    }

    public void nostoTapahtuma(double summa) {

        try {
            String kortti = lukija.getKortti();
            double saldo = lukija.Saldo();
            double nostoMaara = lukija.nostoMaara();
            double uusiSaldo = saldo - summa;
            nostoMaara *= 0.4;
            double uusiNostoMaara = Math.round(nostoMaara /10.0 ) * 10;
            
            

            if (uusiSaldo < 0) {
                JOptionPane.showMessageDialog(this, "Tilillä ei riittävästi katetta", "Virhe", JOptionPane.ERROR_MESSAGE);

                return;
            }
            muutaNostoMaaraa(kortti, String.valueOf(uusiNostoMaara));
            muutaTilinSaldoa(kortti, String.valueOf(uusiSaldo));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tukiDialogipaalla(boolean päällä) {
        tukiOnkoPäällä = päällä;
        if (päällä == true) {
            tukiIkkuna = new JWindow();
            JPanel tämäPaneeli = new JPanel();
            tämäPaneeli.setBackground(Color.white);
            JLabel label1 = new JLabel("TUKI");

            label1.setBounds(300, 300, 200, 80);
            label1.setFont(fontti);

            tämäPaneeli.add(label1);

            tukiIkkuna.setVisible(true);
            tukiIkkuna.setSize(600, 600);
            tukiIkkuna.setLocation(keskitys(600), 90);
            tukiIkkuna.add(tämäPaneeli);
        } else if (päällä == false) {
            tukiIkkuna.setVisible(false);
            tukiIkkuna.dispose();
        }
    }

    public void nostoSummaIkkuna(boolean päällä) {
        summaIkkunaPaalla = päällä;
        if (päällä == true) {
            summaIkkuna = new JWindow();
            JPanel nostoIkkunaPaneeli = new JPanel();
            nostoIkkunaPaneeli.setBackground(Color.white);
            nostoIkkunaPaneeli.setLayout(null);
            JLabel label = new JLabel("Syötä haluamasi Summa");

            label.setBounds(150, 220, 300, 80);
            label.setFont(fontti);
            nostoIkkunaPaneeli.add(label);

            JTextField summaField = new JTextField();
            summaField.setBounds(150, 280, 300, 80);
            nostoIkkunaPaneeli.add(summaField);

            summaIkkuna.setVisible(true);
            summaIkkuna.setSize(600, 600);
            summaIkkuna.setLocation(keskitys(600), 90);
            summaIkkuna.add(nostoIkkunaPaneeli);
        } else if (päällä == false) {
            summaIkkuna.setVisible(false);
            summaIkkuna.dispose();
        }
    }

    public int keskitys(int leveys) {
        int x = frame.getX();
        int frameLeveys = frame.getWidth();
        return x + (frameLeveys - leveys) / 2;
    }

    public void muutaTilinSaldoa(String kortti, String uusiSaldo) throws IOException {
        Path path = Paths.get(kortti);
        List<String> tilinTiedot = Files.readAllLines(path);
        tilinTiedot.set(1, uusiSaldo);
        Files.write(path, tilinTiedot);
    }

    public void muutaNostoMaaraa(String korttin, String uusiNostoMaara) throws IOException{
        Path path = Paths.get(korttin);
        List <String> tilinTiedot = Files.readAllLines(path);
        tilinTiedot.set(2, uusiNostoMaara);
        Files.write(path, tilinTiedot);

    }
//hei
}
