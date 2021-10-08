package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchController {
    private SearchView searchView;
    private CourseCatalogModel cat;

    public SearchController(CourseCatalogModel cat) {
        this.setCat(cat);
        MenuController.disableMenuView();

        this.setSearchView(SearchView.getInstance());
        this.setActions();
        this.getSearchView().setVisible(true);
    }

    public void setCat(CourseCatalogModel cat) {
        this.cat = cat;
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
                String output = cat.searchCatalog(courseName);

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
