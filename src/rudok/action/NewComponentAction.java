package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.commandd.NewNodeCommand;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Slide;
import rudok.model.workspace.workspaceFactory.RuNodeFactory;
import rudok.model.workspace.workspaceFactory.SimpleFactory;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewComponentAction extends AbstractRudokAction {

    public NewComponentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/new-page.png"));
        putValue(NAME, "NewComponent");
        putValue(SHORT_DESCRIPTION, "New Component");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode treeNode = MainFrame.getMainFrame().getTree().selectedNode();
        if(treeNode == null || !(treeNode.getNode() instanceof RuNodeComposite)) {
            if(treeNode.getNode() instanceof Slide)
                ErrorFactory.getInstance().makeError(ErrorEnum.ADD_CHILDREN_TO_SLIDE);
            return;
        }
        MainFrame.getMainFrame().getCommandManager().addCommand(new NewNodeCommand(treeNode));
        MainFrame.getMainFrame().getTree().update();
        MainFrame.getMainFrame().getTree().expandPath(MainFrame.getMainFrame().getTree().getSelectionPath());
    }
}
