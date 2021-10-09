package registrationSystem.controller;

import registrationSystem.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseController {
    private CourseView courseView;
    private String type;

    public CourseController(String type) {
        this.type = type;

        MenuController.disableMenuView();
        this.setCourseView(CourseView.getInstance());
        this.courseView.setResults("");
        this.setActions();
        this.getCourseView().setVisible(true);
    }

    public CourseView getCourseView() {
        return courseView;
    }

    public void setCourseView(CourseView courseView) {
        this.courseView = courseView;
    }

    public void setActions() {
        this.courseView.actionOnViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (type.equals("all")) {
                    String output = AppController.getCatalog().toString();
                    courseView.setResults(output);
                }

                else {
                    String output = AppController.getStudent().printRegisteredCourses();

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
                MenuController.enableMenuView();
                courseView.removeActionFromViewButton();
                courseView.setVisible(false);
            }
        });
    }
}
