package com.example.day01generics.aidrivenresumescreeningsystem;

abstract class JobRole {
    private String name;
    private String degreeStatus;
    private String higherSecondaryPercent;

    public JobRole(String name, String degreeStatus, String higherSecondaryPercent){
        this.name = name;
        this.degreeStatus = degreeStatus;
        this.higherSecondaryPercent = higherSecondaryPercent;
    }

    @Override
    public String toString(){
        return "Name : " + name +", DegreeStatus : " + degreeStatus + ", HigherSecondaryPercent : " + higherSecondaryPercent;
    }

}
