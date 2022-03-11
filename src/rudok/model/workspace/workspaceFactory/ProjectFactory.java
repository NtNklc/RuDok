package rudok.model.workspace.workspaceFactory;

import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Project;

public class ProjectFactory extends RuNodeFactory{
    @Override
    RuNode makeNode(RuNode parent) {
        return new Project("Project " + ((RuNodeComposite)parent).getNextChildIndex(), parent);
    }
}
