package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OtaKuitti extends JPanel implements ActionListener{
    private ATMFrame frame;
    private JLabel otaKuitti, Tapahtumat;
    private KiitsJnePaneeli ajastin;
    private Timer nayttoAjastin;

    private Font fontti = new Font("Arial", Font.BOLD, 24);


    public OtaKuitti(ATMFrame frame, KiitsJnePaneeli ajastin ) {
        this.frame = frame;
        this.ajastin = ajastin;
        setLayout(null);

        Tapahtumat = new JLabel("Tapahtumat");
        Tapahtumat.setFont(fontti);
        Tapahtumat.setForeground(Color.white);
        Tapahtumat.setBounds(340, 100, 200, 80);

        otaKuitti = new JLabel("Ota kuitti alhaalta");
        otaKuitti.setFont(fontti);
        otaKuitti.setBounds(320, 100, 500, 80);
        otaKuitti.setForeground(Color.white);


       

        add(otaKuitti);

        setBackground(Color.blue);
        nayttoAjastin = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nayttoAjastin.stop();

                frame.naytto(ATMFrame.KIITOSHEI);
                ajastin.NayttoAjastin();

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
