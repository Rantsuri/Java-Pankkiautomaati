package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KiitsJnePaneeli extends JPanel implements ActionListener {
//kiitos käynnistä tervetuloa uudelleen :) <3

    private ATMFrame frame;
    private JLabel Kiitos;
    private JLabel tervetuloaUudelleen;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private Timer nayttoAjastin;

    public KiitsJnePaneeli(ATMFrame frame) {
        this.frame = frame;

        tervetuloaUudelleen = new JLabel("Tervetuloa uudelleen");
        tervetuloaUudelleen.setFont(fontti);
        tervetuloaUudelleen.setForeground(Color.white);

        Kiitos = new JLabel("Kiitos Käynnistä");
        Kiitos.setFont(fontti);
        Kiitos.setForeground(Color.white);

        add(tervetuloaUudelleen);
        add(Kiitos);

        setBackground(Color.blue);
        nayttoAjastin = new Timer(10000, new ActionListener() {
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
