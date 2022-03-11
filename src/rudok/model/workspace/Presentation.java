package rudok.model.workspace;

import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.view.MainFrame;

import java.io.Serializable;
import java.util.List;

public class Presentation extends RuNodeComposite implements Serializable {

    private String author;
    private String background = "";

    public Presentation(String name, RuNode parent){
        this.setName(name);
        this.author = "Unknown author";
        if(parent instanceof Project) this.setParent((RuNodeComposite) parent);
    }

    public Presentation(String name, RuNode parent, String author) {
        this.setName(name);
        this.author = author;
        if(parent instanceof Project) this.setParent((RuNodeComposite) parent);
    }

    public void addChild(RuNode child) {
        if(!(child instanceof Slide))return;
        super.addChild(child);
    }

    @Override
    public void setChildren(List<RuNode> children) {
        if (children == null)return;
        for(RuNode child: children){
            if(!(child instanceof Slide))return;
            super.addChild(child);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Slide))return;
        super.removeChild(child);
    }

    @Override
    public String getChildClassType() {
        return "Slide";
    }

    @Override
    public void setName(String name) {
        setPresentationName(name, this);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscribers(new Object());
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
        notifySubscribers(new Object());
    }

}
