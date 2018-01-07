package element;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class OurPlane extends Plane{

    public static final int planeWidth = 40;
    public static final int planeHeight = 70;
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
        if(live_state == LIVE_STATE.DEATH_STATE && frameID >0 && frameID < explodeImgCount){
            drawExplode(g,panel);
            return;
        }
        if(frameID>=explodeImgCount){
            posY = -100;
            posX = -100;
        }

        // if alive
        drawAlive(g,panel);

        drawLifePoint(g,panel);
    }

    // call from keyboard event function
    public void updateLocation(int x, int y){
        posX = x;  //
        posY = y;  //
    }

    public void drawLifePoint(Graphics g,JPanel panel){
        URL url = this.getClass().getResource("/image/heart.png");
        Image img = Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(img,300,460,20,20,(ImageObserver) panel);

    }

    public boolean attcked(EnemyPlane enemyPlane){
        if(posX > enemyPlane.posX&& posX < enemyPlane.posX+EnemyPlane.planeWidth/2 && posY>enemyPlane.posY&&posY<enemyPlane.posY+EnemyPlane.planeHeight/2){
            lifePoint--;
            if(lifePoint == 0){
                live_state = LIVE_STATE.DEATH_STATE;
                frameID = 1;
            }
            return true;

        }
        else return false;

    }

    public void setlifePoint(int life){
        lifePoint = life;
        if(lifePoint == 0){
            live_state = LIVE_STATE.DEATH_STATE;
            frameID = 1;
            posY = -100;
            posX = -100;
        }
    }
}
