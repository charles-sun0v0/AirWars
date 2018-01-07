package element;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class EnemyPlane extends Plane {
    public int ENEMYPLNE_CATECORY = 1; // 1,2,3
    public static final int planeWidth = 40;
    public static final int planeHeight = 80;
    public EnemyPlane(int type){
        switch (type){
            case 1:
                ENEMYPLNE_CATECORY = 1;break;
            case 2:
                ENEMYPLNE_CATECORY = 2;
                lifePoint = 2;break;

            case 3:
                ENEMYPLNE_CATECORY = 3;break;
            default:
                ENEMYPLNE_CATECORY = 1;break;
        }
        live_state = LIVE_STATE.DEATH_STATE;
    }

    public void drawAlive(Graphics g, JPanel panel){
        URL url = this.getClass().getResource("/image/enemy_"+ENEMYPLNE_CATECORY+".png");
        Image img = Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(img,posX,posY,planeWidth,planeHeight,(ImageObserver) panel);
    }

    public void drawPlane(Graphics g, JPanel panel){
        if(live_state == LIVE_STATE.DEATH_STATE && frameID>0 &&frameID < explodeImgCount){
            drawExplode(g,panel);
            return;
        }

        if(live_state == LIVE_STATE.ALIVE_STATE)
        drawAlive(g,panel);
    }

    public void updateLocation(){
            if(live_state == LIVE_STATE.ALIVE_STATE){
               posY += PLNAE_STEP_Y;
            }
            return;

    }

    // attcak!
    public void getTarget(OurPlane ourPlane){
        int x = (ourPlane.posX+40 - posX)/40;
        int y = (ourPlane.posY+40 - posY)/40;
        posX += x;
        posY += y;
        if(x < 5){
     //       posX += 10;
            posY += 10;
        }

    }
    public void reset(){
        frameID = 0;
        live_state = LIVE_STATE.ALIVE_STATE;
        lifePoint = 1;
        if(ENEMYPLNE_CATECORY == 2)
            lifePoint = 2;
    }

    public void lifePointMinus(){
        lifePoint--;
        if(lifePoint == 0){
            live_state = LIVE_STATE.DEATH_STATE;
            frameID = 1;
            if(ENEMYPLNE_CATECORY == 2)
               lifePoint = 2; // Death and relief
            else
               lifePoint = 1;
        }

    }
    public void setDeath(){
        live_state = LIVE_STATE.DEATH_STATE;
    }
    public void setAlive(){
        reset();
    }
    public boolean isDeath(){
        return live_state==LIVE_STATE.DEATH_STATE;
    }

    public void setProperty(int alive, int x, int y){
        if(alive == 1){
            live_state = LIVE_STATE.ALIVE_STATE;
        }else if(alive == 0){
            live_state = LIVE_STATE.DEATH_STATE;
        }else{
            lifePointMinus();
        }
        posX = x;
        posY = y;


    }
}
