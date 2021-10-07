package registrationSystem.model;

public class RegistrationModel {
    private StudentModel theStudent;
    private OfferingModel theOffering;
    private char grade;

    public RegistrationModel(StudentModel theStudent, OfferingModel theOffering) {
        this.setTheStudent(theStudent);
        this.setTheOffering(theOffering);
        this.addRegistration();
    }

    public StudentModel getTheStudent() {
        return theStudent;
    }

    public void setTheStudent(StudentModel theStudent) {
        this.theStudent = theStudent;
    }

    public OfferingModel getTheOffering() {
        return theOffering;
    }

    public void setTheOffering(OfferingModel theOffering) {
        this.theOffering = theOffering;
    }

    public char getGrade() {
        return grade;
    }

    private void addRegistration() {
        theStudent.addRegistration(this);
        theOffering.addRegistration(this);
    }
}
