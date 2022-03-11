package rudok.model.workspace;

import rudok.model.Slot;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.observer.ISubscriber;
import rudok.slotState.SlotState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode implements ISubscriber, Serializable {
    private int num;
    private List<Slot> slotList;

    public Slide(int num, RuNode parent){
        this.num = num;
        if(parent instanceof Presentation) this.setParent((RuNodeComposite) parent);
        setName("Slide " + num);
        slotList = new ArrayList<>();
    }

    public void addChild(Slot child){
        slotList.add(child);
        child.addSubscriber(this);
        notifySubscribers(new Object());
    }

    public void removeChild(Slot child){
        if(!slotList.contains(child)) return;
        slotList.remove(child);
        child.removeSubscriber(this);
        notifySubscribers(new Object());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        notifySubscribers(new Object());
    }

    @Override
    public void update(Object notification) {
        notifySubscribers(new Object());
    }

    public List<Slot> getChildren(){return slotList;}
}
