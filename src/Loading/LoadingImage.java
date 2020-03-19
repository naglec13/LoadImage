package Loading;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
     * This class demonstrates how to load an Image from an external file
     */
class loadImageApp extends Component {

        BufferedImage img;

        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }

        public loadImageApp() {
            try {
                img = ImageIO.read(new File("src/Loading/animal.jpg"));
            } catch (IOException e) {
            }

        }

        public Dimension getPreferredSize() {
            if (img == null) {
                return new Dimension(100,100);
            } else {
                return new Dimension(img.getWidth(null), img.getHeight(null));
            }
        }

        public static void main(String[] args) {

            JFrame f = new JFrame("Load Image Sample");

            f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(1000);
                }
            });

            f.add(new loadImageApp());
            f.pack();
            f.setVisible(true);
        }
    }
