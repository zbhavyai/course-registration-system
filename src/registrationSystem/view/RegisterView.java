package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private static RegisterView instanceVar = null;
    private JPanel infoPanel;
    private JLabel courseNameLabel;
    private JLabel courseNumberLabel;
    private JLabel courseOfferingLabel;
    private JTextField courseNameInput;
    private JSpinner courseNumberInput;
    private JSpinner courseOfferingInput;
    private JScrollPane searchResultsPane;
    private JTextPane searchResults;
    private JPanel buttonPanel;
    private JButton registerButton;
    private JButton backButton;

    private RegisterView() {
        initComponents();
    }

    public static RegisterView getInstance() {
        if (instanceVar == null) {
            instanceVar = new RegisterView();
        }

        return instanceVar;
    }

    private void initComponents() {
        infoPanel = new JPanel();
        courseNameLabel = new JLabel();
        courseNameInput = new JTextField();
        searchResultsPane = new JScrollPane();
        searchResults = new JTextPane();
        courseNumberLabel = new JLabel();
        courseNumberInput = new JSpinner();
        courseOfferingLabel = new JLabel();
        courseOfferingInput = new JSpinner();
        buttonPanel = new JPanel();
        registerButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));

        infoPanel.setBorder(BorderFactory.createTitledBorder("Register for course"));
        infoPanel.setMaximumSize(new Dimension(500, 300));
        infoPanel.setMinimumSize(new Dimension(500, 300));
        infoPanel.setPreferredSize(new Dimension(500, 300));

        courseNameLabel.setText("Enter the course name:");
        courseNameLabel.setMaximumSize(new Dimension(150, 25));
        courseNameLabel.setMinimumSize(new Dimension(150, 25));
        courseNameLabel.setPreferredSize(new Dimension(150, 25));

        courseNameInput.setText("Name");
        courseNameInput.setMinimumSize(new Dimension(150, 25));
        courseNameInput.setPreferredSize(new Dimension(150, 25));

        searchResults.setEditable(false);
        searchResults.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        searchResults.setMaximumSize(new Dimension(200, 375));
        searchResults.setMinimumSize(new Dimension(200, 375));
        searchResults.setPreferredSize(new Dimension(200, 375));
        searchResultsPane.setViewportView(searchResults);

        courseNumberLabel.setText("Enter the course number:");
        courseNumberLabel.setMaximumSize(new Dimension(150, 25));
        courseNumberLabel.setMinimumSize(new Dimension(150, 25));
        courseNumberLabel.setPreferredSize(new Dimension(150, 25));

        courseNumberInput.setMaximumSize(new Dimension(150, 25));
        courseNumberInput.setMinimumSize(new Dimension(150, 25));
        courseNumberInput.setPreferredSize(new Dimension(150, 25));

        courseOfferingLabel.setText("Enter the section number:");
        courseOfferingLabel.setMaximumSize(new Dimension(150, 25));
        courseOfferingLabel.setMinimumSize(new Dimension(150, 25));
        courseOfferingLabel.setPreferredSize(new Dimension(150, 25));

        courseOfferingInput.setMaximumSize(new Dimension(150, 25));
        courseOfferingInput.setMinimumSize(new Dimension(150, 25));
        courseOfferingInput.setPreferredSize(new Dimension(150, 25));

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(infoPanelLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(courseOfferingLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(infoPanelLayout.createSequentialGroup().addGroup(infoPanelLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(searchResultsPane)
                                .addGroup(GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(courseNumberLabel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(courseNumberInput, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(courseNameInput, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(courseOfferingInput, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25)))));
        infoPanelLayout
                .setVerticalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseNameInput, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(courseNumberLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseNumberInput, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(courseOfferingLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseOfferingInput, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(searchResultsPane, GroupLayout.PREFERRED_SIZE, 120,
                                GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)));

        buttonPanel.setMinimumSize(new Dimension(500, 100));
        buttonPanel.setPreferredSize(new Dimension(500, 100));

        registerButton.setText("REGISTER");
        registerButton.setMaximumSize(new Dimension(100, 25));
        registerButton.setMinimumSize(new Dimension(100, 25));
        registerButton.setPreferredSize(new Dimension(100, 25));

        backButton.setText("BACK");
        backButton.setMaximumSize(new Dimension(100, 25));
        backButton.setMinimumSize(new Dimension(100, 25));
        backButton.setPreferredSize(new Dimension(100, 25));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(125, Short.MAX_VALUE)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(backButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE)));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addGap(35, 35, 35)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(150, 150, 150)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(50, 50, 50)
                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(buttonPanel,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    public void actionOnRegisterButton(ActionListener e) {
        for (ActionListener al : this.registerButton.getActionListeners()) {
            this.registerButton.removeActionListener(al);
        }
        this.registerButton.addActionListener(e);
    }

    public void actionOnBackButton(ActionListener e) {
        for (ActionListener al : this.backButton.getActionListeners()) {
            this.backButton.removeActionListener(al);
        }
        this.backButton.addActionListener(e);
    }

    public String getCourseName() {
        String courseName = this.courseNameInput.getText();

        if (courseName == null) {
            courseName = "";
        }

        return courseName;
    }

    public int getCourseNumber() {
        int courseNumber = (Integer) this.courseNumberInput.getValue();

        return courseNumber;
    }

    public int getCourseOffering() {
        int courseOffering = (Integer) this.courseOfferingInput.getValue();

        return courseOffering;
    }

    public void setResults(String results) {
        this.searchResults.setText(results);
    }
}
