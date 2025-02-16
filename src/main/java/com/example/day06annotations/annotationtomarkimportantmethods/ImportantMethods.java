package com.example.day06annotations.annotationtomarkimportantmethods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ApplicationService {

    @ImportantMethod(level = "HIGH")
    public void processCriticalData() {
        System.out.println("Processing critical data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void normalMethod() {
        System.out.println("This is a normal method.");
    }

    public static void getImportantMethods() {
        Method[] methods = ApplicationService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName());
                System.out.println("Level: " + annotation.level());
                System.out.println("------------------------------------");
            }
        }
    }
}

public class ImportantMethods {
    public static void main(String[] args) {
        ApplicationService.getImportantMethods();
    }
}
