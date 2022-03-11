package rudok.action.mouseEvents;

import rudok.model.GraphicTree.MyTree;
import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTree implements MouseListener {

    MyTree tree;
    public MouseEventTree(MyTree tree) {
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(tree.selectedNode() == null) return;
        RuNode node = tree.selectedNode().getNode();
        if(node instanceof Project && MainFrame.getMainFrame().getSharePresentationDialog() != null)
            MainFrame.getMainFrame().getSharePresentationDialog().setProject((Project) node);
        if(e.getClickCount() == 2) {
            tree.openComponent();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
