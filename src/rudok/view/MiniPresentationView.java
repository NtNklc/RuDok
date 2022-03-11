package rudok.view;

import rudok.model.workspace.Presentation;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class MiniPresentationView extends APresentationView implements ISubscriber {
    private Presentation model = null;

    public MiniPresentationView(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSlidePanel(this);

    }

    @Override
    public void update(Object notification) {
        updatePresentation(ViewType.LEFT);
        System.out.println("Usao u mini prez update");
    }
}
