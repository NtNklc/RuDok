package rudok.slotState;

import rudok.model.Slot;
import rudok.view.SlideView;
import rudok.view.toolBar.StrokeEnum;

import java.awt.*;

public class AddState implements SlotState{
    private  int red = 0, green = 0, blue = 0;
    private Stroke strokeBasic = new BasicStroke(5,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, null,0);
    private Stroke strokeDashed = new BasicStroke(5,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1,new float[]{8, 8}, 0);
    private Stroke stroke = strokeBasic;

    public void setColour(Color colour){
        if(colour != null){
            red = colour.getRed();
            green = colour.getGreen();
            blue = colour.getBlue();
        }
    }

    public void selectStroke(StrokeEnum e){
        if(e == StrokeEnum.DASHED)
            stroke = strokeDashed;
        else stroke = strokeBasic;
    }

    @Override
    public void editSlot(int x, int y, SlideView slideView){
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
}
