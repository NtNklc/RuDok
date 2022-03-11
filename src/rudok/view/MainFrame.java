package rudok.view;

import rudok.action.ActionManager;
import rudok.action.error.ErrorClass;
import rudok.action.error.ErrorFactory;
import rudok.action.error.ErrorPopup;
import rudok.action.popup.SharePresentationPopup;
import rudok.action.popup.WorkspacePopup;
import rudok.commandd.CommandManager;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeModel;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Workspace;
import rudok.observer.ISubscriber;
import rudok.view.toolBar.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame implements ISubscriber {

    public static MainFrame mainFrame = null;

    private Menu menu;
    private ToolBar toolbar;
    private ActionManager actionManager;
    private ProjectView projectView;

    private CommandManager commandManager;
    private SharePresentationPopup sharePresentationPopup;


    private MyTreeModel model;
    private MyTree tree;
    private File workspaceFile;

    private MainFrame(){ }

    private void init(){
        actionManager = new ActionManager();
        commandManager = new CommandManager();
        tree = new MyTree();

        workspaceFile = null;

        WorkspacePopup popup = new WorkspacePopup();
        popup.setVisible(true);

        if(workspaceFile == null)
            model = new MyTreeModel(new MyTreeNode(new Workspace("Workspace")));
        else
            model = new MyTreeModel(new MyTreeNode(new Workspace("Workspace")), workspaceFile);

        tree.setModel(model);
        projectView = new ProjectView();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth/2, screenHeight/2);
        this.setDefaultCloseOperation(3);

        this.menu = new Menu();
        this.setJMenuBar(this.menu);
        this.toolbar = new ToolBar();
        this.add(this.toolbar, "North");

        JScrollPane scroll = new JScrollPane(tree);
        scroll.setMinimumSize(new Dimension(150,150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, projectView);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(200);
        split.setOneTouchExpandable(true);

        ErrorFactory.getInstance().addSubscriber(this);
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
            mainFrame.init();
        }
        return mainFrame;
    }

    public static void setMainFrame(MainFrame mainFrame) {
        MainFrame.mainFrame = mainFrame;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ToolBar getToolbar() {
        return toolbar;
    }

    public void setToolbar(ToolBar toolbar) {
        this.toolbar = toolbar;
    }

    public MyTreeModel getModel() {
        return model;
    }

    public void setModel(MyTreeModel model) {
        this.model = model;
    }

    public MyTree getTree() {
        return tree;
    }

    public void setTree(MyTree tree) {
        this.tree = tree;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public void setProjectView(ProjectView projectView) {
        this.projectView = projectView;
    }

    @Override
    public void update(Object notification) {
        ErrorPopup dialog = new ErrorPopup((ErrorClass)notification);
        dialog.setVisible(true);
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public SharePresentationPopup getSharePresentationDialog() {
        return sharePresentationPopup;
    }

    public void setSharePresentationDialog(SharePresentationPopup sharePresentationPopup) {
        this.sharePresentationPopup = sharePresentationPopup;
    }
}
