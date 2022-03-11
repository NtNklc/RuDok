package rudok.action.popup;

import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WorkspacePopup extends JDialog {
    public WorkspacePopup()
    {
        setSize(400,100);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        JButton btnNew = new JButton("Create new Workspace");
        JButton btnLoad = new JButton("Load Workspace");

        p.add(btnNew);
        p.add(btnLoad);

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION) {
                    File f = jfc.getSelectedFile();
                    MainFrame.getMainFrame().setWorkspaceFile(f);
                    dispose();
                } else return;
            }
        });
        add(p);
    }
}
