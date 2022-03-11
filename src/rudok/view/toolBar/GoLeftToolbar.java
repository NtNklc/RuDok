package rudok.view.toolBar;

import rudok.view.MainFrame;

import javax.swing.*;

public class GoLeftToolbar extends JToolBar {
    public GoLeftToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        add (MainFrame.getMainFrame().getActionManager().getNextSlideAction());
    }
}
