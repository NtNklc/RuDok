package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.action.popup.SharePresentationPopup;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SharePresentationAction extends AbstractRudokAction{

    public SharePresentationAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/share (1).png"));
        putValue(NAME, "Share presentation");
        putValue(SHORT_DESCRIPTION, "Share a presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getTree().selectedNode();
        if(treeNode == null || treeNode.getNode() == null || !(treeNode.getNode() instanceof Presentation)) {
            ErrorFactory.getInstance().makeError(ErrorEnum.NOT_PRESENTATION);
            return;
        }
        SharePresentationPopup popup = new SharePresentationPopup((Presentation) treeNode.getNode());
        popup.setVisible(true);
    }
}

