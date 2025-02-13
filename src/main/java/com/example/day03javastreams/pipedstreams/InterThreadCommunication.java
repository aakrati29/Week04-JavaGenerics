package com.example.day03javastreams.pipedstreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            // Create shared piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create threads for writing and reading
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            // Start threads
            writerThread.start();
            readerThread.start();

            // Wait for threads to complete
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable {
    private final PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            // Write data
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i + "\n";
                pos.write(message.getBytes());
                System.out.println("Writer: " + message);
                Thread.sleep(1000); // Simulate some processing time
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Reader implements Runnable {
    private final PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            // Read data
            int data;
            StringBuilder receivedData = new StringBuilder();
            while ((data = pis.read()) != -1) {
                receivedData.append((char) data);
            }
            System.out.println("Reader received:\n" + receivedData.toString());
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

