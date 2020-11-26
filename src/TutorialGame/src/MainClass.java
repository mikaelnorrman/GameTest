package TutorialGame.src;

import javax.swing.*;

public class MainClass {

    public static final int WIDTH = 1000, HEIGHT =1000;
    public static final String TITLE = "Tutorial GAME";


    public static void main(String[] args) {

        JFrame frame = new JFrame(TITLE);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Game());
        frame.setVisible(true);


    }
}