package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeregisterController {
    private DeregisterView deregisterView;
    private MenuView menuView;
    private CourseCatalogModel cat;
    private StudentModel stu;

    public DeregisterController(MenuView menuView, CourseCatalogModel cat, StudentModel stu) {
        this.setCat(cat);
        this.setStu(stu);
        this.setMenuView(menuView);

        this.menuView.setVisible(false);
        this.setDeregisterView(DeregisterView.getInstance());
        this.deregisterView.setOutput("");
        this.updateRegisteredCourseList();
        this.setActions();
        this.getDeregisterView().setVisible(true);
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

    public DeregisterView getDeregisterView() {
        return deregisterView;
    }

    public void setDeregisterView(DeregisterView deregisterView) {
        this.deregisterView = deregisterView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setActions() {
        this.deregisterView.actionOnDeregisterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseNameNumberCombo = deregisterView.getSelectedCourse();

                if (courseNameNumberCombo.equals("No courses")) {
                    deregisterView.setOutput("Nothing to deregister");
                }

                else {
                    String[] courseNameNumber = courseNameNumberCombo.split("-");

                    String output = stu.deRegisterFromCourse(cat, courseNameNumber[0], courseNameNumber[1]);
                    deregisterView.setOutput(output);
                    updateRegisteredCourseList();
                }
            }
        });

        this.deregisterView.actionOnBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.setVisible(true);
                deregisterView.setVisible(false);
            }
        });
    }

    public void updateRegisteredCourseList() {
        String[] list = this.stu.getRegisteredCourseList();

        if (list == null) {
            list = new String[1];
            list[0] = new String("No courses");
            deregisterView.updateRegisteredCourseList(list);
        }

        else {
            deregisterView.updateRegisteredCourseList(list);
        }
    }
}
