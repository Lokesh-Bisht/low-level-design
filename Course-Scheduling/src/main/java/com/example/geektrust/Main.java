/**
 * Author: Lokesh Bisht
 */
package com.example.geektrust;

import com.example.geektrust.service.OperationsService;
import com.example.geektrust.service.impl.OperationsServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static void getInput(String filePath) {
        OperationsService operationsService = OperationsServiceImpl.getInstance();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                //Add your code here to process input commands
                String data = sc.nextLine();
                String[] input = data.split(" ");
                operationsService.performOperations(input);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println("Error occurred  while reading the input: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getInput(args[0]);
    }
}
