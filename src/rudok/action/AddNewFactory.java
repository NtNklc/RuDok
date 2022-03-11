package rudok.action;

import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.logicTree.RuNode;
import rudok.model.logicTree.RuNodeComposite;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.model.workspace.Slide;
import rudok.model.workspace.Workspace;

public class AddNewFactory {
    private RuNode ruNode;
    public  static RuNode getNewComponentType(MyTreeNode parent){
        RuNode p = parent.getNode();
        if(p instanceof RuNodeComposite) {
            String name = ((RuNodeComposite) p).getChildClassType() + " " + ((RuNodeComposite) p).getNextChildIndex();
            if (p instanceof Workspace) return new Project(name, p);
            if (p instanceof Project) return new Presentation(name, p);
            //if(p instanceof Presentation)
            return new Slide(((Presentation) p).getNextChildIndex(), p);
        }
        else
            return null;
    }
}
