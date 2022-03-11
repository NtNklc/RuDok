package rudok.slotState;

import rudok.view.toolBar.StrokeEnum;

import java.awt.*;

public class SlotStateManager {
    private SlotState currentSlotState;
    private DragAndDropState dragAndDropState;
    private RemoveState removeState;
    private ImageState imageSlotState;
    private TextState textSlotState;
    private EditSlotState editSlotState;

    public SlotStateManager() {
        dragAndDropState = new DragAndDropState();
        currentSlotState = dragAndDropState;
        removeState = new RemoveState();
        imageSlotState = new ImageState();
        textSlotState = new TextState();
        editSlotState = new EditSlotState();
    }

    public void  setColour(Color colour){
        textSlotState.setColour(colour);
        imageSlotState.setColour(colour);
    }

    public void setStroke(StrokeEnum e){
        textSlotState.selectStroke(e);
        imageSlotState.selectStroke(e);
    }

    public SlotState getCurrentSlotState() {
        return currentSlotState;
    }

    public void setCurrentSlotState(SlotState currentSlotState) {
        this.currentSlotState = currentSlotState;
    }

    public DragAndDropState getDragAndDropState() {
        return dragAndDropState;
    }

    public void setDragAndDropState() {
        this.currentSlotState = dragAndDropState;
    }

    public RemoveState getRemoveState() {
        return removeState;
    }

    public void setRemoveState() {
        this.currentSlotState = removeState;
    }

    public AddState getImageSlotState() {
        return imageSlotState;
    }

    public void setImageSlotState() {
        this.currentSlotState = imageSlotState;
    }

    public AddState getTextSlotState() {
        return textSlotState;
    }

    public void setTextSlotState() {
        this.currentSlotState = textSlotState;
    }

    public void setEditSlotState(){currentSlotState = editSlotState;}
}
