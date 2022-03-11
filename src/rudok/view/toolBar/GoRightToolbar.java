package rudok.view.toolBar;

import rudok.view.MainFrame;

import javax.swing.*;

public class GoRightToolbar extends JToolBar {
    public GoRightToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        add (MainFrame.getMainFrame().getActionManager().getPreviousSlideAction());
    }
}
