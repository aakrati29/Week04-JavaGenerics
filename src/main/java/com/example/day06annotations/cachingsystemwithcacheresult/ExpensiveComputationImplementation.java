package com.example.day06annotations.cachingsystemwithcacheresult;

public class ExpensiveComputationImplementation implements ExpensiveComputation {

    @CacheResult
    public int compute(int value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * value;
    }
}

