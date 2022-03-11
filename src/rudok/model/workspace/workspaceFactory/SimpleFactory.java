package rudok.model.workspace.workspaceFactory;

import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.model.workspace.Workspace;

public class SimpleFactory {

    public static RuNodeFactory getfactory(RuNode parent){
        if(parent instanceof Workspace)
            return new ProjectFactory();
        if(parent instanceof Project)
            return new PresentationFactory();
        if(parent instanceof Presentation)
            return new SlideFactory();
        return null;
    }
}
