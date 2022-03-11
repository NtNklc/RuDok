package rudok.action.error;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPopup extends JDialog{
    JPanel jp;

    public ErrorPopup(ErrorClass e){
        setTitle("An error has occurred!");
        setSize(300, 100);
        setLocationRelativeTo(null);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        //JLabel lblMSG = new JLabel("An error has occurred:");
            //wannna see how setTitle works
        JLabel lblError = new JLabel(e.getMsg());
        //need to get error
        JButton btnOk = new JButton("OK");
        //jp.add(lblMSG);
        jp.add(lblError);
        jp.add(btnOk);
        add(jp);


        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
            }
        });

        //setVisible(true);
    }
}
