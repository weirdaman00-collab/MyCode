import java.swing.*;
public class HelloWorldFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Frame");
        JLabel label = new JLabel("Hello World", JLabel.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
