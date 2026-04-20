package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

public class TapahtumatPaneeli extends JPanel implements ActionListener {
//Tapahtumat paneeli radioNapilla

private ATMFrame frame;
private JRadioButton radioKuitille;
private JRadioButton radioNaytolle;
private Font fontti = new Font("Arial", Font.BOLD, 24);
private JButton takaisin;
private JLabel TapahtumatTeksti;
private JWindow tapahtumatIkkuna;
private JWindow tukiIkkuna;
private JButton lopetaKaytto;
private JButton valitseOk;
private JButton tuki;




public TapahtumatPaneeli(ATMFrame frame){
    this.frame = frame;
    setLayout(null);

    setBackground(Color.blue);

    TapahtumatTeksti = new JLabel("Tapahtumat");
    TapahtumatTeksti.setFont(fontti);
    TapahtumatTeksti.setForeground(Color.white);
    TapahtumatTeksti.setBounds(340, 100, 200, 80);



    takaisin = new JButton("Takaisin");
    takaisin.setBounds(125,675,200,80);
    takaisin.setFont(fontti);
    takaisin.addActionListener(this);

    lopetaKaytto = new JButton("Lopeta Kaytto");
    lopetaKaytto.setBounds(500, 675, 200, 80);
    lopetaKaytto.setFont(fontti);
    lopetaKaytto.addActionListener(this);

    //ilmaantuu vasta windowille, siksi visibility == false
    valitseOk = new JButton("Valitse");
    valitseOk.setFont(fontti);
    valitseOk.addActionListener(this);
    valitseOk.setBounds(125, 550, 200, 80);
    valitseOk.setVisible(false);


    tapahtumatIkkunaMetodi();
    setBackground(Color.BLUE);

}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == takaisin ){
         //jos tukidialogi on päällä niin takaisin
        //  painamalla pääsee paneeleja takaisin
        
    }else{
         if(e.getSource() == tuki){
        tukiDialogipaalla(true);
        
    }
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


    public void tapahtumatIkkunaMetodi(){

        tapahtumatIkkuna = new JWindow();
        JPanel tapahtumatPaneeli = new JPanel();
        tapahtumatPaneeli.setBackground(Color.cyan);
        JLabel valitseOk = new JLabel("Valitse kuitille vai näytölle ja paina 'Valitse'");
        valitseOk.setFont(fontti);
        valitseOk.setBounds(300, 300, 200, 80);

        radioKuitille = new JRadioButton("Kuitille");
        radioKuitille.setFont(fontti);
        radioKuitille.setBounds(125, 300, 200, 80);
        radioKuitille.addActionListener(this);

        radioNaytolle = new JRadioButton("Naytölle");
        radioNaytolle.setFont(fontti);
        radioNaytolle.setBounds(125, 425, 200, 80);
        radioNaytolle.addActionListener(this);
        
        tapahtumatPaneeli.add(valitseOk);
        tapahtumatIkkuna.setVisible(true);
        tapahtumatIkkuna.setSize(600, 400);
        tapahtumatIkkuna.setLocation(675, 90);
        tapahtumatIkkuna.add(tapahtumatPaneeli);


    }
}
