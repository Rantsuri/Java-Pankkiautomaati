package net.ohjelmointi4.atm.main.java;

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

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }

    
}
