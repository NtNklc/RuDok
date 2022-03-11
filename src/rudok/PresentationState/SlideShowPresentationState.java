package rudok.PresentationState;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.*;

public class SlideShowPresentationState implements PresentationState {
    @Override
    public void show(PresentationView presentationView) {
        clear(presentationView);

        presentationView.add(presentationView.getSlideShowView(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(presentationView);
    }

    @Override
    public void clear(PresentationView presentationView) {
        presentationView.removeAll();
        presentationView.revalidate();
    }
}
