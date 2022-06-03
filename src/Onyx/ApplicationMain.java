package Onyx;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Onyx.screens.Screen;
import Onyx.screens.StartScreen;
import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class ApplicationMain extends JFrame implements KeyListener {

    private AsciiPanel terminal;
    private Screen screen;

    public ApplicationMain() {
        super();
        terminal = new AsciiPanel(80, 50, AsciiFont.CP437_16x16);
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) throws IOException {
        // Adjusting the jframe
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // easily change the name and the icon
        app.setTitle("Onyx");
        // placeholder icon
        app.setIconImage(ImageIO.read(new File("res/icon.png")));
        app.setVisible(true);
    }
}