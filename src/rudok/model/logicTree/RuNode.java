package rudok.model.logicTree;

import rudok.observer.APublisher;

import java.io.Serializable;

public abstract class RuNode extends APublisher implements Serializable {

    private String name;
    private RuNodeComposite parent;
    private boolean delted = false;
    public RuNode() {
    }

    public RuNodeComposite getParent() {
        return parent;
    }

    public void setParent(RuNodeComposite parent) {
        this.parent = parent;
        this.notifySubscribers(new Object());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notifySubscribers(new Object());
    }

    public void setPresentationName(String name, Object message){
        this.name = name;
        this.notifySubscribers(message);
    }
    public void delete() {
        this.getParent().removeChild(this);
        setParent(null);
        this.delted= true;
//        notifySubscribers(this);
    }

    public boolean isDelted() {
        return delted;
    }

    public void setDelted(boolean delted) {
        this.delted = delted;
    }
}
