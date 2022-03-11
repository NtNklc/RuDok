package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DragAndDropAction extends AbstractRudokAction{
    public DragAndDropAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Click.png"));
        putValue(NAME, "DragAndDrop");
        putValue(SHORT_DESCRIPTION, "DragAndDrop a Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return; //dodaj error kasnije za sve dugmice!!!!
        presentationView.startDragAndDropState();
    }
}
