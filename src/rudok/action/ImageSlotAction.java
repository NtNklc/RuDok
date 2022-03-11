package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ImageSlotAction extends AbstractRudokAction{

    public ImageSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Copy.png"));
        putValue(NAME, "ImageSlot");
        putValue(SHORT_DESCRIPTION, "Image Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return; //dodaj error kasnije za sve dugmice!!!!
        presentationView.startImageSlotState();
    }
}
