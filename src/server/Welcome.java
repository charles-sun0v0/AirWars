package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.net.URL;

public class Welcome extends JPanel implements ActionListener{
    public Welcome(){
        setSize(320,480);
    }


    public void paint(Graphics g){
        URL url = this.getClass().getResource("/image/cover.jpg");
        Image img = Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(img,0,0,320,480,(ImageObserver) this);
    }

    public void actionPerformed(ActionEvent e){

    }



}
