package rudok.slot;

import rudok.action.popup.EditImageSlotPopup;
import rudok.view.SlotView;

public class ImageSlotDilaog implements ISlotDialog{
    @Override
    public void openDialog(SlotView slotView) {
        EditImageSlotPopup popup = new EditImageSlotPopup(slotView);
        popup.setVisible(true);
    }
}
