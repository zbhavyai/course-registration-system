package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class DeregisterView extends JFrame {
    private static DeregisterView instanceVar = null;
    private JPanel infoPanel;
    private JLabel courseNameLabel;
    private JComboBox<String> courseNameInput;
    private JScrollPane outputPane;
    private JTextPane output;
    private JPanel buttonPanel;
    private JButton deregisterButton;
    private JButton backButton;

    private DeregisterView() {
        initComponents();
    }

    public static DeregisterView getInstance() {
        if (instanceVar == null) {
            instanceVar = new DeregisterView();
        }

        return instanceVar;
    }

    private void initComponents() {
        infoPanel = new JPanel();
        courseNameLabel = new JLabel();
        outputPane = new JScrollPane();
        output = new JTextPane();
        courseNameInput = new JComboBox<>();
        buttonPanel = new JPanel();
        deregisterButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));

        infoPanel.setBorder(BorderFactory.createTitledBorder("De-register from Course"));
        infoPanel.setMaximumSize(new Dimension(500, 300));
        infoPanel.setMinimumSize(new Dimension(500, 300));
        infoPanel.setPreferredSize(new Dimension(500, 300));

        courseNameLabel.setText("Select from a registered course:");
        courseNameLabel.setMaximumSize(new Dimension(200, 25));
        courseNameLabel.setMinimumSize(new Dimension(200, 25));
        courseNameLabel.setPreferredSize(new Dimension(200, 25));

        output.setEditable(false);
        output.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        output.setMaximumSize(new Dimension(200, 375));
        output.setMinimumSize(new Dimension(200, 375));
        output.setPreferredSize(new Dimension(200, 375));
        outputPane.setViewportView(output);

        courseNameInput.setModel(new DefaultComboBoxModel<>(new String[] { "No courses" }));
        courseNameInput.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        courseNameInput.setMaximumSize(new Dimension(150, 25));
        courseNameInput.setMinimumSize(new Dimension(150, 25));
        courseNameInput.setPreferredSize(new Dimension(150, 25));

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(infoPanelLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(courseNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addComponent(outputPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)).addGap(25, 25, 25)));
        infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(courseNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(outputPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)));

        buttonPanel.setMinimumSize(new Dimension(500, 100));
        buttonPanel.setPreferredSize(new Dimension(500, 100));

        deregisterButton.setText("DE-REGISTER");
        deregisterButton.setMaximumSize(new Dimension(125, 25));
        deregisterButton.setMinimumSize(new Dimension(125, 25));
        deregisterButton.setPreferredSize(new Dimension(125, 25));

        backButton.setText("BACK");
        backButton.setMaximumSize(new Dimension(100, 25));
        backButton.setMinimumSize(new Dimension(100, 25));
        backButton.setPreferredSize(new Dimension(100, 25));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(99, Short.MAX_VALUE)
                        .addComponent(deregisterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(backButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(126, Short.MAX_VALUE)));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addGap(35, 35, 35)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deregisterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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

    public void actionOnDeregisterButton(ActionListener e) {
        for (ActionListener al : this.deregisterButton.getActionListeners()) {
            this.deregisterButton.removeActionListener(al);
        }
        this.deregisterButton.addActionListener(e);
    }

    public void actionOnBackButton(ActionListener e) {
        for (ActionListener al : this.backButton.getActionListeners()) {
            this.backButton.removeActionListener(al);
        }
        this.backButton.addActionListener(e);
    }

    public void setOutput(String results) {
        this.output.setText(results);
    }

    public String getSelectedCourse() {
        return (String) this.courseNameInput.getSelectedItem();
    }

    public void updateRegisteredCourseList(String[] courseList) {
        courseNameInput.removeAllItems();
        ;

        // courseNameInput.setModel(new DefaultComboBoxModel<>(new String[] { "No
        // courses" }));
        for (String c : courseList) {
            courseNameInput.addItem(c);
        }
    }
}
