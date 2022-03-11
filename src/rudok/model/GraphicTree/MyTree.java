package rudok.model.GraphicTree;

import rudok.action.mouseEvents.MouseEventTree;
import rudok.controller.Controller;
import rudok.controller.WorkspaceTreeCellRenderer;
import rudok.controller.WorkspaceTreeEditor;
import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.util.List;

public class MyTree extends JTree {
    public MyTree(){
        addTreeSelectionListener(new Controller());
        setCellEditor(new WorkspaceTreeEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRenderer());
        setEditable(true);
        addMouseListener(new MouseEventTree(this));
    }

    public void update(){
        SwingUtilities.updateComponentTreeUI(this);
    }

    public MyTreeNode selectedNode() {
        Object obj = this.getLastSelectedPathComponent();
        if((obj != null) && obj instanceof MyTreeNode) return (MyTreeNode)obj;
        return null;
    }

    public void openComponent() {
        MyTreeNode currentNode = selectedNode();
        if(currentNode == null) return;
        RuNode node = ((MyTreeNode)this.getLastSelectedPathComponent()).getNode();
        if(node instanceof Project)
            MainFrame.getMainFrame().getProjectView().setModel((Project)node);

    }
    public void addProject(Project project){

        ((MyTreeModel)getModel()).addProject(project);
    }

    public List<Project> getProjects() {
        return ((MyTreeModel)getModel()).getProjects();
    }

}
