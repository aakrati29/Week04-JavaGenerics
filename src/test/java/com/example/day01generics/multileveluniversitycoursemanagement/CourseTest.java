package com.example.day01generics.multileveluniversitycoursemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course<AssignmentCourse> assignmentCourse;
    private Course<ExamCourse> examCourse;
    private Course<ResearchCourse> researchCourse;

    @BeforeEach
    void setUp() {
        assignmentCourse = new Course<>();
        examCourse = new Course<>();
        researchCourse = new Course<>();
    }

    @Test
    void testAddAssignmentCourse() {
        AssignmentCourse course = new AssignmentCourse("Array", "Aakrati", "20-03-2025");
        assignmentCourse.addCourse(course);

        List<AssignmentCourse> courses = assignmentCourse.getAllProducts();
        assertEquals(1, courses.size());
        assertEquals(course, courses.get(0));
    }

    @Test
    void testAddExamCourse() {
        ExamCourse course = new ExamCourse("Java", "Ankit", "25-03-2025");
        examCourse.addCourse(course);

        List<ExamCourse> courses = examCourse.getAllProducts();
        assertEquals(1, courses.size());
        assertEquals(course, courses.get(0));
    }

    @Test
    void testAddResearchCourse() {
        ResearchCourse course = new ResearchCourse("SpringBoot", "Anand", "01-04-2025");
        researchCourse.addCourse(course);

        List<ResearchCourse> courses = researchCourse.getAllProducts();
        assertEquals(1, courses.size());
        assertEquals(course, courses.get(0));
    }

    @Test
    void testPrintCourses() {
        assignmentCourse.addCourse(new AssignmentCourse("Array", "Aakrati", "20-03-2025"));
        assignmentCourse.addCourse(new AssignmentCourse("String", "Ram", "18-03-2025"));

        examCourse.addCourse(new ExamCourse("Java", "Ankit", "25-03-2025"));
        examCourse.addCourse(new ExamCourse("C++", "Avinash", "20-03-2025"));

        researchCourse.addCourse(new ResearchCourse("SpringBoot", "Anand", "01-04-2025"));

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.print(assignmentCourse.getAllProducts());
            Main.print(examCourse.getAllProducts());
            Main.print(researchCourse.getAllProducts());

            String actualOutput = outputStream.toString().trim();
            System.setOut(originalOut);  // Restore console output

            String expectedOutput = """
                    Name : Array, InstructorName : Aakrati, Due Date : 20-03-2025
                    Name : String, InstructorName : Ram, Due Date : 18-03-2025
                    Name : Java, InstructorName : Ankit, Due Date : 25-03-2025
                    Name : C++, InstructorName : Avinash, Due Date : 20-03-2025
                    Name : SpringBoot, InstructorName : Anand, Due Date : 01-04-2025
            """.trim();

            assertEquals(expectedOutput.replaceAll("\\s+", " "), actualOutput.replaceAll("\\s+", " "));
        } finally {
            System.setOut(originalOut); // Ensure console is restored even if an exception occurs
        }
    }
}

