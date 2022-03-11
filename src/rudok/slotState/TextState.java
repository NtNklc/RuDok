package rudok.slotState;

import rudok.model.Slot;
import rudok.model.TextSlot;
import rudok.view.SlideView;

public class TextState extends AddState {
    @Override
    public void editSlot(int x, int y, SlideView slideView) {
        Slot slot = new TextSlot(x * 1.0 / slideView.getWidth(), y * 1.0 / slideView.getHeight(), getRed(), getGreen(), getBlue(), 50.0 / slideView.getWidth(), 50.0 / slideView.getHeight(), getStroke());
        slideView.getModel().addChild(slot);
        System.out.println("Add state");
    }
}
