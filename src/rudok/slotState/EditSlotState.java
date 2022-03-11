package rudok.slotState;

import rudok.view.SlideView;
import rudok.view.SlotView;

public class EditSlotState implements SlotState{
    @Override
    public void editSlot(int x, int y, SlideView slideView) {
        SlotView cur = slideView.getCurrentSlot();
        if(cur == null) return;
        cur.getDialog().openDialog(cur);
    }
}
