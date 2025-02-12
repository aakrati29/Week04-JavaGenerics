package com.example.day02collection.listinterface.rotateelementsinalist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElement {
    private static void rotateElement(List<Integer> input, int k) {
        int n = input.size();
        k= k % n;

        List<Integer> result = new ArrayList<>(input.subList(k,n));
        result.addAll(input.subList(0,k));
        input.clear();
        input.addAll(result);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        rotateElement(list,2);
        System.out.println("List after rotation : " + list);
    }
}
