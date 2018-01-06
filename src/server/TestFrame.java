package server;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    public TestFrame(){
        setTitle("AirWars");

        setLocationRelativeTo(null);
        Dialog dialog = new Dialog(this);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        GamePanel gamePanel = new GamePanel(10001);
        Container container = getContentPane();
        container.add(gamePanel);
        pack();
    }

    public static void main(String[] args) {
        TestFrame game = new TestFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
