package input;

import TutorialGame.src.objects.Enemy;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    static LinkedList<Enemy> e = new LinkedList<Enemy>();

    Enemy TempEnemy;

    public Controller() {
        addEnemy(new Enemy(100, 100));
        addEnemy(new Enemy(900, 100));
        addEnemy(new Enemy(100, 200));
        addEnemy(new Enemy(800, 300));
        addEnemy(new Enemy(100, 400));
        addEnemy(new Enemy(700, 500));
        addEnemy(new Enemy(100, 600));
        addEnemy(new Enemy(600, 700));
        addEnemy(new Enemy(100, 800));
        addEnemy(new Enemy(500, 900));
    }

    public void drwa(Graphics2D g2d) {
        for (int i = 0; i < e.size(); i++) {
            TempEnemy = e.get(i);

            TempEnemy.draw(g2d);
        }
    }

    public void update() {
        for (int i = 0; i < e.size(); i++) {
            TempEnemy = e.get(i);

            // Remove all enemy´s if
           // if (TempEnemy.x < 20){
           //     removeEnemy(TempEnemy);
           // }

            TempEnemy.update();
        }
    }

    public void addEnemy(Enemy enemy) {
        e.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        e.remove(enemy);
    }

    public static LinkedList<Enemy> getEnemyBounds() {
        return e;
    }

}
