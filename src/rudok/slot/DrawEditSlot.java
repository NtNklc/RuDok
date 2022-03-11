package rudok.slot;

import rudok.model.Slot;
import rudok.view.SlotView;

import java.awt.*;

public class DrawEditSlot implements IDrawSlot{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        Slot model = slotView.getModel();
        g.fillRect((int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h), (int)(model.getWidth()*w), (int)(model.getHeight()*h));
    }
}
