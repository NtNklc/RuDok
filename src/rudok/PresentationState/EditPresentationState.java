package rudok.PresentationState;

import rudok.view.PresentationView;

import javax.swing.*;

public class EditPresentationState implements PresentationState {
    @Override
    public void show(PresentationView presentationView) {
       clear(presentationView);
        presentationView.add(presentationView.getSplit());
        SwingUtilities.updateComponentTreeUI(presentationView);

    }

    @Override
    public void clear(PresentationView presentationView) {
        presentationView.removeAll();
        presentationView.revalidate();
    }
}
