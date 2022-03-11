package rudok.model;

import rudok.model.logicTree.RuNode;
import rudok.serialization.SeriazibleStroke;

import java.awt.*;
import java.io.Serializable;

public class Slot extends RuNode implements Serializable {
    private double xCoordinate, yCoordinate, width, height;
    private int red, green, blue;
    private SeriazibleStroke seriazibleStroke;
    private String content;

    public Slot(double XCoordinate, double YCoordinate, int r, int g, int b, double width, double height, Stroke stroke) {
        this.xCoordinate = XCoordinate;
        this.yCoordinate = YCoordinate;
        this.width = width;
        this.height = height;
        red = r;
        green = g;
        blue = b;
        this.seriazibleStroke = new SeriazibleStroke(stroke);
        this.content = "";
    }

    public void positionSlot(double x, double y){
        xCoordinate = x;
        yCoordinate = y;
        notifySubscribers(new Object());
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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
        return seriazibleStroke.getStroke();
    }

    public void setStroke(Stroke stroke) {
        this.seriazibleStroke.setStroke(stroke);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
