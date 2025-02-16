package com.example.day06annotations.usedeprecated;

class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("Warning: This feature is deprecated.");
    }

    public void newFeature(){
        System.out.println("This is the new and improved feature.");
    }
}
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();
        legacyAPI.oldFeature();
        legacyAPI.newFeature();
    }
}
