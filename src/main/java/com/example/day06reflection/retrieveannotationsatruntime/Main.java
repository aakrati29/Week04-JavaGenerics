package com.example.day06reflection.retrieveannotationsatruntime;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> clazz = AnnotatedClass.class;

            if (clazz.isAnnotationPresent(Author.class)) {
                Author authorAnnotation = clazz.getAnnotation(Author.class);

                System.out.println("Author Name : " + authorAnnotation.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
