package com.example.day06reflection.customloggingproxyusingreflection;

public class GreetingImplementation implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
