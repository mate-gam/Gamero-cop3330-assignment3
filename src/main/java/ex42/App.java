/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    ArrayList<String> names = new ArrayList<>();
    char[] lastName;
    char[] firstName;
    char[] salary;

    ArrayList<String> readFile ()
    {
        ArrayList<String> names = new ArrayList<>();
        try
        {
            File myObj = new File("src/main/java/ex42/exercise42_input.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                names.add(i, data);
                i++;
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
    int[] sizeOfArray (ArrayList<String> arrayList, int i, int[] stringValues)
    {
        int counterOfLastName = 0, commaCounter = 0, counterOfFirstName = 0, counterOfSalary = 0;
        for (int j = 0; j < arrayList.get(i).length() && commaCounter != 1; j++) {
            if (",".compareTo(String.valueOf(arrayList.get(i).charAt(j))) != 0 && commaCounter == 0) {
                counterOfLastName++;
            } else {
                commaCounter++;
            }
        }
        for (int j = counterOfLastName+1; j < arrayList.get(i).length() && commaCounter != 2; j++) {
            if (",".compareTo(String.valueOf(arrayList.get(i).charAt(j))) != 0 && commaCounter == 1) {
                counterOfFirstName++;
            } else {
                commaCounter++;
            }
        }
        for (int j = counterOfFirstName+counterOfLastName+2; j < arrayList.get(i).length() && commaCounter != 3; j++) {
            if (",".compareTo(String.valueOf(arrayList.get(i).charAt(j))) != 0 && commaCounter == 2) {
                counterOfSalary++;
            } else {
                commaCounter++;
            }
        }
        stringValues = new int[]{counterOfLastName, counterOfFirstName, counterOfSalary};
        return stringValues;
    }
    void printValues(char[] last, char[] first, char[] sal)
    {
        String lastName = String.valueOf(last);
        String firstName = String.valueOf(first);
        String salary = String.valueOf(sal);
        System.out.format("%-9s %-9s %-9s\n", lastName, firstName, salary);
    }

    void parseArray (int[] stringValues, ArrayList<String> names)
    {
        App app = new App();
        for (int i = 0; i < names.size(); i++)
        {
            stringValues = app.sizeOfArray(names, i, stringValues);
            this.lastName = new char[stringValues[0]];
            this.firstName = new char[stringValues[1]];
            this.salary = new char[stringValues[2]];
            int j = 0;
            for (; j < stringValues[0]; j++)
            {
                this.lastName[j] = names.get(i).charAt(j);
            }
            j++;
            for (int k = 0; k < stringValues[1]; k++)
            {
                this.firstName[k] = names.get(i).charAt(j++);
            }
            int c = 0;
            j++;
            for (; c < stringValues[2]; c++)
            {
                this.salary[c] = names.get(i).charAt(j++);
            }
            app.printValues(this.lastName, this.firstName, this.salary);
        }
    }
    
    public static void main (String[] args)
    {
        App app = new App();
        ArrayList<String> names = new ArrayList<>();
        names = app.readFile();
        int[] stringValues = new int[3];
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");
        app.parseArray(stringValues, names);
    }
}
