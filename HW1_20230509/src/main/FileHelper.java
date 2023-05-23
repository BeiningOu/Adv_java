package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileHelper {
    // Method to read the content of a file and return it as a string
    public static String readFileAsString(String filePath) throws FileReadException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line of the file and append it to the content
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            // If an IOException occurs, wrap it in a custom exception and throw it
            throw new FileReadException("Error occurred while reading the file.", e);
        }

        return content.toString();
    }

    // Method to append content to a file
    public static void appendToFile(String content) throws FileWriteException {
        String currentPath = Paths.get("").toAbsolutePath().toString();
        // Build the file path by appending the relative path to the current directory
        String filePath = currentPath + "/src/main/prompts_to_start.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(content);
        } catch (IOException e) {
            // If an IOException occurs, wrap it in a custom exception and throw it
            throw new FileWriteException("Error occurred while writing to the file.", e);
        }
    }

    public static void writeToFile(String content) throws FileWriteException {
        String currentPath = Paths.get("").toAbsolutePath().toString();
        // Build the file path by appending the relative path to the current directory
        String filePath = currentPath + "/src/main/last_question.txt";
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(content);
        } catch (IOException e) {
            // If an IOException occurs, wrap it in a custom exception and throw it
            throw new FileWriteException("Error occurred while writing to the file.", e);
        }
    }






    public static void main(String[] args) throws IOException {
        // Get the absolute path of the current directory
        String currentPath = Paths.get("").toAbsolutePath().toString();
        // Build the file path by appending the relative path to the current directory
        String filePath = currentPath + "/src/main/prompts_to_start.txt";
        System.out.println(filePath);

        try {
            // Read the content of the file using the file path
            String fileContent = readFileAsString(filePath);
            System.out.println("File Content:\n" + fileContent);

            // Append new content to the file
            String newContent = "This is a new line.\n";
            appendToFile(newContent);
            System.out.println("Content successfully appended to the file.");
        } catch (FileReadException | FileWriteException e) {
            // If a FileReadException or FileWriteException occurs, print the error message and stack trace
            System.out.println("Error occurred while handling the file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the file in the final block to ensure it is closed after writing
            try {
                FileWriter writer = new FileWriter(filePath, true);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing the file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // User-defined exception for file reading errors
    public static class FileReadException extends Exception {
        public FileReadException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // User-defined exception for file writing errors
    public static class FileWriteException extends Exception {
        public FileWriteException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
