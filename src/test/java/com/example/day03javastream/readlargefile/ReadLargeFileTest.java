package com.example.day03javastream.readlargefile;

import com.example.day03javastreams.readlargefile.ReadLargeFile;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadLargeFileTest {

    @Test
    void testReadAndFilterFile() throws IOException {
        // Create a temporary test file
        File tempFile = File.createTempFile("test_large_file", ".txt");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("This is a normal line\n");
            writer.write("Something went wrong, ERROR occurred!\n");
            writer.write("Another issue: error detected in module\n");
        }

        // Capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call method
        ReadLargeFile.readAndFilterFile(tempFile.getAbsolutePath());

        // Restore System.out
        System.setOut(System.out);

        // Verify output contains only "error" lines
        String output = outputStream.toString().toLowerCase();
        assertTrue(output.contains("error occurred"));
        assertTrue(output.contains("error detected"));
        assertTrue(!output.contains("normal line")); // Should not be printed
    }
}

