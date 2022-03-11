package rudok.action;

import rudok.view.PresentationView;
import rudok.view.SlideShowView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PreviousSlideAction extends AbstractRudokAction{

    public PreviousSlideAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Back.png"));
        putValue(NAME, "PreviousSlide");
        putValue(SHORT_DESCRIPTION, "Previous Slide");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        SlideShowView slideShowView = presentationView.getSlideShowView();
        slideShowView.getCardLayout().previous(slideShowView.getjPanel());
    }
}
