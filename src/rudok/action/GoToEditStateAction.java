package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GoToEditStateAction extends AbstractRudokAction{
    public GoToEditStateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/wrench.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Change state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getCurrentPresentation() == null)return;
        PresentationView presentationView = getCurrentPresentation();
        presentationView.startEditState();
    }
}
