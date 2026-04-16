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

    private ATMFrame frame = new ATMFrame();
    private JLabel LopetaKayttoTeksti;
    private JLabel oletkoVarmaTeksti;
    private JButton takaisinNappi, lopetaKayttoNappi;
    private Font fontti = new Font("Arial", Font.BOLD, 24);

    public LopetaKayttoPaneeli(ATMFrame frame) {
        this.frame = frame;
        setLayout(null);

        LopetaKayttoTeksti = new JLabel("LOPETA KÄYTTÖ");
        LopetaKayttoTeksti.setBounds(340, 100, 200, 80);
        LopetaKayttoTeksti.setFont(fontti);
        LopetaKayttoTeksti.setForeground(Color.WHITE);

        oletkoVarmaTeksti = new JLabel("haluatko varmasti lopettaa käytön?");
        oletkoVarmaTeksti.setBounds(320, 300, 200, 80);
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
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lopetaKayttoNappi){
            frame.naytto("KIRJAUDU");
        }else if(e.getSource() == takaisinNappi){
            frame.naytto("ETU");
        }
    }

    
}
