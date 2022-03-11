package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.action.popup.AuthorPopup;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ChangeAuthorAction extends AbstractRudokAction{

    public ChangeAuthorAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/changeName.png"));
        putValue(NAME, "Change Author");
        putValue(SHORT_DESCRIPTION, "Change Author");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTree tree = MainFrame.getMainFrame().getTree();
        Object obj = tree.getLastSelectedPathComponent();
        if (obj == null || ((MyTreeNode) obj).getNode() == null){
            ErrorFactory.getInstance().makeError(ErrorEnum.NOTHING_SELECTED);
            return;
        }
        else {
            MyTreeNode treeNode = (MyTreeNode) obj;
            if (treeNode.getNode() instanceof Presentation){
                    AuthorPopup p = new AuthorPopup((Presentation)treeNode.getNode());
                }
            else {
                ErrorFactory.getInstance().makeError(ErrorEnum.AUTHOR);
                return;
            }
        }
    }
}
