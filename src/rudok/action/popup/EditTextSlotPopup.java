package rudok.action.popup;

import rudok.view.SlotView;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTextSlotPopup extends JDialog {
    private JButton btnItalic, btnBold, btnUnderline;
    private JButton btnSave;
    private JPanel jpButtonsUp;
    private JPanel jpButtonsDown;
    private SlotView slotView;
    private CustomText text;

    public EditTextSlotPopup(SlotView slotView) {
        setLocationRelativeTo(null);
        this.slotView = slotView;
        text = new CustomText(slotView);
        this.setSize(400,300);
        jpButtonsUp = new JPanel();
        jpButtonsDown = new JPanel();
        GridLayout layoutUp = new GridLayout(1,3);
        layoutUp.setHgap(40);
        jpButtonsUp.setLayout(layoutUp);
        jpButtonsUp.setBackground(Color.GRAY);
        GridLayout layoutDown = new GridLayout(1,1);
        jpButtonsDown.setLayout(layoutDown);
        jpButtonsDown.setBackground(Color.GRAY);

        btnBold = new JButton("Bold");
        btnItalic = new JButton("Italic");
        btnUnderline = new JButton("Underline");
        btnBold.addActionListener(new StyledEditorKit.BoldAction());
        btnItalic.addActionListener(new StyledEditorKit.ItalicAction());
        btnUnderline.addActionListener(new StyledEditorKit.UnderlineAction());
        jpButtonsUp.add(btnBold);
        jpButtonsUp.add(btnItalic);
        jpButtonsUp.add(btnUnderline);

        text.setMinimumSize(new Dimension(300, 200));
        text.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        text.formatString();

        btnSave = new JButton("Save");

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = (StyledDocument) text.getDocument();
                String str = text.getText();
                StringBuilder builder = new StringBuilder();
                boolean bulBold = false;
                boolean bulItalic = false;
                boolean bulUnderline = false;
                for(int i = 0; i < str.length(); i++){
                    Element element = doc.getCharacterElement(i);
                    AttributeSet attributeSet = element.getAttributes();
                    if(bulBold != StyleConstants.isBold(attributeSet)){
                        builder.append("*");
                        bulBold = !bulBold;
                    }
                    if(bulItalic != StyleConstants.isItalic(attributeSet)){
                        builder.append("~");
                        bulItalic = !bulItalic;
                    }
                    if(bulUnderline != StyleConstants.isUnderline(attributeSet)){
                        builder.append("_");
                        bulUnderline = !bulUnderline;
                    }
                    builder.append(str.charAt(i));
                }
                slotView.getModel().setContent(builder.toString());
                dispose();
            }
        });

        jpButtonsDown.add(btnSave);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(jpButtonsUp, BorderLayout.NORTH);
        text.setMaximumSize(new Dimension(400,200));
        panel.add(text, BorderLayout.CENTER);
        panel.add(jpButtonsDown, BorderLayout.SOUTH);
        this.add(panel);

    }
}
