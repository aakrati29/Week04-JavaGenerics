package com.example.day01generics.aidrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

public class Resume <T extends JobRole>{
    List<T> list = new ArrayList<>();

    public void addCandidate(T candidate){
        list.add(candidate);
    }

    public List<T> getAllCandidates(){
        return list;
    }
}
