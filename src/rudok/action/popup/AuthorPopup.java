package rudok.action.popup;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.model.GraphicTree.MyTree;
import rudok.model.GraphicTree.MyTreeNode;
import rudok.model.workspace.Presentation;
import rudok.model.workspace.Project;
import rudok.model.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AuthorPopup extends JDialog {
    JPanel jp;

    public AuthorPopup(Presentation presentation){
        setSize(170, 150);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        JLabel lblIme = new JLabel("Change Author name:");
        JTextField tfAutor = new JTextField(10);
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        jp.add(lblIme);
        jp.add(tfAutor);
        jp.add(btnOk);
        jp.add(btnCancel);
        //(lblIme, tfAutor, btnOk, btnCancel);
        add(jp);




        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfAutor.getText().isBlank()) {
                    String newName = tfAutor.getText();
                    presentation.setAuthor(newName);
                    dispose();
                }
                else {
                    ErrorFactory.getInstance().makeError(ErrorEnum.EMPTY_STRING_AUTHOR);
                    return;
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
