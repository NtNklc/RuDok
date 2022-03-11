package rudok.commandd;

import rudok.model.logicTree.RuNode;


public class RenameNodeCommand implements AbstractCommand{

    private RuNode ruNode;
    private String newName;
    private String oldName;


    public RenameNodeCommand(RuNode ruNode, String newName) {
        this.ruNode = ruNode;
        this.newName = newName;
    }

    @Override
    public void doCommand() {
        this.oldName = this.ruNode.getName();
        this.ruNode.setName(newName);
    }

    @Override
    public void undoCommand() {
        this.ruNode.setName(oldName);
    }
}
