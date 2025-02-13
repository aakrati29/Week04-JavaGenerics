package com.example.day02collection.listinterface.reversealist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Reverse {
    public static <T> LinkedList<T> reverseByLinkedList(LinkedList<T> ll) {
        LinkedList<T> tempList = new LinkedList<>();
        for(T i : ll){
            tempList.addFirst(i);
        }
        ll.clear();
        ll.addAll(tempList);
        return ll;
    }

    static ArrayList<Integer> reverseByArrayList(int[] input) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = input.length; i > 0; i--){
            list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5};
        ArrayList<Integer> result = reverseByArrayList(input);
        System.out.println("Reverse by ArrayList : " + result);
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println("Reverse by LinkedList : "+reverseByLinkedList(ll));
    }
}
