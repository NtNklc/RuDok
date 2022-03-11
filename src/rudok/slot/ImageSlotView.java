package rudok.slot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSlotView extends JPanel {
    private String path = "";

    public ImageSlotView(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String imgp = path;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgp));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0,getWidth(), getHeight(),null);
    }
}
