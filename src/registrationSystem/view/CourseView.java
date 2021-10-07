package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class CourseView extends JFrame {
    private static CourseView instanceVar = null;
    private JPanel infoPanel;
    private JScrollPane outputPane;
    private JTextPane output;
    private JPanel buttonPanel;
    private JButton viewButton;
    private JButton backButton;

    private CourseView() {
        initComponents();
    }

    public static CourseView getInstance() {
        if (instanceVar == null) {
            instanceVar = new CourseView();
        }

        return instanceVar;
    }

    private void initComponents() {
        infoPanel = new JPanel();
        outputPane = new JScrollPane();
        output = new JTextPane();
        buttonPanel = new JPanel();
        viewButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));

        infoPanel.setBorder(BorderFactory.createTitledBorder("View"));
        infoPanel.setMaximumSize(new Dimension(500, 300));
        infoPanel.setMinimumSize(new Dimension(500, 300));
        infoPanel.setPreferredSize(new Dimension(500, 300));

        output.setEditable(false);
        output.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        output.setMaximumSize(new Dimension(200, 375));
        output.setMinimumSize(new Dimension(200, 375));
        output.setPreferredSize(new Dimension(200, 375));
        outputPane.setViewportView(output);

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                        .addComponent(outputPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addContainerGap(22, Short.MAX_VALUE)));
        infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addGap(20, 20, 20)
                        .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(outputPane, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                        .addContainerGap(23, Short.MAX_VALUE)));

        buttonPanel.setMinimumSize(new Dimension(500, 100));
        buttonPanel.setPreferredSize(new Dimension(500, 100));

        viewButton.setText("VIEW");
        viewButton.setMaximumSize(new Dimension(100, 25));
        viewButton.setMinimumSize(new Dimension(100, 25));
        viewButton.setPreferredSize(new Dimension(100, 25));

        backButton.setText("BACK");
        backButton.setMaximumSize(new Dimension(100, 25));
        backButton.setMinimumSize(new Dimension(100, 25));
        backButton.setPreferredSize(new Dimension(100, 25));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(125, Short.MAX_VALUE)
                        .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(backButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE)));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addGap(35, 35, 35)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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

    public void actionOnViewButton(ActionListener e) {
        this.viewButton.addActionListener(e);
    }

    public void removeActionFromViewButton() {
        for (ActionListener al : this.viewButton.getActionListeners()) {
            this.viewButton.removeActionListener(al);
        }
    }

    public void actionOnBackButton(ActionListener e) {
        this.backButton.addActionListener(e);
    }

    public void setResults(String results) {
        this.output.setText(results);
    }
}
