package element;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    public TestFrame(){
        setTitle("AirWars");

        GamePanel gamePanel = new GamePanel();
        Container container = getContentPane();
        container.add(gamePanel);
        setLocationRelativeTo(null);
        pack();
    }

    public static void main(String[] args) {
        TestFrame game = new TestFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.setVisible(true);
    }
}
