package com.example.day06annotations.cachingsystemwithcacheresult;

public class Main {
    public static void main(String[] args) {
        ExpensiveComputation computation = CacheProxy.create(new ExpensiveComputationImplementation(), ExpensiveComputation.class);

        System.out.println("First Call : " + computation.compute(5));
        System.out.println("Second Call : " + computation.compute(5));
        System.out.println("Third Call : " + computation.compute(10));
        System.out.println("Fourth Call : " + computation.compute(10));
    }
}

