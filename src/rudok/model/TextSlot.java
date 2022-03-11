package rudok.model;

import java.awt.*;

public class TextSlot extends Slot{
    public TextSlot(double XCoordinate, double YCoordinate, int r, int g, int b, double width, double height, Stroke stroke) {
        super(XCoordinate, YCoordinate, r, g, b, width, height, stroke);
        setContent("Insert text");
    }
}
