package rudok.action;

import rudok.model.workspace.Project;
import rudok.model.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveWorkspaceAction extends AbstractRudokAction{

    public SaveWorkspaceAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/diskette.png"));
        putValue(NAME, "Save workspace");
        putValue(SHORT_DESCRIPTION, "Save workspace");
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();
        Workspace ws = ((Workspace) MainFrame.getMainFrame().getModel().getRoot().getNode());

        File workspaceFile = ws.getWorkspaceFile();
        if (ws.getWorkspaceFile()==null){
            if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION)
            {
                workspaceFile=jfc.getSelectedFile();
                try {
                    workspaceFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else return;
        }
        try {
            FileWriter myWriter = new FileWriter(workspaceFile);
            List<Project> projects = MainFrame.getMainFrame().getTree().getProjects();
            for(int i = 0; i < projects.size(); i++) {
                Project p = projects.get(i);
                saveProject(p, workspaceFile.getParentFile());
                String s = p.getProjectFile().getAbsolutePath();
                if(i < projects.size() - 1)
                    s += '\n';
                myWriter.write(s);
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


