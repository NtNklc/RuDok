package rudok.action;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;
import rudok.view.PresentationView;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction {

    public Icon loadIcon(String fileName){
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;
        if(imageURL != null)
            icon = new ImageIcon(imageURL);
        else System.err.println("Resource not found" + fileName);
        return icon;
    }

    public PresentationView getCurrentPresentation(){
        int index = MainFrame.getMainFrame().getProjectView().getJtpProject().getSelectedIndex();
        if(index >= 0){
            return MainFrame.getMainFrame().getProjectView().getPresentationViewList().get(index);
        }
        else{
            ErrorFactory.getInstance().makeError(ErrorEnum.NO_PRESENTATION_NO_STATE);
            return null;
        }
    }
    public void saveProject(Project project, File parentFile) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        File projectFile=project.getProjectFile();

        if (project.getProjectFile()==null){
            if(parentFile != null)
                projectFile = new File(parentFile.getAbsolutePath() + "/" + project.getName().replace(' ', '_') + ".gpf");
            else if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION) {
                projectFile=jfc.getSelectedFile();
            }
            else return;
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
