package element;

import utils.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Hero extends Obj {
    final int LEFT = 1;
    final int RIGHT = 2;
    final int DOWN = 3;

    {
        height = 40;
        width = 40;
        location = new Point(200,140);
    }
    public Hero(PlayFrame frame,int i){
        if(i == 1){
            image = tools.hero_1;
        }
        this.frame = frame;
    }
    private void action(){
        if(isUp){
            jump();
        }
        if(isDown){
            move(DOWN);
        }
        if(isLeft){
            move(LEFT);
        }
        if(isRight){
            move(RIGHT);
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(image,location.x,location.y,height,width,null);
        fall();
        action();
    }

    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isUp = false;
    private boolean isDown = false;
    public void keypress(KeyEvent e){
        int key = e.getKeyCode();
        switch (key) {
            case 37 -> isLeft = true;
            case 39 -> isRight = true;
            case 38 -> isUp = true;
            case 40 -> isDown = true;
        }
    }
    public void keyRelease(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case 37 -> isLeft = false;
            case 39 -> isRight = false;
            case 38 -> isUp = false;
            case 40 -> isDown = false;
        }
    }




    @Override
    public void move(int d) {
        switch(d){
            case LEFT :
                location.x -= 6;
                break;
            case RIGHT :
                location.x += 6;
                break;
            case DOWN :
                location.y += 3;
        }
    }

    boolean isCooled = true;
    @Override
    public void jump() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(isCooled){
                    isCooled = false;
                    int i = 0;
                    while(i < 20){
                        location.y -= 3;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                    isCooled = true;
                }
            }
        }).start();
    }

    @Override
    public void fall() {
        if(!frame.obstacle.collision_detection(this.getRect())){
            this.location.y = this.location.y + 6;
        }
    }

    @Override
    public void fire(Point destination) {

        int x = frame.hero_1.location.x + frame.hero_1.width/3;
        int y = frame.hero_1.location.y + frame.hero_1.height/4;
        Point location = new Point(x,y);
        Zidan zidan = new Zidan(frame,location,destination);
        frame.addList.add(zidan);
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(location.x,location.y,width,height);
    }
}
