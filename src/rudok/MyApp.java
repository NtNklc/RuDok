package rudok;

import rudok.view.MainFrame;

import java.awt.Component;

public class MyApp {
    public MyApp() {
    }

    public static void main(String[] args) {
        MainFrame b = MainFrame.getMainFrame();
        b.setLocationRelativeTo((Component)null);
        b.setVisible(true);
    }
}
