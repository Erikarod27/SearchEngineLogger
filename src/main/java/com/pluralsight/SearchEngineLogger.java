package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Log launching the application
        logAction("launch", "logs.txt");

        while(true) {
            System.out.print("Enter a search term (X to exit): ");
            String searchTerm = scanner.nextLine();
            if (searchTerm.equalsIgnoreCase("x")) {
                logAction("exit", "logs.txt");
                break;
            } else {
                logAction("search : " + searchTerm, "logs.txt");
            }
        }
        scanner.close();
    }

    private static void logAction(String action, String logFile) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = formattedDateTime + " " + action;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logEntry +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
