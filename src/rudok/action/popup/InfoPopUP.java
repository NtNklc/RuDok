package rudok.action.popup;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class InfoPopUP extends JDialog {
    JPanel jp;

    public InfoPopUP(){
        setSize(400, 400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        ImageIcon slikaStud = new ImageIcon(getClass().getResource("images/studentImg.jpg"));
        JLabel lStud = new JLabel("Natalija Nikolic 48/20 RN",slikaStud, JLabel.CENTER);
        jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        jp.add(lStud);
        add(jp);
    }

}

