package TutorialGame.src.objects;

import TutorialGame.src.GlobalPosition;
import TutorialGame.src.MainClass;

import javax.swing.*;
import java.awt.*;

public class Enemy extends GlobalPosition {

    private String image = "/images/enemy.png";

    int speed = 5;

    public Enemy(int x, int Y) {
        super(x, Y);
    }

    public void update() {
        x += speed;
        if(x > MainClass.WIDTH-70) {
            speed = -5;
        }
        if(x < 0) {
            speed = 5;
        }
    }

    public void draw (Graphics2D g2d) {
        g2d.drawImage(getEnemyImage(), x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 34, 34);
    }

    public Image getEnemyImage () {
        ImageIcon i = new ImageIcon(getClass().getResource(image));
        return i.getImage();
    }

}
