package rudok.action;

import rudok.view.PresentationView;
import rudok.view.SlideShowView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NextSlideAction extends AbstractRudokAction{

    public NextSlideAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Next.png"));
        putValue(NAME, "NextSlide");
        putValue(SHORT_DESCRIPTION, "Next Slide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        SlideShowView slideShowView = presentationView.getSlideShowView();
        slideShowView.getCardLayout().next(slideShowView.getjPanel());
    }
}
