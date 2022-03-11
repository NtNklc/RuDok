package rudok.action.popup;

import rudok.action.error.ErrorEnum;
import rudok.action.error.ErrorFactory;
import rudok.view.PresentationView;
import rudok.view.toolBar.StrokeEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrokePopup extends JDialog {

    private JPanel jp;

    public StrokePopup(PresentationView presentationView){
        setSize(170, 150);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        JLabel lblIme = new JLabel("Choose stroke type");

        JToggleButton btnFull = new JToggleButton("Full stroke");
        JToggleButton btnDashed = new JToggleButton("Dashed stroke");
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        jp.add(lblIme);
        jp.add(btnFull);
        jp.add(btnDashed);
        jp.add(btnOk);
        jp.add(btnCancel);
        //(lblIme, tfAutor, btnOk, btnCancel);
        add(jp);

        System.out.println("Stroke popup");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!btnDashed.isSelected() && !btnFull.isSelected()){
                    //drugi error
                    ErrorFactory.getInstance().makeError(ErrorEnum.EMPTY_STRING_AUTHOR);
                    return;
                }
                else {
                    if (btnFull.isSelected())
                        presentationView.setStroke(StrokeEnum.FULL);
                    if(btnDashed.isSelected())
                        presentationView.setStroke(StrokeEnum.DASHED);
                    dispose();
                }
                System.out.println("OK stroke");
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
