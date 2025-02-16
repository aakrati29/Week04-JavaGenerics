package com.example.day06annotations.createandusearepeatableannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
    String reportedBy();
}

class BugTracker {

    @BugReport(description = "Null pointer exception in edge case", reportedBy = "Aakrati")
    @BugReport(description = "UI layout issue on mobile", reportedBy = "Ram")
    public void processBugs() {
        System.out.println("Processing reported bugs...");
    }

    public static void getBugReports() {
        try {
            Method method = BugTracker.class.getMethod("processBugs");

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.reportedBy());
                    System.out.println("----------------------------------------");
                }
            } else {
                System.out.println("No bug reports found.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) {
        BugTracker.getBugReports();
    }
}

