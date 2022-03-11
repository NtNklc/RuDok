package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.view.MainFrame;
import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GoToSlideShowStateAction extends AbstractRudokAction{
    public GoToSlideShowStateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/slideshow.png"));
        putValue(NAME, "State");
        putValue(SHORT_DESCRIPTION, "Change state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(getCurrentPresentation() == null)return;
        PresentationView p = getCurrentPresentation();
        p.startSlideShowState();
    }


}
