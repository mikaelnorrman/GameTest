package TutorialGame.src.objects;

import TutorialGame.src.GlobalPosition;
import input.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends GlobalPosition {


    private int velX = 0, velY = 0;
    // Get the image
    private String playerimage = "/images/player.png";

    private LinkedList<Enemy> e = Controller.getEnemyBounds();

//    int velX = 0;
//    int velY = 0;

    public Player(int x, int Y) {
        super(x, Y);
    }

    // Rörelsen av spelaren

    public void update() {
        x += velX;
        y += velY;

        // COLLISION WITH OUTSIDE
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if(x > 965) {
            x = 965;
        }
        if(y > 942) {
            y = 942;
        }

        Collision();

    }

    public void Collision() {

        for (int i = 0; i < e.size(); i++) {

            if (getBounds().intersects(e.get(i).getBounds())) {

                System.out.println("Collision");
            }
        }
    }

    // Get player to move
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            velX = 5;
        } else if (key == KeyEvent.VK_LEFT) {
            velX = -5;
        } else if (key == KeyEvent.VK_DOWN) {
            velY = 5;
        } else if (key == KeyEvent.VK_UP) {
            velY = -5;
        }
    }

    // Get player to stop
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            velX = 0;
        } else if (key == KeyEvent.VK_LEFT) {
            velX = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            velY = 0;
        } else if (key == KeyEvent.VK_UP) {
            velY = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 34, 34);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImage(), x, y, null);


       // g2d.draw(getBounds());    draw out the rectangle
    }

    // Get to use the image
    public Image getPlayerImage() {
        ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
        return i.getImage();
    }

}