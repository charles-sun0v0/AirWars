package server;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    public TestFrame(){
        setTitle("AirWars-Server");
        Dialog dialog = new Dialog(this);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

  //      Welcome welcome = new Welcome();

        GamePanel gamePanel = new GamePanel(dialog.getPort(),this);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.add(gamePanel);
//        JPanel bottom = new JPanel();
//        bottom.add(new TextArea("Click Screen to Start or Pause"));
//        container.add(bottom);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        TestFrame game = new TestFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
