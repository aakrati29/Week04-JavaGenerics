package com.example.day01generics.multileveluniversitycoursemanagement;

import java.util.List;

public class Main {
    static void print(List<? extends CourseType> course){
        course.forEach(System.out::println);

    }
    public static void main(String[] args) {
        Course<AssignmentCourse> assignment = new Course<>();
        assignment.addCourse(new AssignmentCourse("Array", "Aakrati", "20-03-2025"));
        assignment.addCourse(new AssignmentCourse("String", "Ram", "18-03-2025"));

        Course<ExamCourse> examCourse = new Course<>();
        examCourse.addCourse(new ExamCourse("Java", "Ankit", "25-03-2025"));
        examCourse.addCourse(new ExamCourse("C++", "Avinash", "20-03-2025"));

        Course<ResearchCourse> researchCourse = new Course<>();
        researchCourse.addCourse(new ResearchCourse("SpringBoat", "Anand", "1-04-2025"));

        print(assignment.getAllProducts());
        print(examCourse.getAllProducts());
        print(researchCourse.getAllProducts());
    }
}
