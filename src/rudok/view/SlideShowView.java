package rudok.view;

import rudok.observer.ISubscriber;
import rudok.view.toolBar.GoRightToolbar;
import rudok.view.toolBar.SlideShowToolbar;
import rudok.view.toolBar.GoLeftToolbar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SlideShowView extends APresentationView implements ISubscriber {

    private SlideShowToolbar slideShowToolbar;
    private GoRightToolbar goRightToolbar;
    private GoLeftToolbar goLeftToolbar;
    private List<SlideView> slideViewList;
    private CardLayout cardLayout;
    private JPanel jPanel;
    private JPanel switchPanel;

    public SlideShowView() {
        slideShowToolbar = new SlideShowToolbar();
        slideShowToolbar.setBackground(Color.DARK_GRAY);
        goLeftToolbar = new GoLeftToolbar();
        goRightToolbar = new GoRightToolbar();
        cardLayout = new CardLayout();
        jPanel = new JPanel(cardLayout);
        jPanel.setMaximumSize(new Dimension(250, (int)(250/1.5)));
        switchPanel = new JPanel(new BorderLayout());
        switchPanel.add(goLeftToolbar, BorderLayout.EAST);
        switchPanel.add(goRightToolbar, BorderLayout.WEST);
        switchPanel.add(jPanel, BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.setSize(400,(int)(400/1.5));
        this.add(slideShowToolbar, BorderLayout.NORTH);
        this.add(switchPanel, BorderLayout.CENTER);
        setVisible(true);
        setSlidePanel(jPanel);
    }

    @Override
    public void update(Object notification) {
        updatePresentation(ViewType.SLIDESHOW);
    }

    public SlideShowToolbar getSlideShowToolbar() {
        return slideShowToolbar;
    }

    public void setSlideShowToolbar(SlideShowToolbar slideShowToolbar) {
        this.slideShowToolbar = slideShowToolbar;
    }

    public List<SlideView> getSlideViewList() {
        return slideViewList;
    }

    public void setSlideViewList(List<SlideView> slideViewList) {
        this.slideViewList = slideViewList;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }
}
