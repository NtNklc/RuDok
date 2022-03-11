package rudok.model.workspace;

import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.observer.ISubscriber;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project extends RuNodeComposite implements ISubscriber, Serializable {

    private transient boolean changed = true;
    private File projectFile;
    private List<Presentation> sharedPresentations = new ArrayList<>();

    public Project(String name, RuNode parent){
        this.setName(name);
        if(parent instanceof  Workspace) this.setParent((RuNodeComposite) parent);
    }

    @Override
    public void setChildren(List<RuNode> children) {
        if (children == null)return;
        for(RuNode child: children){
            if(!(child instanceof Presentation))return;
            super.setChildren(children);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Presentation))return;
        super.removeChild(child);
        child.removeSubscriber(this);
    }

    @Override
    public List<RuNode> getChildren() {
        List<RuNode> children2 = new ArrayList<>(super.getChildren());
        for(int i = 0; i < sharedPresentations.size(); i++)
            if(!sharedPresentations.get(i).isDelted())
                children2.add(sharedPresentations.get(i));
        return children2;
    }

    @Override
    public String getChildClassType() {
        return "Presentation";
    }

    @Override
    public void update(Object notification) {
        this.notifySubscribers(new Object());
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = true;
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public List<Presentation> getSharedpresentations() {
        return sharedPresentations;
    }

    public void setSharedpresentations(List<Presentation> sharedpresentations) {
        sharedPresentations = sharedpresentations;
    }
}
