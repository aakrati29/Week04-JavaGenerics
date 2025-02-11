package com.example.day01generics.multileveluniversitycoursemanagement;

public class ResearchCourse extends CourseType{
    private String dueDate;

    ResearchCourse(String name, String instructorName, String dueDate) {
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
