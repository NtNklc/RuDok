package rudok.view;

import rudok.action.popup.CustomText;
import rudok.model.ImageSlot;
import rudok.model.Slot;
import rudok.model.TextSlot;
import rudok.observer.ISubscriber;
import rudok.slot.*;
import rudok.slotState.TextState;

import java.awt.*;

public class SlotView implements ISubscriber {
    private Slot model;
    private SlideView parent;
    private Shape shape;
    private ISlotDialog dialog;
    private CustomText text;
    private IDrawSlot drawSlot;

    public SlotView(Slot model, SlideView parent, IDrawSlot drawSlot) {
        this.parent = parent;
        shape = new Rectangle();
        text = new CustomText(this);
        this.drawSlot = drawSlot;
        setModel(model);
    }

    @Override
    public void update(Object notification) {
        setShape();
    }

    public void setShape(){
        double w = parent.getWidth();
        double h = parent.getHeight();
        ((Rectangle)shape).setRect((int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h), (int)(model.getWidth()*w), (int)(model.getHeight()*h));
    }

    public void showSlot(Graphics2D g){
        g.setColor(new Color(model.getRed(), model.getGreen(), model.getBlue(), 125));

        double w = parent.getWidth();
        double h = parent.getHeight();
        drawSlot.draw(g, this, (int)w,(int)h);
        g.setStroke(model.getStroke());
        g.drawRect((int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h), (int)(model.getWidth()*w), (int)(model.getHeight()*h));
        g.fillRect((int)(model.getxCoordinate()*w), (int)(model.getyCoordinate()*h), (int)(model.getWidth()*w), (int)(model.getHeight()*h));
    }

    public boolean isInside(int x, int y){
        return shape.contains(new Point(x,y));
    }

    private void setModel(Slot model){
        if (this. model != null)
            model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());

        if(this.model instanceof TextSlot){
            dialog = new TextSlotDialog();
            if(drawSlot == null)
                drawSlot = new DrawTextState();
        }
        if(this.model instanceof ImageSlot){
            dialog = new ImageSlotDilaog();
            if(drawSlot == null)
                drawSlot = new DrawImageState();
        }
    }

    public Slot getModel() {
        return model;
    }

    public ISlotDialog getDialog() {
        return dialog;
    }

    public void setDialog(ISlotDialog dialog) {
        this.dialog = dialog;
    }

    public CustomText getText() {
        return text;
    }

    public void setText(CustomText text) {
        this.text = text;
    }

    public SlideView getParent() {
        return parent;
    }

    public void setParent(SlideView parent) {
        this.parent = parent;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
