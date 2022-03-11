package rudok.controller;

import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

    public WorkspaceTreeCellRenderer() {

        // TODO Auto-generated constructor stub
    }

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if(value instanceof MyTreeNode) {
            MyTreeNode n = (MyTreeNode) value;
            if (n.getNode() instanceof Workspace) {
                URL imageURL = getClass().getResource("../../actions/images/infoPic.png");
                Icon icon = null;

                if (imageURL == null) {
                    icon = new ImageIcon();
                }
                setIcon(icon);
            }
        }
        return this;
    }

}
