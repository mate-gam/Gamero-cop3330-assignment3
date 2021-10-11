/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex41;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class App
{
    int numberOfNames = 0;
    //This function reads in the file exercise41_input.txt and adds the values to global arrayList
    ArrayList<String> readFile (ArrayList<String> names)
    {
        try
        {
            File myObj = new File("src/main/java/ex41/exercise41_input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                names.add(this.numberOfNames, data);//index is number of names
                this.numberOfNames++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return names;
    }
    //Function sorts the values one by one using nested for loop
    ArrayList<String> sortArray(ArrayList<String> names, int numberOfNames)
    {
        numberOfNames = this.numberOfNames;
        String temp;
        for (int i = 0; i < numberOfNames; i++)
        {
            for (int j = i + 1; j < numberOfNames; j++)
            {
                if (names.get(i).compareTo(names.get(j)) > 0)//compares the two values returns 1 if greater
                {
                    temp = names.get(i);//temps to switch values
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }
        return names;
    }
    //File must be created for this to work does not create it
    void writeToOutputFile(ArrayList<String> names)
    {
        try {
            FileWriter myWriter = new FileWriter("src/main/java/ex41/exercise41_output.txt");
            //write to file the total number of names
            myWriter.write("Total of " + this.numberOfNames + " names\n-----------------\n" );
            //for loop to print the names
            for (int i  = 0; i < this.numberOfNames; i++)
            {
                myWriter.write(names.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main (String[] args)
    {
        App app = new App();
        ArrayList<String> names = new ArrayList<>();
        names = app.readFile(names);
        int num = 0;
        names = app.sortArray(names, num);
        app.writeToOutputFile(names);
    }
}
