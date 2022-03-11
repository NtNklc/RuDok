package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;

public class TextSlotAction extends AbstractRudokAction{
    public TextSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Text.png"));
        putValue(NAME, "TextSlot");
        putValue(SHORT_DESCRIPTION, "Text Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return; //dodaj error kasnije za sve dugmice!!!!
        presentationView.startTextSlotState();
    }
}
