package rudok.action;

import rudok.action.popup.AuthorPopup;
import rudok.action.popup.InfoPopUP;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class InfoAction extends AbstractRudokAction {

    public InfoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/infoButton.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoPopUP dialog = new InfoPopUP();
        dialog.setVisible(true);

    }
}
