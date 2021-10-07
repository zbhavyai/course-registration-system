package registrationSystem.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseCatalogModel {
    private ArrayList<CourseModel> courseList;

    public ArrayList<CourseModel> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<CourseModel> courseList) {
        this.courseList = courseList;
    }

    public CourseCatalogModel() {
        this.setCourseList(CourseCatalogModel.loadFromFile());
    }

    /**
     * Load the list of courses and their pre-requisites (if any) from the file on
     * the disk to the memory
     *
     * @return ArrayList of type {@link Course}
     */
    private static ArrayList<CourseModel> loadFromFile() {
        ArrayList<CourseModel> allCourses = new ArrayList<>();

        try {
            BufferedReader catalogFile = new BufferedReader(new FileReader("lib/course_catalog.txt"));
            BufferedReader offeringFile;

            String catalogStr = "";
            String offeringStr = "";

            while ((catalogStr = catalogFile.readLine()) != null) {
                // 0 = course, 1..* course pre-requisite
                String[] courses = catalogStr.split(",");

                // create the object of the course
                CourseModel theCourse = new CourseModel(courses[0].split("-")[0].trim(), courses[0].split("-")[1].trim());

                // create the ArrayList of pre-requisite
                ArrayList<CourseModel> preReqList = new ArrayList<>();

                // add the pre-requisite courses to the pre-requisite list
                for (int i = 1; i < courses.length; i++) {
                    preReqList.add(new CourseModel(courses[i].split("-")[0].trim(), courses[i].split("-")[1].trim()));
                }

                // create the ArrayList of course offerings
                ArrayList<OfferingModel> offeringList = new ArrayList<>();

                // add the course offerings to the course offerings list
                offeringFile = new BufferedReader(new FileReader("lib/course_offerings.txt"));

                while ((offeringStr = offeringFile.readLine()) != null) {
                    String[] offering = offeringStr.split(",");

                    // check if offering line read matches the current course line read
                    if (theCourse
                            .equals(new CourseModel(offering[0].split("-")[0].trim(), offering[0].split("-")[1].trim()))) {
                        OfferingModel theOffering = new OfferingModel(Integer.parseInt(offering[1].trim()),
                                Integer.parseInt(offering[2].trim()));
                        theOffering.setTheCourse(theCourse);

                        offeringList.add(theOffering);
                    }

                    else {
                        continue;
                    }
                }

                offeringFile.close();

                // attach the pre-requisite list to the course
                theCourse.setPreReq(preReqList);

                // attach the offering list to the course
                theCourse.setOfferingList(offeringList);

                // add the course (along with its pre-requisite) to the catalog
                allCourses.add(theCourse);
            }

            catalogFile.close();
        }

        catch (FileNotFoundException e) {
            System.err.printf("%n[FAIL] File not found. Cannot proceed further. Bye!%n%n");
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }

        catch (IOException e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(2);
        }

        return allCourses;
    }

    public void listCourses() {
        System.out.println(this);
    }

    public CourseModel searchCatalog(String courseName, String courseNumber) {
        for (CourseModel c : this.courseList) {
            if (c.equals(new CourseModel(courseName, courseNumber))) {
                return c;
            }
        }

        return null;
    }

    public String searchCatalog(String courseName) {
        boolean foundOne = false;

        StringBuilder sb = new StringBuilder();

        for(CourseModel c : this.courseList) {
            if(c.getCourseName().equals(courseName)) {
                sb.append(String.format("%s%n", c.toStringDetailed()));
                foundOne = true;
            }
        }

        if(foundOne) {
            return sb.toString();
        }

        else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (CourseModel c : courseList) {
            sb.append(String.format("%s%n", c.toStringDetailed()));
        }

        return sb.toString();
    }
}
