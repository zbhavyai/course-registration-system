package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private CourseCatalogModel cat;
    private StudentModel stu;
    private MenuView menuView;

    public MenuController(CourseCatalogModel cat, StudentModel stu) {
        this.setCat(cat);
        this.setStu(stu);

        this.setMenuView(MenuView.getInstance());
        this.setActions();
        this.getMenuView().setVisible(true);
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public CourseCatalogModel getCat() {
        return cat;
    }

    public void setCat(CourseCatalogModel cat) {
        this.cat = cat;
    }

    public StudentModel getStu() {
        return stu;
    }

    public void setStu(StudentModel stu) {
        this.stu = stu;
    }

    public void setActions() {
        this.menuView.actionOnEnterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String menuOption = menuView.getMenuOption();

                switch (menuOption) {
                    case "search": {
                        new SearchController(menuView, cat);
                    }
                        break;
                    case "register": {
                        new RegisterController(menuView, cat, stu);
                    }
                        break;
                    case "deregister": {
                        new DeregisterController(menuView, cat, stu);
                    }
                        break;
                    case "view catalog": {
                        new CourseController(menuView, cat, stu, "all");
                    }
                        break;
                    case "view registered": {
                        new CourseController(menuView, cat, stu, "registered");
                    }
                        break;
                }
            }
        });

        this.menuView.actionOnQuitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
