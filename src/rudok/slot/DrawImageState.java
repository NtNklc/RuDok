package rudok.slot;

import rudok.model.Slot;
import rudok.view.SlotView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawImageState implements IDrawSlot{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        Slot model = slotView.getModel();
        String path = model.getContent();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, (int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h), (int)(model.getWidth()*w), (int)(model.getHeight()*h),null);
    }
}
