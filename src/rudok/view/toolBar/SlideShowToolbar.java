package rudok.view.toolBar;

import rudok.view.MainFrame;

import javax.swing.*;

public class SlideShowToolbar extends JToolBar {

    public SlideShowToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        add (MainFrame.getMainFrame().getActionManager().getGoToEditStaateAction());
    }
}
