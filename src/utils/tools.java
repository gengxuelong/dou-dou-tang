package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class tools {
     static String path = "src/image/";
    static public Image hero_1; /*Toolkit.getDefaultToolkit().createImage(path+"hero_1.png")*/
    static public Image zidan ;
    static public Image bg ;
    static {
        try {
            hero_1 = ImageIO.read(tools.class.getClassLoader().getResourceAsStream("image/hero_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            zidan = ImageIO.read(tools.class.getClassLoader().getResourceAsStream("image/zidan.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            bg = ImageIO.read(tools.class.getClassLoader().getResourceAsStream("image/bg.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
