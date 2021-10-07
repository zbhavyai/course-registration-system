package registrationSystem.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class SearchView extends JFrame {
    private static SearchView instanceVar = null;
    private JPanel infoPanel;
    private JLabel courseNameLabel;
    private JTextField courseNameInput;
    private JScrollPane searchResultsPane;
    private JTextPane searchResults;
    private JPanel buttonPanel;
    private JButton searchButton;
    private JButton backButton;

    private SearchView() {
        initComponents();
        setTitle("Course Registration System");
    }

    public static SearchView getInstance() {
        if (instanceVar == null) {
            instanceVar = new SearchView();
        }

        return instanceVar;
    }

    private void initComponents() {
        infoPanel = new JPanel();
        courseNameLabel = new JLabel();
        courseNameInput = new JTextField();
        searchResultsPane = new JScrollPane();
        searchResults = new JTextPane();
        buttonPanel = new JPanel();
        searchButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));

        infoPanel.setBorder(BorderFactory.createTitledBorder("Search Catalog"));
        infoPanel.setMaximumSize(new Dimension(500, 300));
        infoPanel.setMinimumSize(new Dimension(500, 300));
        infoPanel.setPreferredSize(new Dimension(500, 300));

        courseNameLabel.setText("Enter the course name:");
        courseNameLabel.setMaximumSize(new Dimension(100, 25));
        courseNameLabel.setMinimumSize(new Dimension(100, 25));
        courseNameLabel.setPreferredSize(new Dimension(150, 25));

        courseNameInput.setText("Name");
        courseNameInput.setMinimumSize(new Dimension(150, 25));
        courseNameInput.setPreferredSize(new Dimension(150, 25));

        searchResults.setEditable(false);
        searchResults.setText("Your search results will appear here");
        searchResults.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        searchResults.setMaximumSize(new Dimension(200, 375));
        searchResults.setMinimumSize(new Dimension(200, 375));
        searchResults.setPreferredSize(new Dimension(200, 375));
        searchResultsPane.setViewportView(searchResults);

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout
                .setHorizontalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(searchResultsPane, GroupLayout.PREFERRED_SIZE, 418,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(courseNameInput, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(
                                        infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
                                                searchResultsPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                                .addContainerGap()));

        buttonPanel.setMinimumSize(new Dimension(500, 100));
        buttonPanel.setPreferredSize(new Dimension(500, 100));

        searchButton.setText("SEARCH");
        searchButton.setMaximumSize(new Dimension(100, 25));
        searchButton.setMinimumSize(new Dimension(100, 25));
        searchButton.setPreferredSize(new Dimension(100, 25));

        backButton.setText("BACK");
        backButton.setMaximumSize(new Dimension(100, 25));
        backButton.setMinimumSize(new Dimension(100, 25));
        backButton.setPreferredSize(new Dimension(100, 25));

        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap(125, Short.MAX_VALUE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50).addComponent(backButton, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE)));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addGap(35, 35, 35)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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

    public void actionOnSearchButton(ActionListener e) {
        for (ActionListener al : this.searchButton.getActionListeners()) {
            this.searchButton.removeActionListener(al);
        }
        this.searchButton.addActionListener(e);
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

    public void setResults(String results) {
        this.searchResults.setText(results);
    }
}
