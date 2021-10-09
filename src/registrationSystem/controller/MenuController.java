package registrationSystem.controller;

import registrationSystem.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private static MenuView menuView;

    public MenuController() {
        menuView = MenuView.getInstance();
        this.setActions();
        enableMenuView();
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
                        new SearchController();
                    }
                        break;
                    case "register": {
                        new RegisterController();
                    }
                        break;
                    case "deregister": {
                        new DeregisterController();
                    }
                        break;
                    case "view catalog": {
                        new CourseController("all");
                    }
                        break;
                    case "view registered": {
                        new CourseController("registered");
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
