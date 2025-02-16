package com.example.day06reflection.customloggingproxyusingreflection;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImplementation();

        Greeting proxyGreeting = LoggingProxyHandler.createProxy(greeting, Greeting.class);

        String message = proxyGreeting.sayHello("Aakrati");

        System.out.println("Returned message : " + message);
    }
}

