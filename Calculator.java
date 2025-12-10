import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculator extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    int num1 = 0;
    public calculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        String buttons[] = {
            "7","8","9","+",
            "4","5","6","-",
            "1","2","3","*",
            "0","%","="
        };
        for (String text : buttons) {
            JButton b = new JButton(text);
            b.addActionListener(this);
            panel.add(b);
        }
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        // If number pressed
        if (text.matches("[0-9]")) {
            display.setText(display.getText() + text);
        }
        else if (text.matches("[+\\-*/%]")) {
            try {
                num1 = Integer.parseInt(display.getText()); // FIXED LINE
            } catch (Exception ex) {
                display.setText("Error");
                return;
            }
            operator = text;
            display.setText("");
        }
        else if (text.equals("=")) {
            try {
                int num2 = Integer.parseInt(display.getText());
                int result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "%":
                        if (num2 == 0) throw new ArithmeticException();
                        result = num1 % num2;
                        break;
                }

                display.setText(String.valueOf(result));
            }
            catch (ArithmeticException ex) {
                display.setText("cannot divide by 0");
            }
            catch (Exception ex) {
                display.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
