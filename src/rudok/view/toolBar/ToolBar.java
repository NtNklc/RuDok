package rudok.view.toolBar;

import rudok.view.MainFrame;

import javax.swing.*;

public class ToolBar extends JToolBar {

        public ToolBar(){
            super(HORIZONTAL);
            setFloatable(false);
            add (MainFrame.getMainFrame().getActionManager().getExitAction());
            add (MainFrame.getMainFrame().getActionManager().getOpenProjectAction());
            add (MainFrame.getMainFrame().getActionManager().getSaveProjectAction());
            add (MainFrame.getMainFrame().getActionManager().getSaveWorkspaceAction());
            add (MainFrame.getMainFrame().getActionManager().getNewProjectAction());
            add(MainFrame.getMainFrame().getActionManager().getUndoAction());
            add(MainFrame.getMainFrame().getActionManager().getRedoAction());
            add (MainFrame.getMainFrame().getActionManager().getInfoAction());
            add (MainFrame.getMainFrame().getActionManager().getChangeAuthorNameAction());
            add (MainFrame.getMainFrame().getActionManager().getChangeAuthorPictureAction());
            add (MainFrame.getMainFrame().getActionManager().getShowSharedDialogAction());
        }
}
