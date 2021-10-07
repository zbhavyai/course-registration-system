package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class AppView extends JFrame {
    private JPanel infoPanel;
    private JLabel studentIdLabel;
    private JSpinner studentIdInput;
    private JLabel studentNameLabel;
    private JTextField studentNameInput;
    private JPanel buttonPanel;
    private JButton enterButton;
    private JButton quitButton;

    public AppView() {
        initComponents();
    }

    private void initComponents() {
        infoPanel = new JPanel();
        studentNameLabel = new JLabel();
        studentIdLabel = new JLabel();
        studentNameInput = new JTextField();
        studentIdInput = new JSpinner();
        buttonPanel = new JPanel();
        enterButton = new JButton();
        quitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));

        infoPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        infoPanel.setMaximumSize(new Dimension(400, 200));
        infoPanel.setMinimumSize(new Dimension(400, 200));
        infoPanel.setPreferredSize(new Dimension(400, 200));

        studentNameLabel.setText("Student Name:");
        studentNameLabel.setMaximumSize(new Dimension(100, 25));
        studentNameLabel.setMinimumSize(new Dimension(100, 25));
        studentNameLabel.setPreferredSize(new Dimension(100, 25));

        studentIdLabel.setText("UCID:");
        studentIdLabel.setMaximumSize(new Dimension(100, 25));
        studentIdLabel.setMinimumSize(new Dimension(100, 25));
        studentIdLabel.setPreferredSize(new Dimension(100, 25));

        studentNameInput.setText("FirstName LastName");
        studentNameInput.setMaximumSize(new Dimension(200, 25));
        studentNameInput.setMinimumSize(new Dimension(200, 25));
        studentNameInput.setPreferredSize(new Dimension(200, 25));

        studentIdInput.setMinimumSize(new Dimension(200, 25));
        studentIdInput.setPreferredSize(new Dimension(200, 25));

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(27, 27, 27)
                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentIdLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(studentNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addGap(51, 51, Short.MAX_VALUE)
                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentNameInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(studentIdInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addContainerGap()));
        infoPanelLayout
                .setVerticalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup().addGap(46, 46, 46)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(studentNameInput, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(studentIdInput, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(48, Short.MAX_VALUE)));

        buttonPanel.setMinimumSize(new Dimension(400, 100));
        buttonPanel.setPreferredSize(new Dimension(400, 100));

        enterButton.setText("ENTER");
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
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(74, Short.MAX_VALUE)
                        .addComponent(enterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(quitButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(76, Short.MAX_VALUE)));
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
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(200, 200, 200)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(50, 50, 50)
                        .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    public void actionOnEnterButton(ActionListener e) {
        for (ActionListener al : this.enterButton.getActionListeners()) {
            this.enterButton.removeActionListener(al);
        }
        this.enterButton.addActionListener(e);
    }

    public void actionOnQuitButton(ActionListener e) {
        for (ActionListener al : this.quitButton.getActionListeners()) {
            this.quitButton.removeActionListener(al);
        }
        this.quitButton.addActionListener(e);
    }

    public String getStudentName() {
        String studentName = this.studentNameInput.getText();

        if (studentName == null) {
            studentName = "";
        }

        return studentName;
    }

    public int getStudentId() {
        return ((Integer) this.studentIdInput.getValue());
    }
}
