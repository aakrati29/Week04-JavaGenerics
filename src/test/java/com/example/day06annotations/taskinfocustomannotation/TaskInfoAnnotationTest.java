package com.example.day06annotations.taskinfocustomannotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TaskInfoAnnotationTest {

    @Test
    void testTaskInfoAnnotation() throws NoSuchMethodException {
        Method method = TaskManager.class.getMethod("completeTask");

        Assertions.assertTrue(method.isAnnotationPresent(TaskInfo.class));

        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        Assertions.assertEquals("High", taskInfo.priority());
        Assertions.assertEquals("Aakrati", taskInfo.assignedTo());
    }
}

