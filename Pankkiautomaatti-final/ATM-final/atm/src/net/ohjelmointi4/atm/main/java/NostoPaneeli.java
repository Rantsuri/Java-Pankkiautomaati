package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class NostoPaneeli extends JPanel implements ActionListener {
//nostotoiminnon logiikka, grafiikka ja muut

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
    private JDialog nappainIkkuna;
    private JTextField summaField;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button11, button12;

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

        MuuSumma = new JButton("Muu Summa");
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
            if (nostoTapahtuma(20)) {
                frame.naytto(ATMFrame.OTAMASSIT);
                ajastin.NayttoAjastin();
            }
        } else if (e.getSource() == nelkyt) {
            if (nostoTapahtuma(40)) {
                frame.naytto(ATMFrame.OTAMASSIT);
                ajastin.NayttoAjastin();

            }

        } else if (e.getSource() == viiskyt) {
            if (nostoTapahtuma(50)) {
                frame.naytto(ATMFrame.OTAMASSIT);
                ajastin.NayttoAjastin();
            }

        } else if (e.getSource() == satku) {
            if (nostoTapahtuma(100)) {
                frame.naytto(ATMFrame.OTAMASSIT);
                ajastin.NayttoAjastin();
            }

        } else if (e.getSource() == MuuSumma) {
            nostoSummaIkkuna(true);
            nappainKentta(true);
        } else if (e.getSource() == lopetaKaytto) {
            frame.naytto(ATMFrame.LOPETA);
        } else if (e.getSource() == button11) {
            String nostettavaSumma = summaField.getText();
            Double summa = Double.parseDouble(nostettavaSumma);
            if (!nostettavaSumma.isEmpty() && nostoRajanSisalla(summa)) {
                try {
                    double numeroSumma = Double.parseDouble(nostettavaSumma);
                    nostoSummaIkkuna(false);
                    nappainKentta(false);
                    nostoTapahtuma(numeroSumma);
                    frame.naytto(ATMFrame.OTAMASSIT);
                    ajastin.NayttoAjastin();
                } catch (Exception virhe) {
                    virhe.printStackTrace();
                    summaField.setText(null);
                }
            } else {
                summaField.setText(null);
                JOptionPane.showMessageDialog(this, "Virheellinen summa!", "Virhe", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button12) {
            String numero = summaField.getText();
            if (!numero.isEmpty()) {
                summaField.setText(numero.substring(0, numero.length() - 1));
            }
        } else if (summaIkkunaPaalla) {
            summaField.setText(summaField.getText() + e.getActionCommand());
        }
    }

    public boolean nostoTapahtuma(double summa) {

        try {
            String kortti = lukija.getKortti();
            double saldo = lukija.Saldo();
            double alkuperainenNostoMaara = lukija.nostoMaara();
            double uusiSaldo = saldo - summa;

            if (uusiSaldo < 0) {
                JOptionPane.showMessageDialog(this, "Tilillä ei riittävästi katetta", "Virhe", JOptionPane.ERROR_MESSAGE);

                return false;
            }
            if (summa > alkuperainenNostoMaara) {
                JOptionPane.showMessageDialog(this, "Syötetty summa ylittää tilin nostorajan", "Virhe", JOptionPane.ERROR_MESSAGE);

                return false;
            }
            int[] jaettavatSetelit = setelienJako(summa);
            JOptionPane.showMessageDialog(this, "50€ " + jaettavatSetelit[0] + " Kpl, "
                    + "20€ " + jaettavatSetelit[1] + " Kpl, "
                    + "10€ " + jaettavatSetelit[2] + "Kpl",
                    "Nostetut setelit:", JOptionPane.INFORMATION_MESSAGE);

            muutaTilinSaldoa(kortti, String.valueOf(uusiSaldo));
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean nostoRajanSisalla(double summa) {
        if (summa <= 100 && summa > 0 && summa % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void tukiDialogipaalla(boolean päällä) {
        tukiOnkoPäällä = päällä;
        if (päällä == true) {
            tukiIkkuna = new JWindow();
            JPanel tämäPaneeli = new JPanel();
            tämäPaneeli.setLayout(null);
            tämäPaneeli.setBackground(Color.white);
            JLabel label1 = new JLabel("<html><u>TUKI</u></html>");

            label1.setBounds(280, 50, 200, 80);
            label1.setFont(fontti);
            JLabel tukiteksti1 = new JLabel("<html>Tällä sivulla voit nostaa käteistä painamalla haluttua summaa tai syöttää mieluinen summa käyttäen numeronäppäimiä. Nostettavat setelit ovat 50€, 20€ ja 10€ seteileitä. Maksimi kerta nostomäärä on 100€.  Voit halutessasi palata takaisin painamalla Takaisin-näppäintä tai lopettaa käytön painamalla Lopeta Käyttö-näppäintä</html>");
            tukiteksti1.setFont(fontti);
            tukiteksti1.setBounds(100, 150, 400, 310);

            JLabel tukiteksti2 = new JLabel("<html>Ongelmatilanteissa soita:<br> +358 010 1234567</html>");
            tukiteksti2.setFont(fontti);
            tukiteksti2.setBounds(100, 450, 400, 150);

            tämäPaneeli.add(label1);
            tämäPaneeli.add(tukiteksti2);
            tämäPaneeli.add(tukiteksti1);
            tukiIkkuna.add(tämäPaneeli);
            tukiIkkuna.setVisible(true);
            tukiIkkuna.setSize(600, 600);
            tukiIkkuna.setLocation(keskitys(600), 70);
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

            summaField = new JTextField();
            summaField.setBounds(150, 280, 300, 80);
            summaField.setFont(fontti);
            summaField.setHorizontalAlignment(JTextField.CENTER);
            nostoIkkunaPaneeli.add(summaField);

            summaIkkuna.setVisible(true);
            summaIkkuna.setSize(600, 600);
            summaIkkuna.setLocation(keskitys(600), 70);
            summaIkkuna.add(nostoIkkunaPaneeli);
        } else if (päällä == false) {
            summaIkkuna.setVisible(false);
            summaIkkuna.dispose();
            nappainIkkuna.setVisible(false);
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

    public void muutaNostoMaaraa(String korttin, String uusiNostoMaara) throws IOException {
        Path path = Paths.get(korttin);
        List<String> tilinTiedot = Files.readAllLines(path);
        tilinTiedot.set(2, uusiNostoMaara);
        Files.write(path, tilinTiedot);

    }

    public int[] setelienJako(double summa) {
        int jako = (int) summa;
        int viiskyt = 0;
        int kakskyt = 0;
        int kymppi = 0;

        viiskyt = jako / 50;
        jako %= 50;
        kakskyt = jako / 20;
        jako %= 20;
        kymppi = jako / 10;
        jako %= 10;

        return new int[]{viiskyt, kakskyt, kymppi};

    }

    public void nappainKentta(boolean paalla) {

        if (paalla == true) {
            nappainIkkuna = new JDialog();
            JPanel nappainkentta = new JPanel(new GridLayout(4, 3, 6, 6));
            nappainkentta.setBounds(260, 150, 300, 200);
            nappainkentta.setBackground(Color.blue);
            nappainkentta.setMaximumSize(new Dimension(260, 200));
            nappainkentta.setAlignmentX(CENTER_ALIGNMENT);

            button1 = new JButton("1");
            button1.setFont(fontti);
            button1.addActionListener(this);

            button2 = new JButton("2");
            button2.setFont(fontti);
            button2.addActionListener(this);
            button3 = new JButton("3");
            button3.setFont(fontti);
            button3.addActionListener(this);
            button4 = new JButton("4");
            button4.setFont(fontti);
            button4.addActionListener(this);
            button5 = new JButton("5");
            button5.setFont(fontti);
            button5.addActionListener(this);
            button6 = new JButton("6");
            button6.setFont(fontti);
            button6.addActionListener(this);
            button7 = new JButton("7");
            button7.setFont(fontti);
            button7.addActionListener(this);
            button8 = new JButton("8");
            button8.setFont(fontti);
            button8.addActionListener(this);
            button9 = new JButton("9");
            button9.setFont(fontti);
            button9.addActionListener(this);
            button11 = new JButton(">");
            button11.setBackground(Color.green);
            button11.setFont(fontti);
            button11.addActionListener(this);
            button0 = new JButton("0");
            button0.setFont(fontti);
            button0.addActionListener(this);
            button12 = new JButton("<");
            button12.setBackground(Color.red);
            button12.setFont(fontti);
            button12.addActionListener(this);

            nappainkentta.add(button1);
            nappainkentta.add(button2);
            nappainkentta.add(button3);
            nappainkentta.add(button4);
            nappainkentta.add(button5);
            nappainkentta.add(button6);
            nappainkentta.add(button7);
            nappainkentta.add(button8);
            nappainkentta.add(button9);

            nappainkentta.add(button12);
            nappainkentta.add(button0);
            nappainkentta.add(button11);
            nappainIkkuna.add(nappainkentta);
            nappainIkkuna.setVisible(true);
            nappainIkkuna.setSize(310, 310);
            nappainIkkuna.setLocation(ALLBITS, ABORT);
            nappainIkkuna.setAlwaysOnTop(true);
        } else if (paalla == false) {
            nappainIkkuna.setVisible(false);
            
        }
    }
//hei
}
