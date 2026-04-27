package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

public class TapahtumatPaneeli extends JPanel implements ActionListener {
//Tapahtumat paneeli radioNapilla

    private ATMFrame frame;
    private JRadioButton radioKuitille;
    private JRadioButton radioNaytolle;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private JButton takaisin;
    private JLabel TapahtumatTeksti;
    private JWindow tukiIkkuna;
    private boolean tukiOnkoPäällä = false;
    private JButton lopetaKaytto;
    private JButton valitseOk;
    private JButton tuki;
    private OtaKuitti ajastin;
    private KiitsJnePaneeli ajastin2;

    public TapahtumatPaneeli(ATMFrame frame, OtaKuitti ajastin, KiitsJnePaneeli ajastin2) {
        this.frame = frame;
        this.ajastin = ajastin;
        this.ajastin2 = ajastin2;
        setLayout(null);

        setBackground(Color.blue);

        TapahtumatTeksti = new JLabel("Tapahtumat");
        TapahtumatTeksti.setFont(fontti);
        TapahtumatTeksti.setForeground(Color.white);
        TapahtumatTeksti.setBounds(340, 100, 200, 80);

        takaisin = new JButton("Takaisin");
        takaisin.setBounds(125, 675, 200, 80);
        takaisin.setFont(fontti);
        takaisin.addActionListener(this);

        lopetaKaytto = new JButton("Lopeta Kaytto");
        lopetaKaytto.setBounds(500, 675, 200, 80);
        lopetaKaytto.setFont(fontti);
        lopetaKaytto.addActionListener(this);

        //ilmaantuu vasta windowille, siksi visibility == false
        valitseOk = new JButton("Valitse");
        valitseOk.setFont(fontti);
        valitseOk.addActionListener(this);
        valitseOk.setBounds(125, 550, 200, 80);
        

        tuki = new JButton("Tuki");
        tuki.setFont(fontti);
        tuki.addActionListener(this);
        tuki.setBounds(500, 550, 200, 80);

        JLabel valitseOkTeksti = new JLabel("Valitse kuitille vai näytölle ja paina 'Valitse'");
        valitseOkTeksti.setFont(fontti);
        valitseOkTeksti.setBounds(180, 200, 500, 80);
        valitseOkTeksti.setForeground(Color.white);

        radioKuitille = new JRadioButton("Kuitille");
        radioKuitille.setFont(fontti);
        radioKuitille.setBounds(125, 300, 200, 80);
        radioKuitille.addActionListener(this);

        radioNaytolle = new JRadioButton("Naytölle");
        radioNaytolle.setFont(fontti);
        radioNaytolle.setBounds(500, 300, 200, 80);
        radioNaytolle.addActionListener(this);

        ButtonGroup ryhmä = new ButtonGroup();
        ryhmä.add(radioKuitille);
        ryhmä.add(radioNaytolle);

        setBackground(Color.BLUE);

        add(takaisin);
        add(lopetaKaytto);
        add(valitseOk);
        add(TapahtumatTeksti);
        add(tuki);
        add(radioKuitille);
        add(radioNaytolle);
        add(valitseOkTeksti);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            //jos tukidialogi on päällä niin takaisin
            //  painamalla pääsee paneeleja takaisin
            if (tukiOnkoPäällä == true) {
                tukiDialogipaalla(false);
            } else {

                frame.naytto("ETU");

            }

        } else if (e.getSource() == tuki) {
            tukiDialogipaalla(true);

        }else if(e.getSource() == valitseOk && radioKuitille.isSelected() ){
            frame.naytto(ATMFrame.KUITTI);
            ajastin.NayttoAjastin();

        }else if(e.getSource() == valitseOk && radioNaytolle.isSelected()){
            frame.naytto(ATMFrame.KIITOSHEI);
            ajastin2.NayttoAjastin();
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

      public int keskitys(int leveys){
        int x = frame.getX();
        int frameLeveys = frame.getWidth();
        return x + (frameLeveys - leveys) / 2; 
    }

}
