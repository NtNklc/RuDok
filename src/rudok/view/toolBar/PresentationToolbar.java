package rudok.view.toolBar;

import rudok.view.MainFrame;

import javax.swing.*;

public class PresentationToolbar extends JToolBar {

    public  PresentationToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        add (MainFrame.getMainFrame().getActionManager().getGoToSlideShowStateAction());
        add (MainFrame.getMainFrame().getActionManager().getDragAndDropAction());
        add (MainFrame.getMainFrame().getActionManager().getRemoveSlotAction());
        add (MainFrame.getMainFrame().getActionManager().getEditSlotAction());
        add (MainFrame.getMainFrame().getActionManager().getImageSlotAction());
        add (MainFrame.getMainFrame().getActionManager().getTextSlotAction());
        add (MainFrame.getMainFrame().getActionManager().getColorPickerAction());
        add (MainFrame.getMainFrame().getActionManager().getChooseStrokeAction());

    }

}
