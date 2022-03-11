package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.action.popup.AuthorPopup;
import rudok.action.popup.BackgroundPupup;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Slide;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ChangeBackgroundAction extends AbstractRudokAction{

    public ChangeBackgroundAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/changeBackground.png"));
        putValue(NAME, "Change Background");
        putValue(SHORT_DESCRIPTION, "Change Background");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getTree().selectedNode();
        if(treeNode == null || !(treeNode.getNode() instanceof Presentation)) {
            ErrorFactory.getInstance().makeError(ErrorEnum.BACKGROUND_NOT_PRESENTATION);
            return;
        }
        BackgroundPupup popup = new BackgroundPupup((Presentation) (treeNode.getNode()));
        popup.setVisible(true);
    }
}
