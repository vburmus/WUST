package ProjObserver;

import Obseravable.ConditionData;
import Observers.CurrentConditionOutput;
import Observers.CurrentFuelLevel;
import Observers.CurrentKW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectObserver {
    private static  JButton button,button2;
    private static JTextField text1,text2,text3,text4,text5,text6;
    private static JPanel panel;
    private static JLabel stanGumy,KM,typSilnika,pozostaloPaliwa ,pojemnoscZbiornika,pojemnosc;
    public static void main(String[] args) {
        String S ="";
        ConditionData carConditions = new ConditionData();
        CurrentConditionOutput condition = new CurrentConditionOutput(carConditions);
        CurrentKW kw = new CurrentKW(carConditions);
        CurrentFuelLevel fuel = new CurrentFuelLevel(carConditions);

        //Symulacje
        /*
        System.out.println("______________________nr1______________________");
        carConditions.setCondition(70,300,"diesel", 50,4, 50);
        System.out.println("______________________nr2______________________");
        carConditions.setCondition(80,200,"benzyna", 70,3, 50);
    */
        JFrame frame = new JFrame("Konwerter ");
        button = new JButton("Wyczysc pola");
        button2 = new JButton("Zmienic stan");
        panel = new JPanel();
        text1 = new JTextField();
        text2 = new JTextField(20);
        text3 = new JTextField(20);
        text4 = new JTextField(20);
        text5 = new JTextField(20);
        text6 = new JTextField(20);
        stanGumy = new JLabel("Stan gumy");
        KM = new JLabel("KM");
        typSilnika = new JLabel("Typ silnika");
        pozostaloPaliwa = new JLabel("Paliwa pozostalo(%)");
        pojemnoscZbiornika = new JLabel("Pojemnosc zbiornika(l.)");
        pojemnosc = new JLabel("Pojemnosc silnika");
        frame.add(BorderLayout.NORTH,panel);
        panel.setLayout(new GridLayout(6,2));

        panel.add(stanGumy);
        panel.add(KM);
        panel.add(typSilnika);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(pozostaloPaliwa);
        panel.add(pojemnoscZbiornika);
        panel.add(pojemnosc);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(button);
        panel.add(button2);
        class buttonReaction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
            }
        }
        class buttonSet implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {

                    carConditions.setCondition(Integer.parseInt(text1.getText()),Integer.parseInt(text2.getText()),text3.getText(), Integer.parseInt(text4.getText()), Integer.parseInt(text5.getText()), Integer.parseInt(text6.getText()));
                }
                catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Wystapil blad", "", JOptionPane.ERROR_MESSAGE);
                }


            }
        }





        button.addActionListener(new buttonReaction());
        button2.addActionListener(new buttonSet());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,1500);
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(800,200);
        frame.setVisible(true);
    }

}
