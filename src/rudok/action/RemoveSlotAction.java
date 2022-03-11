package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveSlotAction extends AbstractRudokAction{
    public RemoveSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Bin.png"));
        putValue(NAME, "RemoveSlot");
        putValue(SHORT_DESCRIPTION, "Remove Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return; //dodaj error kasnije za sve dugmice!!!!
        presentationView.startRemoveState();
    }
}
