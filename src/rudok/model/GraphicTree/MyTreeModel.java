package rudok.model.GraphicTree;

import rudok.model.logicTree.RuNode;
import rudok.model.workspace.Project;
import rudok.model.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.tree.DefaultTreeModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTreeModel extends DefaultTreeModel {
    public MyTreeModel(MyTreeNode root) {
        super(root);
    }

    public MyTreeModel(MyTreeNode root, File f) {
        super(root);
        read(f);
    }

    public void addProject(Project project){
        ((Workspace)(getRoot().getNode())).addChild(project);
        getRoot().napraviMyTreeNodeDecu();
        MainFrame.getMainFrame().getTree().update();
    }

    public List<Project> getProjects() {
        List<RuNode> list = ((Workspace)(getRoot().getNode())).getChildren();
        List<Project> ret = new ArrayList<>();
        if(list == null) return ret;
        for(RuNode node: list)
            ret.add((Project) node);
        return ret;
    }

    @Override
    public MyTreeNode getRoot() {
        return (MyTreeNode) super.getRoot();
    }

    public void setRoot(MyTreeNode root) {
        this.root = root;
    }


    private void read(File f) {
        try {
            File myObj = f;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(new File(data)));
                Project p = null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                this.addProject(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}