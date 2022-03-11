package rudok.commandd;


import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.view.MainFrame;

public class ShareNodeCommand implements AbstractCommand{

    private Presentation presentation;
    private Project project;
    private MyTreeNode parentNode;
    private MyTreeNode newNode;

    public ShareNodeCommand(Presentation presentation, Project project) {
        this.presentation = presentation;
        this.project = project;
    }

    @Override
    public void doCommand() {
        MyTreeNode workspace=(MainFrame.getMainFrame().getModel().getRoot());
        for(int i=0;i<workspace.getChildCount();i++) {
            MyTreeNode project = ((MyTreeNode) workspace.getChildAt(i));
            if (project.getNode() == this.project) {
                parentNode = project;
                this.project.getSharedpresentations().add(presentation);
                workspace.napraviMyTreeNodeDecu();
            }
        }
    }

    @Override
    public void undoCommand() {
        project.getSharedpresentations().remove(presentation);
    }
}
