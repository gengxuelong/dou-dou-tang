package element;

import utils.tools;

import java.awt.*;

public class Zidan extends Obj{

    {
        image = tools.zidan;
        height = 5;
        width = 5;
    }

    Point destination ;
    int speed = 60;

    int D_x;
    int D_y;
    double D;


    public Zidan(PlayFrame frame,Point location,Point destination){

        this.frame = frame;
        this.location = location;
        this.destination = destination;
         D_x = (destination.x - location.x);
         D_y = (destination.y - location.y);
         D = Math.sqrt(D_x*D_x + D_y*D_y);

    }

    @Override
    public void paintSelf(Graphics g) {

        g.drawImage(image,location.x,location.y,width,height,frame);
        move(0);
    }

    @Override
    public void move(int z) {

        location.x += (int)(speed*D_x/D);
        location.y += (int)(speed*D_y/D);
    }

    @Override
    public void jump() {

    }

    @Override
    public void fall() {

    }

    @Override
    public void fire(Point destination) {

    }


    @Override
    public Rectangle getRect() {
        return null;
    }
}
