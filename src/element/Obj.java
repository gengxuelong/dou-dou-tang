package element;

import java.awt.*;

public abstract class Obj {

    Image image;
    Point location = new Point(20,90);
    int height = 80;
    int width = 80;
    PlayFrame frame ;
    abstract public void paintSelf(Graphics g);
    public abstract void move(int derection);
    public abstract void jump();
    public abstract void fall();
    public abstract void fire(Point destination);
    public abstract Rectangle getRect();

}
