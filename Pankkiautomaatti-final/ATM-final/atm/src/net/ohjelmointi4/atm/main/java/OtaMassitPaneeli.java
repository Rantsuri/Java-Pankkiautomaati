package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class OtaMassitPaneeli extends JPanel implements ActionListener{
    private ATMFrame frame;
    private JLabel otaRahat;
    private JLabel rahaMaara;
    private JButton lopeta;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private Timer nayttoAjastin;
    private KiitsJnePaneeli ajastin;

    public OtaMassitPaneeli(ATMFrame frame, KiitsJnePaneeli ajastin){
        this.frame = frame;
        this.ajastin = ajastin;
        setLayout(null);
        
        otaRahat = new JLabel("Ota Rahat alhaalta");
        otaRahat.setFont(fontti);
        otaRahat.setBounds(320, 100, 500, 80);
        otaRahat.setForeground(Color.white);
        

       
        rahaMaara = new JLabel(""); //nostettu rahamäärä

        lopeta = new JButton("Lopeta Käyttö");
        lopeta.setFont(fontti);
        lopeta.setBounds(500, 675, 200, 80);
        lopeta.addActionListener(this);
        

        add(otaRahat);
       
        add(rahaMaara);
        
        setBackground(Color.blue);
          nayttoAjastin = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nayttoAjastin.stop();

                frame.naytto(ATMFrame.KIITOSHEI);
                ajastin.NayttoAjastin();
                
            }
        }) ;

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
  public void NayttoAjastin() {
        nayttoAjastin.restart();

    }
}
