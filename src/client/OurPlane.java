package client;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class OurPlane extends Plane {
    static final int planeWidth = 40;
    static final int planeHeight = 70;
    public  OurPlane(){
        super();
        lifePoint = 3;
    }

    public void drawAlive(Graphics g, JPanel panel){
        URL url = this.getClass().getResource("/image/ours_1.png");
        Image img = Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(img,posX,posY,planeWidth,planeHeight,(ImageObserver) panel);
    }

    public void drawPlane(Graphics g, JPanel panel){
//        if(live_state == LIVE_STATE.DEATH_STATE && frameID < explodeImgCount){
//            drawExplode(g,panel);
//            return;
//        }

        // if alive
        drawAlive(g,panel);
    }

    // call from keyboard event function
    public void updateLocation(int x, int y){
        posX = x;  //
        posY = y;  //
    }

    public void drawLifePoint(){

    }
}
