/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void readFile()
    {
        App app = new App();
        ArrayList<String> readFileArray = new ArrayList<>();
        ArrayList<String> inputFile = new ArrayList<>();
        inputFile.add("Ling, Mai");
        inputFile.add("Johnson, Jim");
        inputFile.add("Zarnecki, Sabrina");
        inputFile.add("Jones, Chris");
        inputFile.add("Jones, Aaron");
        inputFile.add("Swift, Geoffrey");
        inputFile.add("Xiong, Fong");
        assertEquals(inputFile, app.readFile(readFileArray));
    }

    @Test
    void sortArray()
    {
        App app = new App();
        ArrayList<String> inputFile = new ArrayList<>();
        inputFile.add("Ling, Mai");
        inputFile.add("Johnson, Jim");
        inputFile.add("Zarnecki, Sabrina");
        inputFile.add("Jones, Chris");
        inputFile.add("Jones, Aaron");
        inputFile.add("Swift, Geoffrey");
        inputFile.add("Xiong, Fong");
        ArrayList<String> outputFile = new ArrayList<>();
        outputFile.add("Johnson, Jim");
        outputFile.add("Jones, Aaron");
        outputFile.add("Jones, Chris");
        outputFile.add("Ling, Mai");
        outputFile.add("Swift, Geoffrey");
        outputFile.add("Xiong, Fong");
        outputFile.add("Zarnecki, Sabrina");
        app.numberOfNames = 7;
        assertEquals(outputFile, app.sortArray(inputFile, app.numberOfNames));
    }
}