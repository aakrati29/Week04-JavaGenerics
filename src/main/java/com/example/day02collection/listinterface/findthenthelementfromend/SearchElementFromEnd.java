package com.example.day02collection.listinterface.findthenthelementfromend;

import java.util.Iterator;
import java.util.LinkedList;

public class SearchElementFromEnd {
    private static <T> T searchElementFromEnd(LinkedList<T> ll, int n) {

        Iterator<T> fast = ll.iterator();
        Iterator<T> slow = ll.iterator();
        for(int i=0;i<n;i++){
            if(fast.hasNext()){
                fast.next();
            }else{
                return null;
            }
        }

        while(fast.hasNext()){
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('D');
        ll.add('E');
        System.out.println(searchElementFromEnd(ll, 3));
    }
}
