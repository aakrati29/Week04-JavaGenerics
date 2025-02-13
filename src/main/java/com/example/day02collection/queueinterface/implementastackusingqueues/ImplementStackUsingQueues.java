package com.example.day02collection.queueinterface.implementastackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class  ImplementStackUsingQueues<T>{
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    public void push(T x) {
        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return q1.poll();
    }

    public T top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}

