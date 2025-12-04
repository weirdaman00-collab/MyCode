import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/* <applet code="FactorialApplet" width=400 height=250> </applet> */

public class FactorialApplet extends Applet implements ActionListener {

    TextField inputField, outputField;
    Button computeButton;

    public void init() {
        Label l1 = new Label("Enter a number:");
        Label l2 = new Label("Factorial:");

        inputField = new TextField(10);
        outputField = new TextField(10);
        outputField.setEditable(false);

        computeButton = new Button("Compute");
        computeButton.addActionListener(this);

        add(l1);
        add(inputField);
        add(l2);
        add(outputField);
        add(computeButton);
    }

    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(inputField.getText());
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        outputField.setText(String.valueOf(fact));
    }
}
