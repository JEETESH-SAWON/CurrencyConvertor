package org.example;

import com.google.gson.Gson;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

// Our class extends Frame class and implements ActionListener interface

public class CurrencyConvertor extends Frame implements ActionListener, WindowListener, KeyListener {
    // creating instances of TextField and Button class
    TextField tf1,tf3;
    Button b1;
    Choice c1,c2;

    String[] currency={"USD","AED","AFN","ALL","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BGN","BHD","BIF","BMD","BND","BOB","BRL","BSD","BTN","BWP","BYN","BZD","CAD","CDF","CHF","CLP","CNY","COP","CRC","CUP","CVE","CZK","DJF","DKK","DOP","DZD","EGP","ERN","ETB","EUR","FJD","FKP","FOK","GBP","GEL","GGP","GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","HUF","IDR","ILS","IMP","INR","IQD","IRR","ISK","JEP","JMD","JOD","JPY","KES","KGS","KHR","KID","KMF","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL","LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRU","MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NOK","NPR","NZD","OMR","PAB","PEN","PGK","PHP","PKR","PLN","PYG","QAR","RON","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SEK","SGD","SHP","SLE","SLL","SOS","SRD","SSP","STN","SYP","SZL","THB","TJS","TMT","TND","TOP","TRY","TTD","TVD","TWD","TZS","UAH","UGX","UYU","UZS","VES","VND","VUV","WST","XAF","XCD","XDR","XOF","XPF","YER","ZAR","ZMW","ZWL"};

    // instantiating using constructor
    CurrencyConvertor() {
        // instantiating objects of text field and button
        // setting position of components in frame
        tf1 = new TextField();
        tf1.setBounds(80, 80, 150, 20);
        tf1.setText("Enter Numerical value");

        c1 = new Choice();
        c1.setBounds(80, 130, 150, 20);

        c2 = new Choice();
        c2.setBounds(80, 180, 150, 20);

        tf3 = new TextField();
        tf3.setBounds(80, 230, 150, 20);
        tf3.setEditable(false);
        tf3.setFocusable(false);
        tf3.setText("Result");

        b1 = new Button("Calculate");
        b1.setBounds(80, 280, 150, 50);
        for(String s:currency){
            c1.add(s);
            c2.add(s);
        }
        // adding action listener
        tf1.addKeyListener(this);
        b1.addActionListener(this);
        // adding components to frame
        add(tf1);
        add(c1);
        add(c2);
        add(tf3);
        add(b1);
        // setting size, layout and visibility of frame
        setSize(300, 400);
        setLayout(null);
        setVisible(true);
        addWindowListener(this);
        setResizable(false);
        setTitle("Currency Convertor");

        Color c = Color.decode("#32527b");
        setBackground(c);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setIconImage(icon);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        tf1.setText(null);
        tf1.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9');
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public Map<?,?> readFile() throws IOException {
        String file_name="data.json";
        Gson gson = new Gson();
        Map<?,?> data;
        Path path = Paths.get(file_name);
        Reader reader = Files.newBufferedReader(path);
        data = gson.fromJson(reader, Map.class);
        return (Map<?, ?>) data.get("conversion_rates");
    }

    // defining the actionPerformed method to generate an event on buttons
    public void actionPerformed(ActionEvent e) {
        Map<?,?> pull;
        String s1;
        String cs1,cs2;
        try {
            s1 = tf1.getText();
            cs1 = c1.getItem(c1.getSelectedIndex());
            cs2 = c2.getItem(c2.getSelectedIndex());
            pull= readFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        double x,y,z;
        x= (double) pull.get(cs1);
        y= (double) pull.get(cs2);
        z= y/x;
        if(s1.isEmpty()){tf3.setText("Error");}
        else {
            String result = String.valueOf(z * Double.parseDouble(s1));
            tf3.setText(result);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

