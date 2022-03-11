package rudok.slot;

import rudok.action.popup.CustomText;
import rudok.model.Slot;
import rudok.view.SlotView;

import javax.swing.*;
import java.awt.*;

public class DrawTextState implements IDrawSlot{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        Slot model = slotView.getModel();
        CustomText text = slotView.getText();
        text.setText("");
        text.setEditable(false);
        text.formatString();
        CellRendererPane cellRendererPane=new CellRendererPane();
        cellRendererPane.paintComponent(g,text,slotView.getParent(),(int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h),(int)(model.getWidth()*w), (int)(model.getHeight()*h));
    }
}
