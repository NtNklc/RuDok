package rudok.action;

public class ActionManager {
    private RemoveComponentAction removeComponentAction;
    private NewComponentAction newComponentAction;
    private InfoAction infoAction;
    private ChangeAuthorAction changeAuthorAction;
    private ChangeBackgroundAction changeBackgroundAction;
    private GoToSlideShowStateAction goToSlideShowStateAction;
    private GoToEditStateAction goToEditStateAction;
    private NextSlideAction nextSlideAction;
    private PreviousSlideAction previousSlideAction;
    private TextSlotAction textSlotAction;
    private RemoveSlotAction removeSlotAction;
    private ImageSlotAction imageSlotAction;
    private DragAndDropAction dragAndDropAction;
    private ColorPickerAction colorPickerAction;
    private ChooseStrokeAction chooseStrokeAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private OpenProjectAction openProjectAction;
    private SaveProjectAction saveProjectAction;
    private EditSlotAction editSlotAction;
    private SaveWorkspaceAction saveWorkspaceAction;
    private SharePresentationAction sharePresentationAction;


    public ActionManager(){initActions();}

    public void initActions(){
        removeComponentAction = new RemoveComponentAction();
        newComponentAction = new NewComponentAction();
        infoAction = new InfoAction();
        changeAuthorAction = new ChangeAuthorAction();
        changeBackgroundAction = new ChangeBackgroundAction();
        goToSlideShowStateAction = new GoToSlideShowStateAction();
        goToEditStateAction = new GoToEditStateAction();
        nextSlideAction = new NextSlideAction();
        previousSlideAction = new PreviousSlideAction();
        removeSlotAction = new RemoveSlotAction();
        dragAndDropAction = new DragAndDropAction();
        textSlotAction = new TextSlotAction();
        imageSlotAction = new ImageSlotAction();
        colorPickerAction = new ColorPickerAction();
        chooseStrokeAction = new ChooseStrokeAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        openProjectAction = new OpenProjectAction();
        saveProjectAction = new SaveProjectAction();
        editSlotAction = new EditSlotAction();
        saveWorkspaceAction = new SaveWorkspaceAction();
        sharePresentationAction = new SharePresentationAction();
    }

    public RemoveComponentAction getExitAction() {
        return removeComponentAction;
    }

    public NewComponentAction getNewProjectAction() {
        return newComponentAction;
    }

    public void setExitAction(RemoveComponentAction removeComponentAction) {
        this.removeComponentAction = removeComponentAction;
    }

    public void setNewProjectAction(NewComponentAction newComponentAction) {
        this.newComponentAction = newComponentAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public ChangeAuthorAction getChangeAuthorNameAction() {
        return changeAuthorAction;
    }

    public void setChangeAuthorNameAction(ChangeAuthorAction changeAuthorAction) {
        this.changeAuthorAction = changeAuthorAction;
    }

    public ChangeBackgroundAction getChangeAuthorPictureAction() {
        return changeBackgroundAction;
    }

    public void setChangeAuthorPictureAction(ChangeBackgroundAction changeBackgroundAction) {
        this.changeBackgroundAction = changeBackgroundAction;
    }

    public RemoveComponentAction getRemoveComponentAction() {
        return removeComponentAction;
    }

    public void setRemoveComponentAction(RemoveComponentAction removeComponentAction) {
        this.removeComponentAction = removeComponentAction;
    }

    public NewComponentAction getNewComponentAction() {
        return newComponentAction;
    }

    public void setNewComponentAction(NewComponentAction newComponentAction) {
        this.newComponentAction = newComponentAction;
    }

    public ChangeAuthorAction getChangeAuthorAction() {
        return changeAuthorAction;
    }

    public void setChangeAuthorAction(ChangeAuthorAction changeAuthorAction) {
        this.changeAuthorAction = changeAuthorAction;
    }

    public ChangeBackgroundAction getChangeBackgroundAction() {
        return changeBackgroundAction;
    }

    public void setChangeBackgroundAction(ChangeBackgroundAction changeBackgroundAction) {
        this.changeBackgroundAction = changeBackgroundAction;
    }

    public GoToSlideShowStateAction getGoToSlideShowStateAction() {
        return goToSlideShowStateAction;
    }

    public void setGoToSlideShowStateAction(GoToSlideShowStateAction goToSlideShowStateAction) {
        this.goToSlideShowStateAction = goToSlideShowStateAction;
    }

    public GoToEditStateAction getGoToEditStaateAction() {
        return goToEditStateAction;
    }

    public void setGoToEditStaateAction(GoToEditStateAction goToEditStateAction) {
        this.goToEditStateAction = goToEditStateAction;
    }

    public GoToEditStateAction getGoToEditStateAction() {
        return goToEditStateAction;
    }

    public void setGoToEditStateAction(GoToEditStateAction goToEditStateAction) {
        this.goToEditStateAction = goToEditStateAction;
    }

    public NextSlideAction getNextSlideAction() {
        return nextSlideAction;
    }

    public void setNextSlideAction(NextSlideAction nextSlideAction) {
        this.nextSlideAction = nextSlideAction;
    }

    public PreviousSlideAction getPreviousSlideAction() {
        return previousSlideAction;
    }

    public void setPreviousSlideAction(PreviousSlideAction previousSlideAction) {
        this.previousSlideAction = previousSlideAction;
    }

    public TextSlotAction getTextSlotAction() {
        return textSlotAction;
    }

    public void setTextSlotAction(TextSlotAction textSlotAction) {
        this.textSlotAction = textSlotAction;
    }

    public RemoveSlotAction getRemoveSlotAction() {
        return removeSlotAction;
    }

    public void setRemoveSlotAction(RemoveSlotAction removeSlotAction) {
        this.removeSlotAction = removeSlotAction;
    }

    public ImageSlotAction getImageSlotAction() {
        return imageSlotAction;
    }

    public void setImageSlotAction(ImageSlotAction imageSlotAction) {
        this.imageSlotAction = imageSlotAction;
    }

    public DragAndDropAction getDragAndDropAction() {
        return dragAndDropAction;
    }

    public void setDragAndDropAction(DragAndDropAction dragAndDropAction) {
        this.dragAndDropAction = dragAndDropAction;
    }

    public ColorPickerAction getColorPickerAction() {
        return colorPickerAction;
    }

    public void setColorPickerAction(ColorPickerAction colorPickerAction) {
        this.colorPickerAction = colorPickerAction;
    }

    public ChooseStrokeAction getChooseStrokeAction() {
        return chooseStrokeAction;
    }

    public void setChooseStrokeAction(ChooseStrokeAction chooseStrokeAction) {
        this.chooseStrokeAction = chooseStrokeAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public void setEditSlotAction(EditSlotAction editSlotAction) {
        this.editSlotAction = editSlotAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public void setSaveWorkspaceAction(SaveWorkspaceAction saveWorkspaceAction) {
        this.saveWorkspaceAction = saveWorkspaceAction;
    }

    public SharePresentationAction getShowSharedDialogAction() {
        return sharePresentationAction;
    }

    public void setShowSharedDialogAction(SharePresentationAction sharePresentationAction) {
        this.sharePresentationAction = sharePresentationAction;
    }
}
