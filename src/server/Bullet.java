package server;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class Bullet {
    // reference : java 编程游戏开发编程教程，郑秋生，夏敏捷，清华大学出版社
    // Speed and width of bullet
    static final int BULLET_STEP_X = 3;
    static final int BULLET_STEP_Y = 15;
    static final int BULLET_WIDTH= 40;

    // location of bullet
    public int posX = 0;
    public int posY = -20;

    boolean toDraw = false;

    private int imgCount = 4;
    private Image img[] = null;
    private  int frameID = 0;

    Bullet(){
        img = new Image[imgCount];
        for(int i = 0; i < imgCount; i++){
            URL url = this.getClass().getResource("/image/bullet_"+i+".png");
            img[i] = Toolkit.getDefaultToolkit().getImage(url);
        }
    }

    public void initLocation(int x, int y){
        posX = x;
        posY = y;
    }

    public void drawBullet(Graphics g, JPanel panel){
        if(toDraw)
            g.drawImage(img[frameID++],posX,posY,(ImageObserver)panel);
        if(frameID == imgCount){
            frameID = 0;
        }

    }

    public void setToDraw(boolean toDraw) {
        this.toDraw = toDraw;
    }

    public void updateBullet(){
        if(toDraw){
            posY -= BULLET_STEP_Y;
        }
    }
}
