package rudok.slotState;

import rudok.model.workspace.Slide;
import rudok.view.SlideView;
import rudok.view.SlotView;

import java.util.List;

public class RemoveState implements SlotState{
    @Override
    public void editSlot(int x, int y, SlideView slideView) {
        List<SlotView> slotViewList = slideView.getSlotViewList();
        Slide slide = slideView.getModel();
        //idemo od kraja da bi brisali sa vrha loodo
        for(int i = slotViewList.size()-1; i >=0; i--){
            if(slotViewList.get(i).isInside(x, y)){
                slide.removeChild(slotViewList.get(i).getModel());
                return;
            }
        }
        System.out.println("Remove slot");
    }
}
