import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopnie {
    private static  JButton button;
    private static JTextField textC,textF;
    private static JPanel panel;
    private static JLabel labelF,labelC;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konwerter stopni");
        button = new JButton("Wyczysc pola");
        panel = new JPanel();
        textC = new JTextField(20);
        textF = new JTextField(20);
        labelC = new JLabel("Celsjusz");
        labelF = new JLabel("Fahrenheit");
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        panel.setLayout(new GridLayout(3,2));

        panel.add(labelC);
        panel.add(textC);
        panel.add(labelF);
        panel.add(textF);
        panel.add(button);

        class buttonReaction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                textC.setText("");
                textF.setText("");
            }
        }
        class textReactionC implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {
                    double C = Double.parseDouble(textC.getText());
                    textF.setText(String.valueOf(Konwerter.CToF(C)));
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "", JOptionPane.ERROR_MESSAGE);
                }
                }

        }
        class textReactionF implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {
                    double F = Double.parseDouble(textF.getText());
                    textC.setText(String.valueOf(Konwerter.FToC(F)));
                }
                catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "", JOptionPane.ERROR_MESSAGE);
                }
                }

        }
        textC.addActionListener(new textReactionC());
        textF.addActionListener(new textReactionF());
        button.addActionListener(new buttonReaction());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(800,200);
        frame.setVisible(true);



    }
}
