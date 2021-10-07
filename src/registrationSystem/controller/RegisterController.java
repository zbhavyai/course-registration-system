package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private RegisterView registerView;
    private MenuView menuView;
    private CourseCatalogModel cat;
    private StudentModel stu;

    public RegisterController(MenuView menuView, CourseCatalogModel cat, StudentModel stu) {
        this.setCat(cat);
        this.setStu(stu);
        this.setMenuView(menuView);

        this.menuView.setVisible(false);
        this.setRegisterView(RegisterView.getInstance());
        this.registerView.setResults("");
        this.setActions();
        this.getRegisterView().setVisible(true);
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

    public RegisterView getRegisterView() {
        return registerView;
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerView = registerView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setActions() {


        this.registerView.actionOnRegisterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = registerView.getCourseName().toUpperCase();
                String courseNumber = String.valueOf(registerView.getCourseNumber());
                int courseOffering = registerView.getCourseOffering();

                String output = stu.registerForCourse(cat, courseName, courseNumber, courseOffering);
                registerView.setResults(output);
            }
        });

        this.registerView.actionOnBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.setVisible(true);
                registerView.setVisible(false);
            }
        });
    }
}
