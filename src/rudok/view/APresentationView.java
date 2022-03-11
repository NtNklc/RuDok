package rudok.view;

import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Slide;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class APresentationView extends JPanel implements ISubscriber {
    private Presentation model = null;
    private JPanel slidePanel;

    public void updatePresentation(ViewType v){
        System.out.println("Usao u prez update");
        if(slidePanel == null) return;
        if(model == null || model.getParent() == null) {
            slidePanel.removeAll();
            return;
        }

        List<RuNode> tmpSlideList = model.getChildren();
        List<Slide> slideList = new ArrayList<>();
        if(tmpSlideList != null) {
            for (RuNode r : tmpSlideList)
                slideList.add((Slide) r);
        }

        for (int i = 0; i < slidePanel.getComponentCount(); i++) {
            Slide s = ((SlideView) slidePanel.getComponent(i)).getModel();
            if (!slideList.contains(s))
            {slidePanel.remove(i);
            i--;}
        }

        List<Slide> onScreenList = new ArrayList<>();
        for (int i = 0; i < slidePanel.getComponentCount(); i++) {
            onScreenList.add(((SlideView) slidePanel.getComponent(i)).getModel());
        }
        for (Slide s : slideList)
            if (!onScreenList.contains(s))
                slidePanel.add(new SlideView(s, v));

        for (int i = 0; i < slidePanel.getComponentCount(); i++)
            ((SlideView) slidePanel.getComponent(i)).update(new Object());

        validate();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public Presentation getModel() {
        return model;
    }

    public void setModel(Presentation model) {
        if(this.model != null)
            this.model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        update(new Object());
    }

    public JPanel getSlidePanel() {
        return slidePanel;
    }

    public void setSlidePanel(JPanel slidePanel) {
        this.slidePanel = slidePanel;
    }
}
