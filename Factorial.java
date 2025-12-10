import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialCalculator extends JFrame implements ActionListener {

    JTextField inputField, resultField;
    JButton computeButton;

    public FactorialCalculator() {

        setTitle("Factorial Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Number:"));
        inputField = new JTextField(10);
        add(inputField);

        computeButton = new JButton("Compute");
        computeButton.addActionListener(this);
        add(computeButton);

        add(new JLabel("Factorial:"));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(inputField.getText());
            long fact = 1;

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            resultField.setText(String.valueOf(fact));
        } 
        catch (Exception ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new FactorialCalculator();
    }
}
