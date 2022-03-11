package rudok.view;

import rudok.PresentationState.PresentationStateManager;
import rudok.model.workspace.Presentation;
import rudok.observer.ISubscriber;
import rudok.slotState.SlotStateManager;
import rudok.view.toolBar.PresentationToolbar;
import rudok.view.toolBar.StrokeEnum;

import javax.swing.*;
import java.awt.*;

public class PresentationView extends APresentationView implements ISubscriber {
    private JLabel lbl;
    private JPanel presentationViewPanel;
    private JLabel lblAuthor;
   // private JPanel rightPanel;
    private JSplitPane split;
    private MiniPresentationView miniPresentationView;
    private JPanel editPanel;
    private PresentationStateManager presentationStateManager;
    private PresentationToolbar presentationToolbar;
    private SlideShowView slideShowView;
    private SlotStateManager slotStateManager;

    public PresentationView(Presentation presentation){
        presentationStateManager = new PresentationStateManager();
        lbl = new JLabel("Name");
        lblAuthor = new JLabel("Unknown Author");
        miniPresentationView = new MiniPresentationView();
        split = new JSplitPane();
        presentationViewPanel = new JPanel();
        editPanel = new JPanel(new BorderLayout());
        presentationToolbar = new PresentationToolbar();
        slideShowView = new SlideShowView();
        slotStateManager = new SlotStateManager();
        //levi panel je miniPresentationVIew - vec JPanel

        setLayout(new BorderLayout());

        //panel za toolbar i autora
        JPanel pvpTopPanel = new JPanel();
        pvpTopPanel.setLayout(new BorderLayout());
        pvpTopPanel.add(lblAuthor, BorderLayout.NORTH);
        pvpTopPanel.add(presentationToolbar, BorderLayout.CENTER);
        presentationViewPanel.setLayout(new BoxLayout(presentationViewPanel, BoxLayout.Y_AXIS));
        editPanel.add(pvpTopPanel, BorderLayout.NORTH);
        editPanel.add(presentationViewPanel, BorderLayout.CENTER);

        JScrollPane leftView = new JScrollPane(miniPresentationView);
        leftView.setMinimumSize(new Dimension(70,this.getHeight()));
        JScrollPane rightView = new JScrollPane(editPanel);
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftView, rightView);

        setBackground(Color.DARK_GRAY);


        setSlidePanel(presentationViewPanel);
        setModel(presentation);
        add(split);
    }

    @Override
    public void update(Object notification) {
        System.out.println("Usao u prez update");
        if(getModel() !=null)
            lblAuthor.setText(getModel().getAuthor());
        updatePresentation(ViewType.RIGHT);
        for(int i = 0; i < presentationViewPanel.getComponentCount(); i++)
            ((SlideView)presentationViewPanel.getComponent(i)).setPresentationView(this);
    }


    public void setModel(Presentation model) {
        super.setModel(model);
        miniPresentationView.setModel(model);
        slideShowView.setModel(model);
    }

    public void startSlideShowState(){
        this.presentationStateManager.setSlideShowState();
        this.presentationStateManager.show(this);
    }

    public void startEditState(){
        this.presentationStateManager.setEditState();
        this.presentationStateManager.show(this);
    }

    public void startSlotState(int x, int y, SlideView slideView){
        this.slotStateManager.getCurrentSlotState().editSlot(x, y, slideView);
    }

    public void startDragAndDropState(){this.slotStateManager.setDragAndDropState();}
    public void startImageSlotState(){this.slotStateManager.setImageSlotState();}
    public void startRemoveState(){this.slotStateManager.setRemoveState();}
    public void startTextSlotState(){this.slotStateManager.setTextSlotState();}
    public void setSlotColor(Color c){this.slotStateManager.setColour(c);}
    public void setStroke(StrokeEnum e){this.slotStateManager.setStroke(e);}
    public void startEditSlotState() {this.slotStateManager.setEditSlotState();}


    public SlideShowView getSlideShowView() {
        return slideShowView;
    }

    public void setSlideShowView(SlideShowView slideShowView) {
        this.slideShowView = slideShowView;
    }

    public JPanel getPresentationViewPanel() {
        return presentationViewPanel;
    }

    public JSplitPane getSplit() {
        return split;
    }

    public void setSplit(JSplitPane split) {
        this.split = split;
    }

    public void setPresentationViewPanel(JPanel presentationViewPanel) {
        this.presentationViewPanel = presentationViewPanel;
    }


}

