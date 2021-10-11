/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    ArrayList<String> readFile = new ArrayList<>();
    ArrayList<String> writeFile = new ArrayList<>();

    void writeFile()
    {
        try {
            // File Writer to write
            FileWriter myWriter = new FileWriter("src/main/java/ex45/exercise45_output.txt");
            int i = 0;
            // Loops through writeFile Array
            for (String s : writeFile) {
                // Write to file
                myWriter.write(s + " ");
                i++;
                // New line after 12 words
                if (i % 12 == 0)
                    myWriter.write("\n");
            }
            myWriter.close(); // Closes File
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Creates the File for output
    void createFile()
    {
        //Check if file already exists
        try {
            File myObj = new File("src/main/java/ex45/exercise45_output.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());// created
            } else {
                System.out.println("File already exists."); //exists
            }
        //Error check
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Changes utilize with use
    void changeFile()
    {
        App app = new App();
        // Loop through the read File
        for (String s : readFile) {
            if (app.containsUtilize(s)) {
                // Changes the first use of utilize with use
                String newTemp = s.replaceFirst("utilize", "use");
                // Writes to file
                this.writeFile.add(newTemp);
            } else {
                // not utilize
                this.writeFile.add(s);
            }
        }
    }
    // Checks for the word utilize
    boolean containsUtilize(String word)
    {
        return word.contains("utilize");
    }
    // Reads in the file word by word and adds it to the array
    void readFile()
    {
        Scanner sc2 = new Scanner(System.in);
        try {
            sc2 = new Scanner(new File("src/main/java/ex45/exercise45_input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                //s is the next word
                String s = s2.next();
                this.readFile.add(s);
            }
        }
    }
    public static void main (String[] args)
    {
        App app = new App();
        app.readFile();
        app.changeFile();
        app.createFile();
        app.writeFile();
    }
}
