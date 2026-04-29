package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KiitosKaynnistaPaneeli extends JPanel implements ActionListener {
//kiitos käynnistä tervetuloa uudelleen :) <3 sellaisen paneelin grafiikat ja ajastins

    private ATMFrame frame;
    private JLabel Kiitos;
    private JLabel tervetuloaUudelleen;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private Timer nayttoAjastin;

    public KiitosKaynnistaPaneeli(ATMFrame frame) {
        this.frame = frame;
        setLayout(null);
        tervetuloaUudelleen = new JLabel("Tervetuloa uudelleen");
        tervetuloaUudelleen.setFont(fontti);
        tervetuloaUudelleen.setForeground(Color.white);
        tervetuloaUudelleen.setBounds(280, 400, 300, 90);

        Kiitos = new JLabel("Kiitos Käynnistä");
        Kiitos.setFont(fontti);
        Kiitos.setForeground(Color.white);
        Kiitos.setBounds(300, 300, 300, 90);

        add(tervetuloaUudelleen);
        add(Kiitos);

        setBackground(Color.blue);
        nayttoAjastin = new Timer(7000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nayttoAjastin.stop();
                frame.naytto(ATMFrame.KIRJAUDU);
                
            }
        }) ;

        
    }

    public void NayttoAjastin() {
        nayttoAjastin.restart();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

      public int keskitys(int leveys){
        int x = frame.getX();
        int frameLeveys = frame.getWidth();
        return x + (frameLeveys - leveys) / 2; 
    }
}

