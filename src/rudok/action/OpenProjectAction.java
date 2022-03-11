package rudok.action;

import rudok.model.workspace.Project;
import rudok.model.workspace.workspaceFactory.SlideFactory;
import rudok.view.MainFrame;
import rudok.view.SlideView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRudokAction {



    public OpenProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();
//        jfc.setFileFilter(new ProjectFileFilter());

        if(jfc.showOpenDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project p=null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                MainFrame.getMainFrame().getTree().addProject(p);
                MainFrame.getMainFrame().getProjectView().setModel(p);
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }
}
