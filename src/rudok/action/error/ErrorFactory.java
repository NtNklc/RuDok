package rudok.action.error;

import rudok.observer.APublisher;

public class ErrorFactory extends APublisher {

    public static ErrorFactory instance = null;

    public static ErrorFactory getInstance(){
        if(instance == null)
            instance = new ErrorFactory();
        return  instance;
    }

    public void makeError(ErrorEnum error) {
        String m = getInstance().errorMsg(error);
        ErrorClass c = new ErrorClass(m, error);
        notifySubscribers(c);
    }


    public static String errorMsg(ErrorEnum e){
        if(e == ErrorEnum.ADD_CHILDREN_TO_SLIDE) return "You can not add children to slides.";
        if(e == ErrorEnum.AUTHOR) return "Only Presentations can have authors.";
        if(e == ErrorEnum.EMPTY_STRING_AUTHOR) return "Author name has to contain at least one non blank character.";
        if(e == ErrorEnum.DELETE_WORKSPACE) return "Users can not delete Workspace.";
        if(e == ErrorEnum.BACKGROUND_NOT_IMAGE) return "Only images can be set as background.";
        if(e == ErrorEnum.NOTHING_SELECTED) return "Action can not be performed if nothing is selected.";
        if(e == ErrorEnum.BACKGROUND_NOT_PRESENTATION) return "Only presentations can have backgrounds.";
        if(e == ErrorEnum.NO_PRESENTATION_NO_STATE) return  "Cant change state if no presentation is selected";
        if(e == ErrorEnum.NOT_PRESENTATION) return "You can only share presentations";
        if(e == ErrorEnum.NOT_IMAGE) return "You can only put images in image slots";
        return "An undefined error has occurred.";
    }
}
