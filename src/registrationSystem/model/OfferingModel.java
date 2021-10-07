package registrationSystem.model;

import java.util.ArrayList;

public class OfferingModel {
    private int sectionNumber;
    private int sectionCapacity;
    private CourseModel theCourse;
    private ArrayList<RegistrationModel> studentList;

    public OfferingModel(int sectionNumber, int sectionCapacity) {
        this.setSectionNumber(sectionNumber);
        this.setSectionCapacity(sectionCapacity);
        this.studentList = new ArrayList<>();
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getSectionCapacity() {
        return sectionCapacity;
    }

    public void setSectionCapacity(int sectionCapacity) {
        this.sectionCapacity = sectionCapacity;
    }

    public CourseModel getTheCourse() {
        return theCourse;
    }

    public void setTheCourse(CourseModel theCourse) {
        this.theCourse = theCourse;
    }

    public void addRegistration(RegistrationModel reg) {
        this.studentList.add(reg);
    }

    public void removeRegistration(RegistrationModel reg) {
        this.studentList.remove(reg);
    }

    public boolean isFull() {
        return (this.studentList.size() == this.getSectionCapacity());
    }

    /**
     * Determines if the courses has more than eight registrations
     *
     * @return {@code true} if course has more than eight registrations,
     *         {@code false} otherwise
     */
    public boolean offeringConfirmed() {
        if(this.studentList.size() > 7) {
            return true;
        }

        return false;
    }

    /**
     * Prints the current occupancy of the offering
     */
    public int occupancy() {
        return this.studentList.size();
    }
}
