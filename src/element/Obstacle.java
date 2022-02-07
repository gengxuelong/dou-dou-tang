package element;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.LinkedList;

public class Obstacle extends Obj{

    int i ;

    LinkedList<Rectangle> rectangles = new LinkedList<>();
    {
        Rectangle rect1 = new Rectangle(80,500,1000,40);
        Rectangle rect2 = new Rectangle(180,400,100,40);
        Rectangle rect3 = new Rectangle(680,400,100,40);
        rectangles.add(rect1);
        rectangles.add(rect2);
        rectangles.add(rect3);

    }

    public Obstacle(int i){
        this.i = i ;
    }


    @Override
    public void paintSelf(Graphics g) {
        if( i == 1){
            Color c = g.getColor();
            g.setColor(Color.CYAN);
           for(Rectangle r : rectangles){
               g.fill3DRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight(),false);
           }
            g.setColor(c);

        }
    }

    public boolean collision_detection(Rectangle rectangle){
        for( Rectangle r : rectangles){
            if(r.intersects(rectangle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int d) {

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
