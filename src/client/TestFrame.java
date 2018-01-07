package client;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    public TestFrame(){
        setTitle("AirWars-Client");
        Dialog dialog = new Dialog(this);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        GamePanel gamePanel = new GamePanel(dialog.getIp(),dialog.getPort(),this);
        Container container = getContentPane();
        container.add(gamePanel);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        TestFrame game = new TestFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
