package rudok.action;

import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractRudokAction{

    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/icons8-redo-24B.png"));
        putValue(NAME, "undo");
        putValue(SHORT_DESCRIPTION, "Undo action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getMainFrame().getCommandManager().doCommand();
    }
}
