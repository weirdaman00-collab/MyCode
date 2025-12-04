import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame implements ActionListener {

    JRadioButton red, yellow, green;
    JLabel message;

    public TrafficLight() {

        message = new JLabel("");
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 24));
        add(message, BorderLayout.NORTH);

        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("Green");

        ButtonGroup bg = new ButtonGroup();
        bg.add(red); 
        bg.add(yellow); 
        bg.add(green);

        JPanel panel = new JPanel();
        panel.add(red);
        panel.add(yellow);
        panel.add(green);

        add(panel, BorderLayout.CENTER);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (red.isSelected()) {
            message.setText("STOP");
            message.setForeground(Color.RED);
        }
        else if (yellow.isSelected()) {
            message.setText("READY");
            message.setForeground(Color.ORANGE);
        }
        else if (green.isSelected()) {
            message.setText("GO");
            message.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
