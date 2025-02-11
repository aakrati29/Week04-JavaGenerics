package com.example.day01generics.multileveluniversitycoursemanagement;

import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType>{
    List<T> list = new ArrayList<>();

    public void addCourse(T course){
        list.add(course);
    }

    public List<T> getAllProducts() {
        return list;
    }
}
