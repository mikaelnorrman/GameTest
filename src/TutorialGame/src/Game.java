package TutorialGame.src;

import TutorialGame.src.objects.Enemy;
import TutorialGame.src.objects.Player;
import input.Controller;
import input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    Timer mainTimer;

    // Variabales
    private String background = "/images/background.png";

    // Objects
    Player p;
//  Enemy e;
    Controller c;

    public Game(){
        setFocusable(true);

        mainTimer = new Timer(10, this); // Hur fort spelet går
        mainTimer.start();

        p = new Player(100, 100);
//        e = new Enemy(200, 200);
        c = new Controller();


        addKeyListener(new KeyInput(p));
    }

    public void paint (Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(getBackgroundImage(), 0 ,0, this);

        p.draw(g2d);
//        e.draw(g2d);
       c.drwa(g2d);

    }

    // Creating background image
    public Image getBackgroundImage() {
        ImageIcon i = new ImageIcon(getClass().getResource(background));
        return i.getImage();
    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        repaint();
        p.update();
//        e.update();
        c.update();
    }
}