package rudok.commandd;

import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Slide;
import rudok.model.workspace.workspaceFactory.RuNodeFactory;
import rudok.model.workspace.workspaceFactory.SimpleFactory;
import rudok.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class NewNodeCommand implements AbstractCommand{

    private MyTreeNode parent;
    private MyTreeNode newNode;
    private List<MyTreeNode> parents;
    private List<MyTreeNode> newNodes;

    public NewNodeCommand(MyTreeNode parent) {
        this.parent = parent;
        parents = new ArrayList<>();
        newNodes = new ArrayList<>();
    }

    @Override
    public void doCommand() {
        if(newNode == null) {
            RuNodeFactory fabrika = SimpleFactory.getfactory(parent.getNode());
            RuNode noviCvor = fabrika.returnNode(parent.getNode());
            ((RuNodeComposite)parent.getNode()).addChild(noviCvor);
            newNode = new MyTreeNode(noviCvor);
        }
        else{
            newNode.getNode().setParent((RuNodeComposite) parent.getNode());
            ((RuNodeComposite) parent.getNode()).addChild(newNode.getNode());
        }
        if(newNode.getNode() instanceof Slide) {
            if(parents.size()==0) {
                MyTreeNode workspace = (MainFrame.getMainFrame().getModel().getRoot());
                List<MyTreeNode> presentations = workspace.findAll( parent.getNode());
                for (MyTreeNode p : presentations) {
                    parents.add(p);
                    newNodes.add(new MyTreeNode(newNode.getNode()));
                }
            }
            for(int i=0;i<parents.size();i++)
                parents.get(i).add(newNodes.get(i));
        }
        else parent.add(newNode);
        MainFrame.getMainFrame().getTree().update();
    }

    @Override
    public void undoCommand() {
        newNode.getNode().getParent().removeChild(newNode.getNode());
        if(newNode.getNode() instanceof Slide){
            for(int i=0;i<newNodes.size();i++)
                parents.get(i).remove(newNodes.get(i));
        }
        else parent.remove(newNode);
        MainFrame.getMainFrame().getTree().update();
    }
}
