package rudok.commandd;


import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeCommand implements AbstractCommand{

    private MyTreeNode node;
    private RuNodeComposite parent;
    private int index;
    private List<MyTreeNode> parents;
    private List<MyTreeNode> nodes;
    private List<Integer> indexes;

    public DeleteNodeCommand(MyTreeNode node) {
        this.node = node;
        parents = new ArrayList<>();
        nodes = new ArrayList<>();
        indexes = new ArrayList<>();
    }

    @Override
    public void doCommand() {
        parent = node.getNode().getParent();
        index = parent.getChildren().indexOf(node.getNode());

        MyTreeNode workspace = MainFrame.getMainFrame().getModel().getRoot();

        if(parents.size()==0){
            parents = workspace.findAll(parent);
            for(MyTreeNode p:parents){
                for(int i=0;i<p.getChildCount();i++)
                    if(((MyTreeNode)p.getChildAt(i)).getNode() == node.getNode())
                        nodes.add((MyTreeNode)p.getChildAt(i));
            }
        }

        List<MyTreeNode> presentations = workspace.findAll(node.getNode());
        for(MyTreeNode p:presentations){
            if(!parents.contains((MyTreeNode) p.getParent())){
                parents.add((MyTreeNode) p.getParent());
                nodes.add(p);
            }
        }

        for(int i=0;i<parents.size();i++)
            parents.get(i).remove(nodes.get(i));

        node.getNode().delete();
    }

    @Override
    public void undoCommand() {
        node.getNode().setDelted(false);
        node.getNode().setParent(parent);
        parent.addChild(node.getNode(), index);
    }
}
