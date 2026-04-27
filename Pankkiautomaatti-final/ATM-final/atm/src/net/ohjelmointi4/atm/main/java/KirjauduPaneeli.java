package net.ohjelmointi4.atm.main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KirjauduPaneeli extends JPanel implements ActionListener {

    private ATMFrame frame;
    private JTextField korttiNumeroKentta;
    private JPasswordField pinKentta;
    private JButton kirjauduNappi;
    private JLabel virheViesti;
    private Font fontti = new Font("Arial", Font.BOLD, 24);
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button11, button12;
    private KortinLukija lukija;
    private List<String> estoLista = new ArrayList<>();
    private int yritysKerrat;

    public KirjauduPaneeli(ATMFrame frame, KortinLukija lukija) {
        this.frame = frame;
        this.lukija = lukija;

        JLabel nimikko = new JLabel("Pankkiautomaatti :DDDDDDDD 8==3");
        JLabel kirjaudu = new JLabel("Syötä Pin-koodisi");
        kirjaudu.setFont(fontti);
        kirjaudu.setBounds(310, 100, 300, 80);
        kirjaudu.setForeground(Color.white);

        pinKentta = new JPasswordField(4);

        setLayout(null);

        pinKentta.setBounds(310, 400, 200, 80);
        pinKentta.setHorizontalAlignment(JTextField.CENTER); // keskelle
        pinKentta.setFont(fontti);
        add(pinKentta);
        nappainKentta();
        add(Box.createVerticalStrut(16));
        add(kirjaudu);
        add(nimikko);
        setBackground(Color.blue);

    }

    public void kirjautumisYritys() {
        String pinkoodi = new String(pinKentta.getPassword());
        if (pinkoodi.isBlank() || pinkoodi.isEmpty()) {

        }
    }

    public boolean pinkoodiOikein() {
        String pin = new String(pinKentta.getPassword());
        if (lukija.korttiOnOlemassa(pin) && !onkoEstoListalla(pin)) {
            return true;
        } else if(onkoEstoListalla(pin)){
            JOptionPane.showMessageDialog(this,"Kortti lukittu", "Virhe", JOptionPane.ERROR_MESSAGE);
            return false;
        }else {
            JOptionPane.showMessageDialog(this, "Väärä PIN!", "Virhe", JOptionPane.ERROR_MESSAGE);
            yritysKerrat++;
            if(yritysKerrat == 3){
                estoLista(pin);
            }
            return false;

        }
    }

    public void estoLista(String pin) {
        estoLista.add(pin);

        
    }

    public boolean onkoEstoListalla(String pin){
        if( estoLista.contains(pin)){
            return true;
        }else{
            return false;
        }
       
        
    }

    public char[] getPinKentta() {
        return pinKentta.getPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button11) {
            if (pinkoodiOikein()) {
                yritysKerrat = 0;
                frame.naytto("ETU");
                pinKentta.setText(null);

            }
        } else if (e.getSource() == button12) { //pyyhkii
            String numero = new String(pinKentta.getPassword());
            if (!numero.isEmpty()) {
                pinKentta.setText(numero.substring(0, numero.length() - 1));
            }
        } else {
            String numero = new String(pinKentta.getPassword());
            pinKentta.setText(numero + e.getActionCommand());
        }
    }

    public void nappainKentta() {

        JDialog nappainIkkuna = new JDialog();
        JPanel nappainkentta = new JPanel(new GridLayout(4, 3, 6, 6));
        nappainkentta.setBounds(260, 150, 300, 200);
        nappainkentta.setBackground(Color.blue);
        nappainkentta.setMaximumSize(new Dimension(260, 200));
        nappainkentta.setAlignmentX(CENTER_ALIGNMENT);

        button1 = new JButton("1");
        button1.setFont(fontti);
        button1.addActionListener(this);

        button2 = new JButton("2");
        button2.setFont(fontti);
        button2.addActionListener(this);
        button3 = new JButton("3");
        button3.setFont(fontti);
        button3.addActionListener(this);
        button4 = new JButton("4");
        button4.setFont(fontti);
        button4.addActionListener(this);
        button5 = new JButton("5");
        button5.setFont(fontti);
        button5.addActionListener(this);
        button6 = new JButton("6");
        button6.setFont(fontti);
        button6.addActionListener(this);
        button7 = new JButton("7");
        button7.setFont(fontti);
        button7.addActionListener(this);
        button8 = new JButton("8");
        button8.setFont(fontti);
        button8.addActionListener(this);
        button9 = new JButton("9");
        button9.setFont(fontti);
        button9.addActionListener(this);
        button11 = new JButton(">");
        button11.setBackground(Color.green);
        button11.setFont(fontti);
        button11.addActionListener(this);
        button0 = new JButton("0");
        button0.setFont(fontti);
        button0.addActionListener(this);
        button12 = new JButton("<");
        button12.setBackground(Color.red);
        button12.setFont(fontti);
        button12.addActionListener(this);

        nappainkentta.add(button1);
        nappainkentta.add(button2);
        nappainkentta.add(button3);
        nappainkentta.add(button4);
        nappainkentta.add(button5);
        nappainkentta.add(button6);
        nappainkentta.add(button7);
        nappainkentta.add(button8);
        nappainkentta.add(button9);

        nappainkentta.add(button12);
        nappainkentta.add(button0);
        nappainkentta.add(button11);
        nappainIkkuna.add(nappainkentta);
        nappainIkkuna.setVisible(true);
        nappainIkkuna.setSize(310, 310);
        nappainIkkuna.setLocation(ALLBITS, ABORT);
        nappainIkkuna.setAlwaysOnTop(true);

    }

}
