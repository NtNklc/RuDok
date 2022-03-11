package rudok.action.popup;

import rudok.view.SlotView;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class CustomText extends JTextPane {
    SlotView slotView;

    public CustomText(SlotView slotView) {
        this.slotView = slotView;
    }

    public void formatString(){
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        boolean bold = false;
        boolean italic = false;
        boolean underline = false;
        stylizeText(attributeSet, false, false, false);
        String str = slotView.getModel().getContent();
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == '*') bold = !bold;
            else if(str.charAt(i) == '~') italic = !italic;
            else if(str.charAt(i) == '_') underline = !underline;
            else {
                stylizeText(attributeSet, bold, italic, underline);

                Document doc = this.getStyledDocument();
                try {
                    doc.insertString(doc.getLength(), String.valueOf(str.charAt(i)), attributeSet);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void stylizeText(SimpleAttributeSet attributeSet, boolean bold, boolean italic, boolean underline) {
        StyleConstants.setBold(attributeSet, bold);
        StyleConstants.setItalic(attributeSet, italic);
        StyleConstants.setUnderline(attributeSet, underline);
    }
}
