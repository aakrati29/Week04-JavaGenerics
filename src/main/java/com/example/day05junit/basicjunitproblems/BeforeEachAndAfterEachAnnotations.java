package com.example.day05junit.basicjunitproblems;

// BeforeEach And AfterEach Annotations for "DataBase"
public class BeforeEachAndAfterEachAnnotations {
    private boolean isConnected;

    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return isConnected;
    }

    public static void main(String[] args) {
        BeforeEachAndAfterEachAnnotations db = new BeforeEachAndAfterEachAnnotations();

        db.connect();
        System.out.println("Is connected? " + db.isConnected());

        db.disconnect();
        System.out.println("Is connected? " + db.isConnected());
    }
}

