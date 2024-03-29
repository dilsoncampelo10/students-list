package devandroid.dilson.applistaaluno.controller;

import android.content.SharedPreferences;

import devandroid.dilson.applistaaluno.model.Student;
import devandroid.dilson.applistaaluno.view.MainActivity;

public class StudentController {

    SharedPreferences preferences;
    public static final String PREFERENCE_NAME = "students_list";
    SharedPreferences.Editor studentList;

    public StudentController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(PREFERENCE_NAME, 0);
        studentList = preferences.edit();
    }

    public void save(Student student) {
        studentList.putString("firstName", student.getFirstName());
        studentList.putString("lastName", student.getLastName());
        studentList.putString("courseName", student.getCourseName());
        studentList.putString("numberCod", student.getNumberCod());
        studentList.apply();
    }

    public void clear() {
        studentList.clear();
        studentList.apply();
    }

    public void getData(Student student) {
        student.setFirstName(preferences.getString("firstName", ""));
        student.setLastName(preferences.getString("lastName", ""));
        student.setCourseName(preferences.getString("courseName", ""));
        student.setNumberCod(preferences.getString("numberCod", ""));

    }


}
