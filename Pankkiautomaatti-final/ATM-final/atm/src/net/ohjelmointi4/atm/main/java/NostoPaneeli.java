package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NostoPaneeli extends JPanel implements ActionListener {
//nosto operaatioon kaikki logiikka ja paneelit ja muut

    private Font fontti = new Font("Arial", Font.BOLD, 24);

    private ATMFrame frame;
    private JButton MuuSumma, kaksyt, nelkyt, viiskyt, satku, takaisin,
            tuki, lopetaKaytto;


    public NostoPaneeli(ATMFrame frame){
        this.frame = frame;
        setLayout(null);
         
        

        JLabel label = new JLabel("NOSTO");
        label.setFont(fontti);
        label.setBounds(360, 100, 200, 80);
        label.setForeground(Color.white);
        
        kaksyt = new JButton("20 Euroa");
        kaksyt.setFont(fontti);
        kaksyt.setBounds(125, 300, 200, 80);
        kaksyt.addActionListener(this);

        nelkyt = new JButton("40 Euroa");
        nelkyt.setBounds(125, 425, 200, 80);
        nelkyt.setFont(fontti);
        nelkyt.addActionListener(this);

        viiskyt = new JButton("50 Euroa");
        viiskyt.setBounds(125, 550, 200 ,80);
        viiskyt.setFont(fontti);
        viiskyt.addActionListener(this);

        satku = new JButton("100 Euroa");
        satku.setBounds(500, 300, 200, 80);
        satku.setFont(fontti);
        satku.addActionListener(this);

        MuuSumma = new JButton("Muu summa");
        MuuSumma.setBounds(500, 425, 200, 80);
        MuuSumma.setFont(fontti);
        MuuSumma.addActionListener(this);

        lopetaKaytto = new JButton("Lopeta Käyttö");
        lopetaKaytto.setBounds(500, 675, 200, 80);
        lopetaKaytto.setFont(fontti);
        lopetaKaytto.addActionListener(this);

        takaisin = new JButton("Takaisin");
        takaisin.addActionListener(this);
        takaisin.setBounds(125, 675, 200, 80); 
        takaisin.setFont(fontti);

        add(label);
        add(takaisin);
        add(kaksyt);
        add(nelkyt);
        add(viiskyt);
        add(satku);
        add(MuuSumma);
        add(lopetaKaytto);
        setBackground(Color.blue);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource() == kaksyt){
        nostoTapahtuma(20);
       }else if(e.getSource() == nelkyt){
        nostoTapahtuma(40);
       }else if(e.getSource() == viiskyt){
        nostoTapahtuma(50);
       }else if(e.getSource() == satku){
        nostoTapahtuma(100);
       }else if(e.getSource() == MuuSumma){
        
       }else if(e.getSource() == takaisin){
        frame.naytto("ETU");
       }else if(e.getSource() == lopetaKaytto){
        frame.naytto("AUTENT");
       }
    }


    public void nostoTapahtuma(double summa){
       
        JPanel paneeli = new JPanel();
        paneeli.setLayout(null);
        paneeli.setBackground(Color.blue);


        JLabel nostoTeksti = new JLabel("Nostetaan " + summa + "euroa");
        JLabel odotaHetki = new JLabel("Rahat tulossa, odota hetki");

        nostoTeksti.setFont(fontti);
        odotaHetki.setFont(fontti);
        odotaHetki.setForeground(Color.white);
        nostoTeksti.setForeground(Color.white);

        nostoTeksti.setBounds(50,50, 200, 80);
        odotaHetki.setBounds(50, 100, 200, 80);
        paneeli.add(nostoTeksti);
        paneeli.add(odotaHetki);
         
        paneeli.setVisible(true);
        paneeli.setSize(800, 1000);
        


    }

//hei
}
