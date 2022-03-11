package rudok.slot;

import rudok.action.popup.EditTextSlotPopup;
import rudok.view.SlotView;

public class TextSlotDialog implements ISlotDialog{
    @Override
    public void openDialog(SlotView slotView) {
        EditTextSlotPopup popup = new EditTextSlotPopup(slotView);
        popup.setVisible(true);
    }
}
