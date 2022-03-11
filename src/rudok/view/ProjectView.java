package rudok.view;

import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectView extends JPanel implements ISubscriber {
    private Project model = null;
    private JLabel lblProjectName;
    private JTabbedPane jtpProject;
    private List<PresentationView> presentationViewList;



    public ProjectView(){
        lblProjectName = new JLabel();
        presentationViewList = new ArrayList<>();
        setLayout(new BorderLayout());
        this.add(lblProjectName, BorderLayout.NORTH);
        setBackground(Color.GRAY);
        jtpProject = new JTabbedPane();
        add(jtpProject, BorderLayout.CENTER);

    }

    @Override
    public void update(Object notification) {
        if (model == null || model.getParent() == null) {
            jtpProject.removeAll();
            lblProjectName.setText("No project selected");
            SwingUtilities.updateComponentTreeUI(this);
            return;
        }
        lblProjectName.setText(model.getName());

        List<Presentation> presentationList = new ArrayList<>();
        if (model.getChildren() != null){
            for (RuNode r : model.getChildren())
                presentationList.add((Presentation) r);
        }

        for(int i = 0; i < presentationViewList.size(); i++){
            PresentationView v = presentationViewList.get(i);
            Presentation tmpP = v.getModel();
            if(!presentationList.contains(tmpP)){
                presentationViewList.remove(v);
                i--;
                jtpProject.remove(v);
            }
        }

        List<Presentation> onScreenList = new ArrayList<>();
        for(PresentationView v : presentationViewList){
            onScreenList.add(v.getModel());
        }

        for (Presentation p : presentationList)
            if (!onScreenList.contains(p)) {
                PresentationView view = new PresentationView(p);
                presentationViewList.add(view);
                jtpProject.addTab(view.getModel().getName(), view);

            }

        for (int i = 0; i < jtpProject.getTabCount(); i++) {
            jtpProject.setTitleAt(i, findPresentation(i).getModel().getName());
        }
        validate();
    }

    public Project getModel() {
        return model;
    }

    public void setModel(Project model) {

        if(this.model != null)
            this.model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());
    }

    private PresentationView findPresentation(int i) {
        return (PresentationView)jtpProject.getComponentAt(i);
    }

    public JLabel getLblProjectName() {
        return lblProjectName;
    }

    public void setLblProjectName(JLabel lblProjectName) {
        this.lblProjectName = lblProjectName;
    }

    public JTabbedPane getJtpProject() {
        return jtpProject;
    }

    public void setJtpProject(JTabbedPane jtpProject) {
        this.jtpProject = jtpProject;
    }

    public List<PresentationView> getPresentationViewList() {
        return presentationViewList;
    }

    public void setPresentationViewList(List<PresentationView> presentationViewList) {
        this.presentationViewList = presentationViewList;
    }
}
