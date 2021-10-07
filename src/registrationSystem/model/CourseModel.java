package registrationSystem.model;

import java.util.ArrayList;

public class CourseModel {
    private String courseName;
    private String courseNumber;
    private ArrayList<CourseModel> preReq;
    private ArrayList<OfferingModel> offeringList;

    public CourseModel(String courseName, String courseNumber) {
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
        preReq = new ArrayList<CourseModel>();
        offeringList = new ArrayList<OfferingModel>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public ArrayList<CourseModel> getPreReq() {
        return preReq;
    }

    public void setPreReq(ArrayList<CourseModel> preReq) {
        this.preReq = preReq;
    }

    public ArrayList<OfferingModel> getOfferingList() {
        return offeringList;
    }

    public void setOfferingList(ArrayList<OfferingModel> offeringList) {
        this.offeringList = offeringList;
    }

    public void addOffering(OfferingModel theOffering) {
        offeringList.add(theOffering);
    }

    @Override
    public String toString() {
        return String.format("%s-%s", this.getCourseName(), this.getCourseNumber());
    }

    @Override
    public boolean equals(Object obj) {
        CourseModel compareCourse = (CourseModel) obj;

        if (compareCourse.getCourseName().equals(this.getCourseName())
                && compareCourse.getCourseNumber().equals(this.getCourseNumber())) {
            return true;
        }

        return false;
    }

    public OfferingModel searchOffering(int sectionNumber) {
        for (OfferingModel o : this.getOfferingList()) {
            if (o.getSectionNumber() == sectionNumber) {
                return o;
            }
        }

        return null;
    }

    /**
     * Returns a String containing course name-number, its pre-requisites, and its
     * offerings
     *
     * @return String containing course name-number, its pre-requisites, and its
     *         offerings
     */
    public String toStringDetailed() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.toString());

        if (preReq.size() == 0) {
            sb.append("  PreRequisite(s): None");
        }

        else {
            sb.append("  PreRequisite(s): ");

            for (CourseModel preReqCourse : preReq) {
                sb.append(preReqCourse + " ");
            }
        }

        if (offeringList.size() == 0) {
            sb.append(String.format("%n          Not offered%n"));
        }

        else {
            sb.append(String.format("%n          Offerings:%n"));

            for (OfferingModel offering : offeringList) {
                sb.append(String.format("            Section: %d, Capacity: %d/%d%n", offering.getSectionNumber(),
                        offering.occupancy(), offering.getSectionCapacity()));
            }
        }

        return sb.toString();
    }
}
