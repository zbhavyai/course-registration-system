package registrationSystem.controller;

import registrationSystem.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeregisterController {
    private DeregisterView deregisterView;

    public DeregisterController() {
        MenuController.disableMenuView();
        this.setDeregisterView(DeregisterView.getInstance());
        this.deregisterView.setOutput("");
        this.updateRegisteredCourseList();
        this.setActions();
        this.getDeregisterView().setVisible(true);
    }

    public DeregisterView getDeregisterView() {
        return deregisterView;
    }

    public void setDeregisterView(DeregisterView deregisterView) {
        this.deregisterView = deregisterView;
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

                    String output = AppController.getStudent().deRegisterFromCourse(AppController.getCatalog(),
                            courseNameNumber[0], courseNameNumber[1]);
                    deregisterView.setOutput(output);
                    updateRegisteredCourseList();
                }
            }
        });

        this.deregisterView.actionOnBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController.enableMenuView();
                deregisterView.setVisible(false);
            }
        });
    }

    public void updateRegisteredCourseList() {
        String[] list = AppController.getStudent().getRegisteredCourseList();

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
