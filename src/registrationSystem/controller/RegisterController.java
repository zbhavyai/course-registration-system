package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private RegisterView registerView;
    private CourseCatalogModel cat;
    private StudentModel stu;

    public RegisterController(CourseCatalogModel cat, StudentModel stu) {
        this.setCat(cat);
        this.setStu(stu);

        MenuController.disableMenuView();
        this.setRegisterView(RegisterView.getInstance());
        this.registerView.setResults("");
        this.setActions();
        this.getRegisterView().setVisible(true);
    }

    public void setCat(CourseCatalogModel cat) {
        this.cat = cat;
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
                MenuController.enableMenuView();
                registerView.setVisible(false);
            }
        });
    }
}
