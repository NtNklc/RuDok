package rudok.action;

import com.sun.tools.javac.Main;
import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.commandd.DeleteNodeCommand;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;

public class RemoveComponentAction extends rudok.action.AbstractRudokAction {
    public RemoveComponentAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Bin.png"));
        putValue(NAME, "Remove Component");
        putValue(SHORT_DESCRIPTION, "Remove Component");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTree tree = MainFrame.getMainFrame().getTree();
        Object obj = tree.getLastSelectedPathComponent();
        if (obj == null || ((MyTreeNode)obj).getNode() == null) {
            ErrorFactory.getInstance().makeError(ErrorEnum.NOTHING_SELECTED);
            return;
        }
        else {
            MyTreeNode treeNode = (MyTreeNode) obj;
            if (treeNode.getNode() instanceof Workspace){
                ErrorFactory.getInstance().makeError(ErrorEnum.DELETE_WORKSPACE);
                System.out.println("Usao u error");
                return;
            }
            MainFrame.getMainFrame().getCommandManager().addCommand(new DeleteNodeCommand(treeNode));
            tree.update();
            }
    }
}
