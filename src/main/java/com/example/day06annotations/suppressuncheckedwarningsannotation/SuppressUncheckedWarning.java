package com.example.day06annotations.suppressuncheckedwarningsannotation;

import java.util.ArrayList;
import java.util.List;

class UncheckedWarning{

    @SuppressWarnings("unchecked")
    public void createAList(){
        List list = new ArrayList<>();
        list.add("Aakrati");
        list.add('A');
        list.add(3);

        System.out.println("The list is : " + list);
    }
}

public class SuppressUncheckedWarning {
    public static void main(String[] args) {
        UncheckedWarning uncheckedWarning = new UncheckedWarning();
        uncheckedWarning.createAList();

    }
}
