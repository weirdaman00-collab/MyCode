import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculator extends JFrame implements ActionListener {
    JLabel message;
    JRadioButton redBtn, yellowBtn, greenBtn;
    ButtonGroup group;
    public calculator() {
        setTitle("Traffic Light Simulation");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        message = new JLabel("", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        add(message, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        redBtn = new JRadioButton("Red");
        yellowBtn = new JRadioButton("Yellow");
        greenBtn = new JRadioButton("Green");
        group = new ButtonGroup();
        group.add(redBtn);
        group.add(yellowBtn);
        group.add(greenBtn);
        panel.add(redBtn);
        panel.add(yellowBtn);
        panel.add(greenBtn);
        add(panel, BorderLayout.CENTER);
        redBtn.addActionListener(this);
        yellowBtn.addActionListener(this);
        greenBtn.addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (redBtn.isSelected()) {
            message.setText("STOP");
            message.setForeground(Color.RED);
        }
        else if (yellowBtn.isSelected()) {
            message.setText("READY");
            message.setForeground(Color.ORANGE);
        }
        else if (greenBtn.isSelected()) {
            message.setText("GO");
            message.setForeground(Color.GREEN);
        }
    }
    public static void main(String[] args) {
        new calculator();
    }
}
