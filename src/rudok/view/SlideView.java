package rudok.view;

import rudok.action.mouseEvents.SlideSelectedListener;
import rudok.model.Slot;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Slide;
import rudok.observer.ISubscriber;
import rudok.slot.DrawEditSlot;
import rudok.slot.IDrawSlot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlideView extends JPanel implements ISubscriber {
    private JLabel slideNum;
    private Slide model;
    private JPanel panel;
    private double width;
    private double height;
    private PresentationView presentationView;
    private  SlotView currentSlot = null;
    private List<SlotView> slotViewList;
    private IDrawSlot drawSlot;


    public SlideView(Slide s, ViewType v) {
        setLayout(new BorderLayout());
        if(v == ViewType.LEFT) {
            width = 50; height = 50/1.5;
            drawSlot = new DrawEditSlot();
        }
        if(v == ViewType.RIGHT) {
            width = 250; height = 250/1.5;
            drawSlot = new DrawEditSlot();
        }
        if(v == ViewType.SLIDESHOW) {width = 300; height = 300/1.5;}
        setPreferredSize(new Dimension((int)width,(int)height));
        setMaximumSize(new Dimension((int)width,(int)height));

        slotViewList = new ArrayList<>();

        setBackground(Color.LIGHT_GRAY);
        slideNum = new JLabel();
        slideNum.setSize(new Dimension(50,50));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black,2));
        add(slideNum, BorderLayout.NORTH);

        setModel(s);

        SlideSelectedListener listener = new SlideSelectedListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String url = ((Presentation)model.getParent()).getBackground();
        BufferedImage img = null;
        try {
            System.out.println(url);
            img = ImageIO.read(new File(url));
        } catch (IOException e) { }
        g.drawImage(img,0,0,(int)getWidth(),(int)getHeight(),null);

        for(SlotView slotView: slotViewList)
            slotView.showSlot((Graphics2D) g);
    }

    @Override
    public void update(Object notification) {
        if (model != null)
            slideNum.setText(String.valueOf(model.getNum()));

        List<Slot> slotList = model.getChildren();
        for(int i = 0; i < slotViewList.size(); i++){
            SlotView s = slotViewList.get(i);
            if(!slotList.contains(s.getModel())){
                slotViewList.remove(s);
                i--;
            }
        }

        List<Slot> onScreenSlots = new ArrayList<>();
        for(SlotView s: slotViewList)
            onScreenSlots.add(s.getModel());
        for(int i = 0; i < slotList.size(); i++){
            if(!onScreenSlots. contains(slotList.get(i)))
                slotViewList.add(new SlotView(slotList.get(i),this, drawSlot));
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public Slide getModel() {
        return model;
    }

    public void setModel(Slide model) {
        if (this.model != null)
            model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());

    }

    public JLabel getSlideNum() {
        return slideNum;
    }

    public void setSlideNum(JLabel slideNum) {
        this.slideNum = slideNum;
    }

    public PresentationView getPresentationView() {
        return presentationView;
    }

    public void setPresentationView(PresentationView presentationView) {
        this.presentationView = presentationView;
    }

    public SlotView getCurrentSlot() {
        return currentSlot;
    }

    public void setCurrentSlot(SlotView currentSlot) {
        System.out.println("set slot");
        this.currentSlot = currentSlot;
    }

    public List<SlotView> getSlotViewList() {
        return slotViewList;
    }

    public void setSlotViewList(List<SlotView> slotViewList) {
        this.slotViewList = slotViewList;
    }

}