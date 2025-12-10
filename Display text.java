import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class MessageApplet1 extends JApplet {

    public void init() {
        // Use a JLabel to show text
        JLabel label = new JLabel("Hello from Swing Applet!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);  // add label to applet
    }
}
