package rudok.model.logicTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode implements Serializable {

    protected List <RuNode> children = new ArrayList<>();

    public RuNodeComposite() {

    }

    public RuNode getChildAt(int childIndex) {
        if(childIndex >= 0 && childIndex<this.children.size()) return null;
        return this.children.get(childIndex);
    }

    public int getChildCount() {
        if(children == null) return 0;
        return children.size();
    }

    public int getIndex(RuNode node) {
        return 0;
    }

    public boolean getAllowsChildren() {
        return false;
    }

    public boolean isLeaf() {
        return false;
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void  addChild(RuNode child){
        if (child == null) return;
        if(this.children == null) this.children = new ArrayList<>();
        if(this.children.contains(child))return;
        this.children.add(child);
        this.notifySubscribers(new Object());
    }
    public void addChild(RuNode child, int index){
        if(child == null) return;
        if(this.children == null) this.children = new ArrayList<>();
        if(this.children.contains(child)) return;
        this.children.add(index,child);
        this.notifySubscribers(new Object());
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
        notifySubscribers(new Object());
    }

    public int getNextChildIndex(){
        int max = 0;
        if(children == null) return 1;
        for(RuNode c : children) {
            String type = this.getChildClassType();
            String tmpName = c.getName().replace(type + " ", "");
            try {
                int i = Integer.parseInt(tmpName);
                if (i > max) max = i;
            } catch (NumberFormatException nfe) {}

        }
        return max+1;
    }

    public void removeChild(RuNode child){
        if(child == null || this.children == null || this.children.isEmpty() || !this.children.contains(child)) return;
        child.setParent(null);
        this.children.remove(child);
        this.notifySubscribers(new Object());
    }

    public abstract String getChildClassType();

}
