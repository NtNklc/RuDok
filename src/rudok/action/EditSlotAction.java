package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditSlotAction extends AbstractRudokAction{
    public EditSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/editing.png"));
        putValue(NAME, "Edit slot");
        putValue(SHORT_DESCRIPTION, "Edit Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null)return;
        presentationView.startEditSlotState();
    }
}
