package element;

import utils.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class PlayFrame extends JFrame {

    PlayFrame that = this;

    LinkedList<Obj> objList = new LinkedList<>();
    LinkedList<Obj> removeList = new LinkedList<>();
    LinkedList<Obj> addList = new LinkedList<>();



    Image background = tools.bg;



    Hero hero_1 = new Hero(this,1);
    Obstacle obstacle = new Obstacle(1);
    {
        addList.add(hero_1);
        addList.add(obstacle);
    }

    public PlayFrame(){
        //frame
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //keyListener
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                hero_1.keypress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                hero_1.keyRelease(e);
            }
        });

        //mouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Point destination = new Point(x,y);
                hero_1.fire(destination);
            }
        });

        //timer
        new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.repaint();
            }
        }).start();
    }

    Image cache ;
    public void paint(Graphics g){
        if(cache == null){
            cache = this.createImage(1200,660);
        }
        Graphics gImage = cache.getGraphics();
        gImage.drawImage(background,0,0,this );
        for(Obj o : objList){
            o.paintSelf(gImage);
        }
        g.drawImage(cache,0,0,this);

        objList.removeAll(removeList);
        for( int i = 0; i < addList.size(); i++){
            objList.add(addList.getLast());
            addList.removeLast();
        }


    }

}
