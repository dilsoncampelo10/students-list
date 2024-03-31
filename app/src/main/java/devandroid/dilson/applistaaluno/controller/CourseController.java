package devandroid.dilson.applistaaluno.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devandroid.dilson.applistaaluno.model.Course;

public class CourseController {
    private List courses;

    public List getCourses() {
        this.courses = new ArrayList<Course>();

        for(String n : Arrays.asList("Java","Android","PHP","Flutter","Laravel","Kotlin")){
            this.courses.add(new Course(n));
        }

        return this.courses;
    }

    public List getCoursesName(){
        ArrayList<String>names = new ArrayList<>();
        for (int i = 0; i < this.courses.size(); i++) {
            Course obj = (Course) getCourses().get(i);
            names.add(obj.getName());
            
        }

        return names;
    }
}
