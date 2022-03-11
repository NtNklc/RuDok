package rudok.controller;

import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class Controller implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        for(int i=0; i<path.getPathCount(); i++){
                MyTreeNode p = (MyTreeNode) path.getPathComponent(i);
                if(p == null) break;
        }
    }
}
