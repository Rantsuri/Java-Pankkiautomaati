package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SaldoPaneeli extends JPanel implements ActionListener {
//Saldon tarkastelu paneeli väli viiva yhdys sana tämä kin
    private ATMFrame frame;
    private JButton tuki, lopeta, takaisin;
    private JWindow tukiIkkuna;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private boolean  tukiOnkoPäällä = false;
    private double tilinSaldo;
    private KortinLukija lukija;
    private JLabel saldo;
    private JLabel nostoMaara;

public SaldoPaneeli(ATMFrame frame, KortinLukija lukija) {
    this.lukija = lukija;
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
    
    saldo = new JLabel("");
    saldo.setFont(fontti);
    saldo.setBounds(100, 100, 200, 80);
    add(tuki);
    add(lopeta);
    add(takaisin);
    add(saldo);
    setBackground(Color.blue);
    paivitaSaldo();

}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == takaisin ){
         //jos tukidialogi on päällä niin takaisin
        //  painamalla pääsee paneeleja takaisin
        if(tukiOnkoPäällä == true){
            tukiDialogipaalla(false);
        }else{
        frame.naytto(ATMFrame.ETU);

        }
        
    }else if(e.getSource() == tuki){
        tukiDialogipaalla(true);
        
    }else if(e.getSource() == lopeta){
        frame.naytto(ATMFrame.LOPETA);
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
            tukiIkkuna.setLocation(675, 90);
            tukiIkkuna.add(tämäPaneeli);
        } else if(päällä == false){
            tukiIkkuna.setVisible(false);
            tukiIkkuna.dispose();
        }
    }
    
    public void paivitaSaldo(){
        try {
            String StringSaldo = Double.toString(lukija.Saldo());
            saldo.setText(StringSaldo);
        } catch (Exception e) {
            saldo.setText("Virhe...");
        }
    }


}
