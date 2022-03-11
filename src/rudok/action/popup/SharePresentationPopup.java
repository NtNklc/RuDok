package rudok.action.popup;

import rudok.commandd.ShareNodeCommand;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SharePresentationPopup extends JDialog {

    private Presentation presentation;
    private Project project;
    private JLabel lblProject;
    private JButton btnShare;

    public SharePresentationPopup(Presentation presentation) {
        super(MainFrame.getMainFrame(), false);
        setLocationRelativeTo(null);
        this.presentation = presentation;

        JPanel dialogPanel=new JPanel();
        GridLayout g = new GridLayout(3,1);
        g.setHgap(20);
        g.setVgap(20);
        dialogPanel.setLayout(g);

        JLabel lbl = new JLabel("   Select a project you want to share a presentation to");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogPanel.add(lbl);

        lblProject = new JLabel("No project selected");
        lblProject.setAlignmentX(Component.CENTER_ALIGNMENT);


        dialogPanel.add(lblProject);

        btnShare = new JButton("Share presentation");
        dialogPanel.add(btnShare);
        SharePresentationPopup self = this;


        btnShare.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().getCommandManager().addCommand(
                        new ShareNodeCommand(MainFrame.getMainFrame().getSharePresentationDialog().getPresentation(),
                                MainFrame.getMainFrame().getSharePresentationDialog().getProject()));
                self.setVisible(false);
            }
        });


        btnShare.setEnabled(false);
        btnShare.setText("Share presentation");

        this.add(dialogPanel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(350, 150);
        this.setVisible(true);

        MainFrame.getMainFrame().setSharePresentationDialog(this);
    }

    public void setProject(Project project) {
        this.project = project;
        this.lblProject.setText(project.getName());
        this.btnShare.setEnabled(true);
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public Project getProject() {
        return project;
    }
}