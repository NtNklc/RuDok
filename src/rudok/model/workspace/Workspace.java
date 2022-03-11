package rudok.model.workspace;

import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Workspace extends RuNodeComposite implements Serializable {
    private File workspaceFile;

    public Workspace(String name) {
        setName(name);
        workspaceFile = null;
    }

    @Override
    public void addChild(RuNode child) {
        if(!(child instanceof Project))return;
        super.addChild(child);
    }

    @Override
    public void setChildren(List<RuNode> children) {
        if (children == null)return;
        for(RuNode child: children){
            if(!(child instanceof Project))return;
            super.addChild(child);
        }
    }

    @Override
    public RuNodeComposite getParent() {
        return null;
    }

    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Project))return;
        super.removeChild(child);
    }

    @Override
    public String getChildClassType() {
        return "Project";
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }
}
