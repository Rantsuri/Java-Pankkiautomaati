package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LopetaKayttoPaneeli extends JPanel implements ActionListener{
//paevaa

    private ATMFrame frame;
    private JLabel LopetaKayttoTeksti;
    private JLabel oletkoVarmaTeksti;
    private JButton takaisinNappi, lopetaKayttoNappi;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private KiitsJnePaneeli ajastin;

    public LopetaKayttoPaneeli(ATMFrame frame, KiitsJnePaneeli ajastin) {
        this.frame = frame;
        this.ajastin = ajastin;
        setLayout(null);

        LopetaKayttoTeksti = new JLabel("LOPETA KÄYTTÖ");
        LopetaKayttoTeksti.setBounds(300, 100, 500, 80);
        LopetaKayttoTeksti.setFont(fontti);
        LopetaKayttoTeksti.setForeground(Color.WHITE);

        oletkoVarmaTeksti = new JLabel("haluatko varmasti lopettaa käytön?");
        oletkoVarmaTeksti.setBounds(220, 300, 500, 80);
        oletkoVarmaTeksti.setFont(fontti);
        oletkoVarmaTeksti.setForeground(Color.white);
        
        takaisinNappi = new JButton("Takaisin");
        takaisinNappi.setFont(fontti);
        takaisinNappi.addActionListener(this);
        takaisinNappi.setBounds(125, 675, 200 ,80);


        lopetaKayttoNappi = new JButton("Lopeta käyttö");
        lopetaKayttoNappi.setFont(fontti);
        lopetaKayttoNappi.setBounds(500, 675, 200, 80);
        lopetaKayttoNappi.addActionListener(this);
        
        add(lopetaKayttoNappi);
        add(oletkoVarmaTeksti);
        add(takaisinNappi);
        add(LopetaKayttoTeksti);
        add(lopetaKayttoNappi);

        setBackground(Color.blue);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lopetaKayttoNappi){
            frame.naytto(ATMFrame.KIITOSHEI);
            ajastin.NayttoAjastin();

        }else if(e.getSource() == takaisinNappi){
            frame.naytto("ETU");
        }
    }

    
}
