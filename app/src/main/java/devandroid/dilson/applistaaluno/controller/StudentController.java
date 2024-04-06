package devandroid.dilson.applistaaluno.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import devandroid.dilson.applistaaluno.database.StudentListDB;
import devandroid.dilson.applistaaluno.model.Student;
import devandroid.dilson.applistaaluno.view.MainActivity;

public class StudentController extends StudentListDB {

    SharedPreferences preferences;
    public static final String PREFERENCE_NAME = "students_list";
    SharedPreferences.Editor studentList;

    public StudentController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(PREFERENCE_NAME, 0);
        studentList = preferences.edit();
    }

    public void save(Student student) {
        ContentValues contentValues = new ContentValues();
        studentList.putString("firstName", student.getFirstName());
        studentList.putString("lastName", student.getLastName());
        studentList.putString("courseName", student.getCourseName());
        studentList.putString("numberCod", student.getNumberCod());
        studentList.apply();
        contentValues.put("firstName",student.getFirstName());
        contentValues.put("lastName",student.getLastName());
        contentValues.put("courseName",student.getCourseName());
        contentValues.put("numberCod",student.getNumberCod());

        create("students",contentValues);


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
