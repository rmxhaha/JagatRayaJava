package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rmx
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;


public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("E:\\University\\Semester 4\\OOP\\JagatRaya\\assets\\Boss.png"));
       } catch (IOException ex) {
           ex.printStackTrace();
           
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters    
        g.setColor(Color.white);
        g.drawImage(image, 0, 0,85,127,null);
    }
}