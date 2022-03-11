package rudok.action;

import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractRudokAction{

    public UndoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/icons8-undo-24.png"));
        putValue(NAME, "undo");
        putValue(SHORT_DESCRIPTION, "Undo action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getMainFrame().getCommandManager().undoCommand();

    }
}
