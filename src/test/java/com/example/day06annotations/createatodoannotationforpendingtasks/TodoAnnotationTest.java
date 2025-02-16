package com.example.day06annotations.createatodoannotationforpendingtasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TaskManagerTest {

    @Test
    void testTodoAnnotations() {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        int count = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);

                if (method.getName().equals("implementAuth")) {
                    assertEquals("Implement user authentication", annotation.task());
                    assertEquals("Ram", annotation.assignedTo());
                    assertEquals("HIGH", annotation.priority());
                } else if (method.getName().equals("optimizeDB")) {
                    assertEquals("Optimize database queries", annotation.task());
                    assertEquals("Aakrati", annotation.assignedTo());
                    assertEquals("MEDIUM", annotation.priority());
                } else if (method.getName().equals("addLogging")) {
                    assertEquals("Add logging functionality", annotation.task());
                    assertEquals("Ankit", annotation.assignedTo());
                    assertEquals("LOW", annotation.priority());
                }
                count++;
            }
        }

        assertEquals(3, count);
    }
}
