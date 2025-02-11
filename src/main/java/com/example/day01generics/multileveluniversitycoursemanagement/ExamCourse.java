package com.example.day01generics.multileveluniversitycoursemanagement;

public class ExamCourse extends CourseType{
    private String dueDate;

    ExamCourse(String name, String instructorName, String dueDate) {
        super(name, instructorName);
        this.dueDate = dueDate;
    }

    public String getDueDate(){
        return dueDate;
    }

    @Override
    public String toString(){
        return super.toString() + ", Due Date : " + dueDate;
    }
}
