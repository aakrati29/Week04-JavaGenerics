package com.example.day06annotations.createandusearepeatableannotation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class RepeatableAnnotationTest {

    @Test
    void testBugReportAnnotations() throws NoSuchMethodException {
        Method method = BugTracker.class.getMethod("processBugs");

        assertTrue(method.isAnnotationPresent(BugReports.class));

        BugReports bugReports = method.getAnnotation(BugReports.class);

        assertEquals(2, bugReports.value().length);

        assertEquals("Null pointer exception in edge case", bugReports.value()[0].description());
        assertEquals("Aakrati", bugReports.value()[0].reportedBy());

        assertEquals("UI layout issue on mobile", bugReports.value()[1].description());
        assertEquals("Ram", bugReports.value()[1].reportedBy());
    }
}

