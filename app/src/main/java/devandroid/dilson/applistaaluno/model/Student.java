package devandroid.dilson.applistaaluno.model;

public class Student {
    private String firstName;
    private String lastName;
    private String courseName;
    private String numberCod;

    public Student(){

    }

    public Student(String firstName, String lastName, String courseName, String numberCod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.numberCod = numberCod;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numberCod='" + numberCod + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getNumberCod() {
        return numberCod;
    }

    public void setNumberCod(String numberCod) {
        this.numberCod = numberCod;
    }
}
