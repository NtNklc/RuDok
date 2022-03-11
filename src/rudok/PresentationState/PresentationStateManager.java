package rudok.PresentationState;

import rudok.view.PresentationView;

public class PresentationStateManager {

    private PresentationState currentPresentationState;
    private EditPresentationState editState;
    private SlideShowPresentationState slideShowState;

    public PresentationStateManager() {
        initStates();
    }

    private void initStates() {
        editState = new EditPresentationState();
        slideShowState = new SlideShowPresentationState();
        currentPresentationState = editState;
    }


    public PresentationState getCurrentState() {
        return currentPresentationState;
    }

    public void show(PresentationView p) {
        currentPresentationState.show(p);
    }

    public void setEditState() {
        this.currentPresentationState = editState;
    }

    public void setSlideShowState() {
        this.currentPresentationState = slideShowState;
    }
}
