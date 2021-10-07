package registrationSystem.controller;

import registrationSystem.view.*;
import registrationSystem.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseController {
    private CourseView courseView;
    private MenuView menuView;
    private CourseCatalogModel cat;
    private StudentModel stu;
    private String type;

    public CourseController(MenuView menuView, CourseCatalogModel cat, StudentModel stu, String type) {
        this.setCat(cat);
        this.setStu(stu);
        this.setMenuView(menuView);
        this.type = type;

        this.menuView.setVisible(false);
        this.setCourseView(CourseView.getInstance());
        this.courseView.setResults("");
        this.setActions();
        this.getCourseView().setVisible(true);
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

    public CourseView getCourseView() {
        return courseView;
    }

    public void setCourseView(CourseView courseView) {
        this.courseView = courseView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setActions() {
        this.courseView.actionOnViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.equals("all")) {
                    String output = cat.toString();
                    courseView.setResults(output);
                }

                else {
                    String output = stu.printRegisteredCourses();

                    if (output == null) {
                        courseView.setResults("You are not registered in any course");
                    }

                    else {
                        courseView.setResults(output);
                    }
                }
            }
        });

        this.courseView.actionOnBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.setVisible(true);
                courseView.removeActionFromViewButton();
                courseView.setVisible(false);
            }
        });
    }
}
