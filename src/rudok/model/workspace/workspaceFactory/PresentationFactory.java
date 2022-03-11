package rudok.model.workspace.workspaceFactory;

import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Presentation;

public class PresentationFactory extends RuNodeFactory{
    @Override
    RuNode makeNode(RuNode parent) {
        return new Presentation("Presentation " + ((RuNodeComposite)parent).getNextChildIndex(), parent);
    }
}
