package com.example.day06annotations.taskinfocustomannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Aakrati")
    public void completeTask() {
        System.out.println("Task completed successfully!");
    }

    public static void getTaskInfo() {
        try {
            Method method = TaskManager.class.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            } else {
                System.out.println("No TaskInfo annotation found.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
public class TaskInfoCustomAnnotation {
    public static void main(String[] args) {
        TaskManager.getTaskInfo();
    }
}
