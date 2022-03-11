package rudok.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
        public Menu(){
            JMenu fileMenu = new JMenu("File");
            JMenu fileEdit = new JMenu("Edit");
            fileMenu.setMnemonic(KeyEvent.VK_F);
            fileMenu.add(MainFrame.getMainFrame().getActionManager().getNewProjectAction());
            fileMenu.add(MainFrame.getMainFrame().getActionManager().getInfoAction());
            fileMenu.add(MainFrame.getMainFrame().getActionManager().getExitAction());
            fileEdit.add(MainFrame.getMainFrame().getActionManager().getChangeAuthorNameAction());
            fileEdit.add(MainFrame.getMainFrame().getActionManager().getChangeAuthorPictureAction());
            this.add(fileMenu);
            this.add(fileEdit);
        }
}
