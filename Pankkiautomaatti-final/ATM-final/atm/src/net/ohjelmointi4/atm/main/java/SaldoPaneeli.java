package net.ohjelmointi4.atm.main.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SaldoPaneeli extends JPanel implements ActionListener {
//Saldon tarkastelu paneeli väli viiva yhdys sana tämä kin
    private ATMFrame frame;
    private JButton tuki, lopeta, takaisin;
    private JWindow tukiIkkuna;
    private Font fontti = new Font("Arial", Font.BOLD, 24);


public SaldoPaneeli(ATMFrame frame){
    this.frame = frame;
    setLayout(null);

    tuki = new JButton("Tuki");
    tuki.setBounds(500, 550, 200, 80);
    tuki.addActionListener(this);
    tuki.setFont(fontti);

    takaisin = new JButton("Takaisin");
    takaisin.setFont(fontti);
    takaisin.addActionListener(this);
    takaisin.setBounds(125, 675, 200 ,80);

    lopeta = new JButton("Lopeta Käyttö");
    lopeta.setFont(fontti);
    lopeta.addActionListener(this);
    lopeta.setBounds(500, 675, 200, 80);


    add(tuki);
    add(lopeta);


}

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}
}
