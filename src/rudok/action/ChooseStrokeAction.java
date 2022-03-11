package rudok.action;

import rudok.action.popup.StrokePopup;
import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChooseStrokeAction extends AbstractRudokAction{

    public ChooseStrokeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Stroke.png"));
        putValue(NAME, "StrokePicker");
        putValue(SHORT_DESCRIPTION, "Choose stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Stroke btn clicked");
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return;
        StrokePopup popup = new StrokePopup(presentationView);
    }
}
