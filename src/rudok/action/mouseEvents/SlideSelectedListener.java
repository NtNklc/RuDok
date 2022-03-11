package rudok.action.mouseEvents;

import rudok.view.PresentationView;
import rudok.view.SlideView;
import rudok.view.SlotView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SlideSelectedListener implements MouseListener, MouseMotionListener {
    private SlideView slideView;
    public SlideSelectedListener(SlideView slideView) {this.slideView = slideView;}

    @Override
    public void mousePressed(MouseEvent e) {
        PresentationView presentationView = slideView.getPresentationView();
        if(presentationView == null) return; //dodaj error kasnije
        for(SlotView slotView: slideView.getSlotViewList()){
            if(slotView.isInside(e.getX(), e.getY()))
                slideView.setCurrentSlot(slotView);
        }
        presentationView.startSlotState(e.getX(), e.getY(), slideView);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Drag");
        PresentationView presentationView = slideView.getPresentationView();
        if(presentationView == null) return;
        presentationView.startSlotState(e.getX(), e.getY(), slideView);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        slideView.setCurrentSlot(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
