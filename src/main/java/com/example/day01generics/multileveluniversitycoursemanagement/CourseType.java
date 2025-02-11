package com.example.day01generics.multileveluniversitycoursemanagement;

abstract class CourseType {
    private String name;
    private String instructorName;

    CourseType(String name, String instructorName){
        this.name = name;
        this.instructorName = instructorName;
    }

    public String getName(){
        return  name;
    }

    public String getInstructorName(){
        return instructorName;
    }

    @Override
    public String toString(){
        return "Name : " + name + ", InstructorName : " + instructorName;
    }
}
