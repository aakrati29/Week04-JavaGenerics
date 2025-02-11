package com.example.day01generics.aidrivenresumescreeningsystem;

import java.util.List;

public class Main {
    static void getList(List<? extends JobRole> jobRole){
        jobRole.forEach(System.out::println);
    }
    public static void main(String[] args) {
    Resume<DataScientist> dataScientistResume = new Resume<>();
    dataScientistResume.addCandidate(new DataScientist("Aakrati", "Under Graduate", "85%", 4));
    dataScientistResume.addCandidate(new DataScientist("Ankit", "Post Graduate", "80%", 5));

    Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>();
    softwareEngineerResume.addCandidate(new SoftwareEngineer("Ram", "Post Graduate", "90%", 3));
    softwareEngineerResume.addCandidate(new SoftwareEngineer("Anand", "Under Graduate", "80%", 2));

    Resume<ProductManager> productManagerResume = new Resume<>();
    productManagerResume.addCandidate(new ProductManager("Avinash", "Post Graduate", "80%", 3));
    productManagerResume.addCandidate(new ProductManager("Aditi", "Under Graduate", "75%", 0));

    System.out.println("\n-----------Data Scientist-------------");
    getList(dataScientistResume.getAllCandidates());

    System.out.println("\n-----------Software Engineer-------------");
    getList(softwareEngineerResume.getAllCandidates());

    System.out.println("\n-----------Product Manager-------------");
    getList(productManagerResume.getAllCandidates());
    }
}
