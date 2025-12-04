import java.applet.Applet;
import java.awt.Graphics;

/* <applet code="SimpleMessageApplet" width=400 height=200> </applet> */

public class SimpleMessageApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Welcome to Java Applet Programming!", 50, 100);
    }
}
