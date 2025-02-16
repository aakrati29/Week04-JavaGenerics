package com.example.day06reflection.accessandmodifystaticfields;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

