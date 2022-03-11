package rudok.PresentationState;

import rudok.view.PresentationView;

public interface PresentationState {
     void show(PresentationView presentationView);
     void clear(PresentationView presentationView);
}
