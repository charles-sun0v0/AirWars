package element;
// base class of Plane

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;

public class Plane {
public static enum LIVE_STATE{ALIVE_STATE,DEATH_STATE};

static final int PLNAE_STEP_Y = 5;
static final int PLNAE_STEP_X= 0;

public int posX = -100;
public int posY = -100;

public LIVE_STATE live_state = LIVE_STATE.ALIVE_STATE;
public int lifePoint = 1;
protected int explodeImgCount = 9;
private Image explodeImg[] = new Image[explodeImgCount];
public int frameID = 0;

public Plane(){
    for (int i = 0; i < explodeImgCount; i++){
//        try {
//            File directory = new File(".");
//            directory.getCanonicalPath();
//            String x = directory.getAbsolutePath();
//            directory.getPath(); //
//            System.out.println(x);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        URL url = this.getClass().getResource("../image/explode"+(i+1)+".gif");
        System.out.println(url);
        explodeImg[i] = Toolkit.getDefaultToolkit().getImage(url);
    }
}

public void initLocation(int x, int y){
    posX = x;
    posY = y;
}
public void drawExplode(Graphics g, JPanel panel){
        g.drawImage(explodeImg[frameID],posX,posY,30,40,(ImageObserver)panel);
       // System.out.println("?");
        frameID++;
        return;
}

}
