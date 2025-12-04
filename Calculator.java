import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalc extends JFrame implements ActionListener {
    JTextField t;
    double num1 = 0, num2 = 0;
    String op = "";

    public SimpleCalc() {
        t = new JTextField();
        t.setEditable(false);
        add(t, BorderLayout.NORTH);

        JPanel p = new JPanel(new GridLayout(4, 4));
        String[] b = {"7","8","9","/",
                      "4","5","6","*",
                      "1","2","3","-",
                      "0","%","+","="};

        for (String s : b) {
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            p.add(btn);
        }

        add(p);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ("0123456789".contains(s)) {
            t.setText(t.getText() + s);
        }
        else if ("+-*/%".contains(s)) {
            num1 = Double.parseDouble(t.getText());
            op = s;
            t.setText("");
        }
        else if (s.equals("=")) {
            num2 = Double.parseDouble(t.getText());
            double result = 0;

            if (op.equals("+")) result = num1 + num2;
            else if (op.equals("-")) result = num1 - num2;
            else if (op.equals("*")) result = num1 * num2;
            else if (op.equals("/")) {
                if (num2 == 0) {
                    t.setText("Error");
                    return;
                }
                result = num1 / num2;
            }
            else if (op.equals("%")) {
                if (num2 == 0) {
                    t.setText("Error");
                    return;
                }
                result = num1 % num2;
            }

            t.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new SimpleCalc();
    }
}
