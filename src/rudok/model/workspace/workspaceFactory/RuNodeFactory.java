package rudok.model.workspace.workspaceFactory;

import rudok.model.logicTree.RuNode;

public abstract class RuNodeFactory {
    public RuNode returnNode(RuNode parent) {return makeNode(parent); }
    abstract RuNode makeNode(RuNode parent);
}
