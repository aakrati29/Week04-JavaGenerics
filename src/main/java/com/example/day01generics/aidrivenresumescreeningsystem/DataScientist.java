package com.example.day01generics.aidrivenresumescreeningsystem;

public class DataScientist extends JobRole{
    public int numberOfCertificate;

    public DataScientist(String name, String degreeStatus, String higherSecondaryPercent, int numberOfCertificate) {
        super(name, degreeStatus, higherSecondaryPercent);
        this.numberOfCertificate = numberOfCertificate;
    }

    @Override
    public String toString(){
        return super.toString() + ", NumberOfCertificate : " + numberOfCertificate;
    }
}
