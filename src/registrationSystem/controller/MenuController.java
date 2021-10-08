package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private CourseCatalogModel cat;
    private StudentModel stu;
    private static MenuView menuView;

    public MenuController(CourseCatalogModel cat, StudentModel stu) {
        this.setCat(cat);
        this.setStu(stu);

        menuView = MenuView.getInstance();
        this.setActions();
        enableMenuView();
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

    public static void disableMenuView() {
        menuView.setVisible(false);
    }

    public static void enableMenuView() {
        menuView.setVisible(true);
    }

    public void setActions() {
        menuView.actionOnEnterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String menuOption = menuView.getMenuOption();

                switch (menuOption) {
                    case "search": {
                        new SearchController(cat);
                    }
                        break;
                    case "register": {
                        new RegisterController(cat, stu);
                    }
                        break;
                    case "deregister": {
                        new DeregisterController(cat, stu);
                    }
                        break;
                    case "view catalog": {
                        new CourseController(cat, stu, "all");
                    }
                        break;
                    case "view registered": {
                        new CourseController(cat, stu, "registered");
                    }
                        break;
                }
            }
        });

        menuView.actionOnQuitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
