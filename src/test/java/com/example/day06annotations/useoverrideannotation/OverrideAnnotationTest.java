package com.example.day06annotations.useoverrideannotation;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OverrideAnnotationTest {

    @Test
    void testMakeSound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        Dog dog = new Dog();
        dog.makeSound();

        System.setOut(System.out);

        String expectedOutput = "Dog is barking";

        equals(expectedOutput);
    }
}

