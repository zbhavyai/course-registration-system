package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private static MenuView instanceVar = null;
    private JPanel infoPanel;
    private ButtonGroup menuOptions;
    private JRadioButton searchRadio;
    private JRadioButton registerRadio;
    private JRadioButton deregisterRadio;
    private JRadioButton viewCatalogRadio;
    private JRadioButton viewRegisteredRadio;
    private JPanel buttonPanel;
    private JButton enterButton;
    private JButton quitButton;

    private MenuView() {
        initComponents();
    }

    public static MenuView getInstance() {
        if (instanceVar == null) {
            instanceVar = new MenuView();
        }

        return instanceVar;
    }

    private void initComponents() {
        infoPanel = new JPanel();
        menuOptions = new ButtonGroup();
        searchRadio = new JRadioButton();
        registerRadio = new JRadioButton();
        deregisterRadio = new JRadioButton();
        viewCatalogRadio = new JRadioButton();
        viewRegisteredRadio = new JRadioButton();

        buttonPanel = new JPanel();
        enterButton = new JButton();
        quitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        infoPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        infoPanel.setMaximumSize(new Dimension(400, 300));
        infoPanel.setMinimumSize(new Dimension(400, 300));
        infoPanel.setPreferredSize(new Dimension(400, 300));

        menuOptions.add(searchRadio);
        searchRadio.setText("Search catalog courses");
        searchRadio.setMaximumSize(new Dimension(250, 25));
        searchRadio.setMinimumSize(new Dimension(250, 25));
        searchRadio.setPreferredSize(new Dimension(250, 25));
        searchRadio.setSelected(true);

        menuOptions.add(registerRadio);
        registerRadio.setText("Add course to student courses");
        registerRadio.setMaximumSize(new Dimension(250, 25));
        registerRadio.setMinimumSize(new Dimension(250, 25));
        registerRadio.setPreferredSize(new Dimension(250, 25));

        menuOptions.add(deregisterRadio);
        deregisterRadio.setText("Remove course from student courses");
        deregisterRadio.setMaximumSize(new Dimension(250, 25));
        deregisterRadio.setMinimumSize(new Dimension(250, 25));
        deregisterRadio.setPreferredSize(new Dimension(250, 25));

        menuOptions.add(viewCatalogRadio);
        viewCatalogRadio.setText("View all courses in catalog");
        viewCatalogRadio.setMaximumSize(new Dimension(250, 25));
        viewCatalogRadio.setMinimumSize(new Dimension(250, 25));
        viewCatalogRadio.setPreferredSize(new Dimension(250, 25));

        menuOptions.add(viewRegisteredRadio);
        viewRegisteredRadio.setText("View all courses taken by student");
        viewRegisteredRadio.setMaximumSize(new Dimension(250, 25));
        viewRegisteredRadio.setMinimumSize(new Dimension(250, 25));
        viewRegisteredRadio.setPreferredSize(new Dimension(250, 25));

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(75, 75, 75)
                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(viewRegisteredRadio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewCatalogRadio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(deregisterRadio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerRadio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchRadio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)));
        infoPanelLayout
                .setVerticalGroup(
                        infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(
                                        infoPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                                                .addComponent(searchRadio, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(registerRadio, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(deregisterRadio, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(viewCatalogRadio, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(viewRegisteredRadio, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(49, Short.MAX_VALUE)));

        buttonPanel.setMinimumSize(new Dimension(400, 100));
        buttonPanel.setPreferredSize(new Dimension(400, 100));

        enterButton.setText("SELECT");
        enterButton.setMaximumSize(new Dimension(100, 25));
        enterButton.setMinimumSize(new Dimension(100, 25));
        enterButton.setPreferredSize(new Dimension(100, 25));

        quitButton.setText("QUIT");
        quitButton.setMaximumSize(new Dimension(100, 25));
        quitButton.setMinimumSize(new Dimension(100, 25));
        quitButton.setPreferredSize(new Dimension(100, 25));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(75, Short.MAX_VALUE)
                        .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(quitButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(75, Short.MAX_VALUE)));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addGap(35, 35, 35)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(200, 200, 200)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(50, 50, 50)
                        .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    public void actionOnEnterButton(ActionListener e) {
        this.enterButton.addActionListener(e);
    }

    public void actionOnQuitButton(ActionListener e) {
        this.quitButton.addActionListener(e);
    }

    public String getMenuOption() {
        if (this.searchRadio.isSelected()) {
            return "search";
        }

        else if (this.registerRadio.isSelected()) {
            return "register";
        }

        else if (this.deregisterRadio.isSelected()) {
            return "deregister";
        }

        else if (this.viewCatalogRadio.isSelected()) {
            return "view catalog";
        }

        else if (this.viewRegisteredRadio.isSelected()) {
            return "view registered";
        }

        else {
            return "";
        }
    }
}
