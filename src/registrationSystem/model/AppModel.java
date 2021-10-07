package registrationSystem.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppModel {
    private static AppModel instanceVar = null;
    private CourseCatalogModel cat;

    private AppModel(CourseCatalogModel cat) {
        this.cat = cat;
        this.loadDummyStudents();
    }

    public static AppModel getInstance(CourseCatalogModel cat) {
        if (instanceVar == null) {
            instanceVar = new AppModel(cat);
        }

        return instanceVar;
    }

    private void loadDummyStudents() {
        try {
            BufferedReader dummyStudentFile = new BufferedReader(new FileReader("lib/dummy_students.txt"));
            String readStudent = "";

            while ((readStudent = dummyStudentFile.readLine()) != null) {
                String[] studentData = readStudent.split(",");

                StudentModel student = new StudentModel(studentData[0].trim(), Integer.parseInt(studentData[1].trim()));

                for (int i = 2; i < studentData.length; i++) {
                    String courseName = studentData[i].trim().split("-")[0];
                    String courseNumber = studentData[i].trim().split("-")[1];
                    int sectionNumber = Integer.parseInt(studentData[i].trim().split("-")[2]);

                    student.registerForCourse(this.cat, courseName, courseNumber, sectionNumber);
                }
            }

            dummyStudentFile.close();
        }

        catch (IOException e) {
            // dont print error. Siliently proceed without dummy students;
        }
    }
}