package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class EtuSivuPaneeli extends  JPanel implements ActionListener {
 //toimiiks

 private JPanel panel;
 private JButton nosto, tapahtumat, saldo, lopeta, tuki, takaisin;
 private ATMFrame frame;
 private JLabel tervetuloaTeksti; 
 private JWindow tukiIkkuna;
 private Font fontti = new Font("Arial", Font.BOLD, 24);
 private NostoPaneeli nostoPaneeli;
 private TapahtumatPaneeli tapahtumaPaneeli;


 public EtuSivuPaneeli(ATMFrame frame, TapahtumatPaneeli tapahtumatPaneeli){

        this.frame = frame;
        this.tapahtumaPaneeli = tapahtumatPaneeli;
        setLayout(null);

        tervetuloaTeksti = new JLabel("TERVETULOA");
        tervetuloaTeksti.setBounds(340, 100, 200, 80);
        tervetuloaTeksti.setFont(fontti);
        tervetuloaTeksti.setForeground(Color.white);

        nosto = new JButton("Nosto");
        nosto.setBounds(125, 300, 200, 80);
        nosto.addActionListener(this);
        nosto.setFont(fontti);

        saldo = new JButton("Saldo");
        saldo.setBounds(125, 425, 200, 80);
        saldo.addActionListener(this);
        saldo.setFont(fontti);

        tapahtumat = new JButton("Tapahtumat");
        tapahtumat.setBounds(500, 300, 200, 80);
        tapahtumat.addActionListener(this);
        tapahtumat.setFont(fontti);

        tuki = new JButton("TUKI");
        tuki.setBounds(500, 550, 200, 80);
        tuki.setFont(fontti);
        

        takaisin = new JButton("Takaisin");
        takaisin.setBounds(125, 675, 200, 80);
        takaisin.addActionListener(this);
        takaisin.setFont(fontti);
        takaisin.setVisible(false);
        /*
        testinappi2 = new JButton("Testi4");
        testinappi2.setBounds(125, 675, 200, 80);

        testiNappi3 = new JButton("Testi2");
        testiNappi3.setBounds(500, 425, 200, 80);
         */

        lopeta = new JButton("Lopeta Käyttö");
        lopeta.setBounds(500, 675, 200, 80);
        lopeta.setFont(fontti);

        nosto.addActionListener(this);
        saldo.addActionListener(this);
        tapahtumat.addActionListener(this);
        lopeta.addActionListener(this);
        tuki.addActionListener(this);

        add(tervetuloaTeksti);
        add(nosto);
        add(saldo);
        add(tapahtumat);
        add(lopeta);
        add(tuki);
        add(takaisin);


        /*  add(testiNpaii1);
        add(testinappi2);
        add(testiNappi3);
         */
        setBackground(Color.blue);
 }


 @Override
 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == nosto) {
            frame.naytto(ATMFrame.NOSTO);
        } else if (e.getSource() == saldo) {
            frame.naytto(ATMFrame.SALDO);
            
        } else if (e.getSource() == tapahtumat) {
            frame.naytto(ATMFrame.TAPAHTUMAT);;
        } else if (e.getSource() == lopeta) {
            frame.naytto(ATMFrame.LOPETA);
            tukiDialogipaalla(false);
        } else if (e.getSource() == tuki) {
            tukiDialogipaalla(true);
            takaisin.setVisible(true);
        } else if (e.getSource() == takaisin) {
            tukiDialogipaalla(false);
            takaisin.setVisible(false);
        }
 }

   public void tukiDialogipaalla(boolean päällä) { 
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
            tukiIkkuna.setLocation(675, 90);
            tukiIkkuna.add(tämäPaneeli);
        } else if(päällä == false){
            tukiIkkuna.setVisible(false);
            tukiIkkuna.dispose();
        }
    }
 
}
