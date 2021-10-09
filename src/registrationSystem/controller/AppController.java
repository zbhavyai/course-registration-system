package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController {
    private AppView appView;
    private static CourseCatalogModel cat;
    private static StudentModel stu;

    public AppController() {
        this.setAppView(new AppView());
        this.setActions();
        this.getAppView().setVisible(true);
    }

    public AppView getAppView() {
        return appView;
    }

    public void setAppView(AppView appView) {
        this.appView = appView;
    }

    public static CourseCatalogModel getCatalog() {
        return cat;
    }

    public static StudentModel getStudent() {
        return stu;
    }

    public void setActions() {
        this.appView.actionOnEnterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = appView.getStudentName();
                int studentId = appView.getStudentId();

                stu = new StudentModel(studentName, studentId);
                cat = new CourseCatalogModel();

                AppModel.getInstance(cat);

                appView.setVisible(false);
                new MenuController();
            }
        });

        this.appView.actionOnQuitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AppController();
    }
}
