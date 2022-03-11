package rudok.model.workspace.workspaceFactory;

import rudok.model.Slot;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Slide;

public class SlideFactory extends RuNodeFactory{
    @Override
    RuNode makeNode(RuNode parent) {
        return new Slide(((RuNodeComposite)parent).getNextChildIndex(), parent);
    }
}
