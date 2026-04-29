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
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SaldoPaneeli extends JPanel implements ActionListener {
//Saldon tarkastelu paneeli väli viiva yhdys sana tämä kin

    private ATMFrame frame;
    private JButton tuki, lopeta, takaisin;
    private JWindow tukiIkkuna;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private boolean tukiOnkoPäällä = false;
    private double tilinSaldo;
    private KortinLukija lukija;
    private JLabel saldo, saldoTeksti;
    private JLabel nostoMaara, nostoMaaraTeksti, PaneeliTeksti;
    

    public SaldoPaneeli(ATMFrame frame, KortinLukija lukija) {
        this.lukija = lukija;
        this.frame = frame;
        setLayout(null);

        tuki = new JButton("Tuki");
        tuki.setBounds(500, 550, 200, 80);
        tuki.addActionListener(this);
        tuki.setFont(fontti);

        takaisin = new JButton("Takaisin");
        takaisin.setFont(fontti);
        takaisin.addActionListener(this);
        takaisin.setBounds(125, 675, 200, 80);

        lopeta = new JButton("Lopeta Käyttö");
        lopeta.setFont(fontti);
        lopeta.addActionListener(this);
        lopeta.setBounds(500, 675, 200, 80);

        saldo = new JLabel("");
        saldo.setFont(fontti);
        saldo.setBounds(500, 300, 200, 80);
        saldo.setFont(fontti);
        saldo.setForeground(Color.WHITE);

        saldoTeksti = new JLabel("Tilin Saldo...");
        saldoTeksti.setFont(fontti);
        saldoTeksti.setBounds(125, 300, 200, 80);
        saldoTeksti.setForeground(Color.white);
        

        nostoMaara = new JLabel("");
        nostoMaara.setFont(fontti);
        nostoMaara.setBounds(500, 425, 200, 80);
        nostoMaara.setForeground(Color.white);

        nostoMaaraTeksti = new JLabel("Nostettavissa...");
        nostoMaaraTeksti.setFont(fontti);
        nostoMaaraTeksti.setBounds(125, 425, 200, 80);
        nostoMaaraTeksti.setForeground(Color.white);

        PaneeliTeksti = new JLabel("TILIN SALDO");
        PaneeliTeksti.setFont(fontti);
        PaneeliTeksti.setForeground(Color.white);
        PaneeliTeksti.setBounds(300, 100, 200, 80);

        saldoJaNostoMaara();
        add(tuki);
        add(nostoMaara);
        add(nostoMaaraTeksti);
        add(saldoTeksti);
        add(saldo);
        add(lopeta);
        add(takaisin);
        add(PaneeliTeksti);
        setBackground(Color.blue);

    }

    public final void saldoJaNostoMaara() {
        try {
            String kortti = lukija.getKortti();
            String saldoMaara = SaldoPaivitys(kortti);
            saldo.setText(saldoMaara);
            String nostoMaara1 = NostoMaaraPaivitys(kortti);
            nostoMaara.setText(nostoMaara1);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            //jos tukidialogi on päällä niin takaisin
            //  painamalla pääsee paneeleja takaisin
            if (tukiOnkoPäällä == true) {
                tukiDialogipaalla(false);
            } else {
                frame.naytto(ATMFrame.ETU);

            }

        } else if (e.getSource() == tuki) {
            tukiDialogipaalla(true);

        } else if (e.getSource() == lopeta) {
            frame.naytto(ATMFrame.LOPETA);
        }
    }

    public int keskitys(int leveys) {
        int x = frame.getX();
        int frameLeveys = frame.getWidth();
        return x + (frameLeveys - leveys) / 2;
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
            JLabel tukiteksti1 = new JLabel("<html>Tällä sivulla voit tarkastella tilisi saldoa. Voit halutessasi palata takaisin painamalla Takaisin-näppäintä tai lopettaa käytön painamalla Lopeta Käyttö-näppäintä </html>");
            tukiteksti1.setFont(fontti);
            tukiteksti1.setBounds(100, 150, 400, 200);
            

             JLabel tukiteksti2 = new JLabel("<html>Ongelmatilanteissa soita:<br> +358 010 1234567</html>");
            tukiteksti2.setFont(fontti);
            tukiteksti2.setBounds(100, 450, 400, 150);


            tämäPaneeli.add(label1);
            tämäPaneeli.add(tukiteksti2);
            tämäPaneeli.add(tukiteksti1);
            tukiIkkuna.setVisible(true);
            tukiIkkuna.setSize(600, 600);
            tukiIkkuna.setLocation(keskitys(600), 70);
            tukiIkkuna.add(tämäPaneeli);
        } else if (päällä == false) {
            tukiIkkuna.setVisible(false);
            tukiIkkuna.dispose();
        }
    }

    public String SaldoPaivitys(String kortti) throws IOException {
        Path path = Paths.get(kortti);
        List<String> tilintiedot = Files.readAllLines(path);
        String saldo = tilintiedot.get(1);
        return saldo;

    }

     public String NostoMaaraPaivitys(String kortti) throws IOException {
        Path path = Paths.get(kortti);
        List<String> tilintiedot = Files.readAllLines(path);
        String nostoMaara = tilintiedot.get(2);
        return nostoMaara;

    }

    



}
