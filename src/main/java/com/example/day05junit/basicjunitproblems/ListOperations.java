package com.example.day05junit.basicjunitproblems;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {
    public void addElement(List<Integer> list, int element) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        return list.size();
    }

    public static void main(String[] args) {
        ListOperations manager = new ListOperations();
        List<Integer> numbers = new ArrayList<>();

        manager.addElement(numbers, 10);
        manager.addElement(numbers, 20);
        manager.addElement(numbers, 30);
        System.out.println("List after adding elements: " + numbers);

        manager.removeElement(numbers, 20);
        System.out.println("List after removing element 20: " + numbers);

        System.out.println("Size of the list: " + manager.getSize(numbers));
    }
}

