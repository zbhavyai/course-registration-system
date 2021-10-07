package registrationSystem.model;

import java.util.ArrayList;

public class StudentModel {
    private String studentName;
    private int studentId;
    private ArrayList<RegistrationModel> courseList;

    public StudentModel(String studentName, int studentId) {
        this.setStudentName(studentName);
        this.setStudentId(studentId);
        this.courseList = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String registerForCourse(CourseCatalogModel cat, String courseName, String courseNumber, int sectionNumber) {
        boolean flag = false;
        CourseModel myCourse = cat.searchCatalog(courseName, courseNumber);

        // max 6 complete
        if (this.courseList.size() == 6) {
            return "You are already registered for 6 courses. You cannot register for more.";
        }

        // invalid course
        else if (myCourse == null) {
            return "The selected course does not exist. Please select a valid course from the catalog.";
        }

        // course without any offering
        else if (myCourse.getOfferingList().size() == 0) {
            return "The selected course does not has any offerings. Please select another course.";
        }

        // check offering and pre-requisites
        else {
            OfferingModel theOffering = myCourse.searchOffering(sectionNumber);

            // course with invalid course offering section number
            if (theOffering == null) {
                return "Invalid course offering selected. Please select the correct offering.";
            }

            // checking the available space in the offering
            else if (theOffering.isFull()) {
                return "No space available in this course offering.";
            }

            else {
                // check if course is already registered
                for (RegistrationModel registeredCourses : this.courseList) {
                    if (registeredCourses.getTheOffering().getTheCourse().equals(myCourse)) {
                        return "You are already registered for this course.";
                    }
                }

                // no pre-requisites
                if (myCourse.getPreReq().size() == 0) {
                    flag = true;
                }

                else {
                    // temporarily set the flag as true. It will be flipped if pre-requisites are
                    // not met
                    flag = true;

                    // check if pre-requisites are met
                    for (CourseModel preReq : myCourse.getPreReq()) {
                        boolean preRequisiteSatisfied = false;

                        for (RegistrationModel registeredCourses : this.courseList) {
                            if (preReq.equals(registeredCourses.getTheOffering().getTheCourse())) {
                                preRequisiteSatisfied = true;
                            }
                        }

                        if (preRequisiteSatisfied == false) {
                            return "Pre-requisites not met. Please register for pre-requisite courses before selecting this course.";
                        }
                    }
                }

                if (flag == true) {
                    new RegistrationModel(this, theOffering);

                    String successMessage = "";
                    successMessage = String.format("Successfully registered for the course %s in section %d.", myCourse,
                            theOffering.getSectionNumber());

                    if (!theOffering.offeringConfirmed()) {
                        successMessage += String.format(
                                "%n%nPlease note that this offering may be withdrawn if registrations remain below threshold.");
                    }

                    return successMessage;
                }
            }
        }

        return "Sorry could not register for the course";
    }

    public String deRegisterFromCourse(CourseCatalogModel cat, String courseName, String courseNumber) {
        RegistrationModel toBeDeRegistered = null;
        CourseModel myCourse = cat.searchCatalog(courseName, courseNumber);

        // invalid course
        if (myCourse == null) {
            return "The selected course does not exist.";
        }

        // check if course is actually registered
        boolean registrationCheck = false;

        for (RegistrationModel registeredCourses : this.courseList) {
            if (registeredCourses.getTheOffering().getTheCourse().equals(myCourse)) {
                toBeDeRegistered = registeredCourses;
                registrationCheck = true;
                break;
            }
        }

        if (registrationCheck == false) {
            return "You are currently not registered for this course.";
        }

        // check if the course has pre-requisite dependency on other registered courses
        for (RegistrationModel registeredCourse : this.courseList) {
            for (CourseModel c : registeredCourse.getTheOffering().getTheCourse().getPreReq()) {
                if (myCourse.equals(c)) {
                    return String.format(
                            "This course is listed as a pre-requisite for some of the registered courses.%nPlease de-register from them before de-registering from this course.");
                }
            }
        }

        // now de-register from the course
        this.removeRegistration(toBeDeRegistered);
        toBeDeRegistered.getTheOffering().removeRegistration(toBeDeRegistered);
        return String.format("Successfully de-registered from the course %s.", myCourse);
    }

    public void addRegistration(RegistrationModel reg) {
        this.courseList.add(reg);
    }

    public void removeRegistration(RegistrationModel reg) {
        this.courseList.remove(reg);
    }

    public String printRegisteredCourses() {
        boolean foundOne = false;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (RegistrationModel r : this.courseList) {
            sb.append(String.format("%d. Course: %s, Section: %s", ++i, r.getTheOffering().getTheCourse(),
                    r.getTheOffering().getSectionNumber()));

            if (!r.getTheOffering().offeringConfirmed()) {
                sb.append(String.format(
                        "    (offering not confirmed as total registrations is less than minimum required)%n%n"));
            }

            else {
                sb.append(String.format("    (offering confirmed)%n%n"));
            }

            foundOne = true;
        }

        if (foundOne) {
            return sb.toString();
        }

        else {
            return null;
        }
    }

    public String[] getRegisteredCourseList() {
        if (this.courseList.size() == 0) {
            return null;
        }

        else {
            String[] list = new String[this.courseList.size()];

            for (int i = 0; i < list.length; i++) {
                list[i] = this.courseList.get(i).getTheOffering().getTheCourse().toString();
            }

            return list;
        }
    }
}
