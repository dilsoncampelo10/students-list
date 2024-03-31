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
}
