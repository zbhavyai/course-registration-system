package registrationSystem.controller;

import registrationSystem.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchController {
    private SearchView searchView;

    public SearchController() {
        MenuController.disableMenuView();
        this.setSearchView(SearchView.getInstance());
        this.setActions();
        this.getSearchView().setVisible(true);
    }

    public SearchView getSearchView() {
        return searchView;
    }

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }

    public void setActions() {
        this.searchView.actionOnSearchButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = searchView.getCourseName().toUpperCase();
                String output = AppController.getCatalog().searchCatalog(courseName);

                if (output == null) {
                    searchView.setResults("Sorry no courses found. Please refine your search.");
                }

                else {
                    searchView.setResults(output);
                }
            }
        });

        this.searchView.actionOnBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController.enableMenuView();
                searchView.setVisible(false);
            }
        });
    }
}
