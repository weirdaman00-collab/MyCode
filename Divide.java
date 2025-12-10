import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculator extends JFrame implements ActionListener {

    JTextField num1Field, num2Field, resultField;
    JButton divideButton;

    public calculator() {
        setTitle("Integer Division");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("NUM1:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("NUM2:"));
        num2Field = new JTextField();
        add(num2Field);

        add(new JLabel("RESULT:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        divideButton = new JButton("DIVIDE");
        divideButton.addActionListener(this);
        add(divideButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());

            int result = num1 / num2;  // may throw ArithmeticException
            resultField.setText(String.valueOf(result));
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid integers!",
                "Number Format Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        catch (ArithmeticException ae) {
            JOptionPane.showMessageDialog(
                this,
                "Cannot divide by zero!",
                "Arithmetic Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
