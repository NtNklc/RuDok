package rudok.slotState;

import rudok.view.SlideView;
import rudok.view.SlotView;

public class DragAndDropState implements SlotState{
    @Override
    public void editSlot(int x, int y, SlideView slideView) {
        SlotView currentSlot = slideView.getCurrentSlot();
        System.out.println("Pokusao Cursor state");
        if (currentSlot == null) return;
        currentSlot.getModel().positionSlot(x*1.0/slideView.getWidth(), y*1.0/slideView.getHeight());
        System.out.println("Cursor state");
    }
}
