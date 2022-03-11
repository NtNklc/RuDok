package rudok.action;

import rudok.view.PresentationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ColorPickerAction extends AbstractRudokAction{

    public ColorPickerAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("popup/images/Color-palette.png"));
        putValue(NAME, "Color picker");
        putValue(SHORT_DESCRIPTION, "Color picker");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = getCurrentPresentation();
        if(presentationView == null) return;
        Color color = JColorChooser.showDialog(null, "Choose a color for slots", Color.WHITE);
        presentationView.setSlotColor(color);
    }
}
