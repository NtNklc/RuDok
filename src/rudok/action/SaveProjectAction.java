package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

import javax.lang.model.type.ErrorType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRudokAction{


    public SaveProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/download.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getTree().selectedNode();
        if(treeNode == null || treeNode.getNode() == null) {
            return;
        }
        if(!(treeNode.getNode() instanceof Project)) {
            return;
        }
        saveProject((Project) treeNode.getNode(),null);
    }

}
