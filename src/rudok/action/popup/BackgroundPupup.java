package rudok.action.popup;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.model.workspace.Presentation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class BackgroundPupup extends JDialog {
    private JPanel jp;
    private List<String> extensions = Arrays.asList("jpg", "png", "jpeg", "jiff", "img", "tiff", "psd", "raw");


    public BackgroundPupup(Presentation presentation) {
        setSize(500, 400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        JFileChooser j = new JFileChooser();
        j.setMultiSelectionEnabled(false);
        j.setControlButtonsAreShown(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", String.valueOf(extensions));
        j.setFileFilter(filter);
        setTitle("Change Presentation background");
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        jp.add(j);
        jp.add(btnOk);
        jp.add(btnCancel);
        add(jp);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (j.getSelectedFile() == null)
                    ErrorFactory.getInstance().makeError(ErrorEnum.NOTHING_SELECTED);
                else {
                    String name = j.getSelectedFile().getAbsolutePath();
                    int index = name.lastIndexOf('.');
                    String extension = "";
                    if (index > 0) extension = name.substring(index + 1);
                    if (!extensions.contains(extension)) {
                        System.out.println(j.getSelectedFile());
                        ErrorFactory.getInstance().makeError(ErrorEnum.BACKGROUND_NOT_IMAGE);
                    } else {
                        presentation.setBackground(name);
                        dispose();
                    }
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
