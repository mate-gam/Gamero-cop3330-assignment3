/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class App
{
    String[][] jsonFileToStringArray(String[][] array)throws IOException, ParseException
    {
        App app = new App();
        JSONArray ja = app.getJSONArray(); // json array of the products
        array = app.addValues(array, ja);
        return array;
    }

    JSONArray getJSONArray() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject a = (JSONObject) parser.parse // parses the json file
                (new FileReader("src/main/java/ex44/exercise_input.json"));

        JSONArray ja = (JSONArray) a.get("products"); // json array of the products
        return ja;
    }

    String[][] addValues (String[][] array, JSONArray ja)
    {
        int i = 0;
        for (Object c : ja)
        {
            int j = 0;
            JSONObject prod = (JSONObject) c; // Creates new object for each element in array
            array[i][j++] = (String) prod.get("name"); // Adds the Value of the key into 2d array
            array[i][j++] = String.valueOf(prod.get("price"));
            array[i][j] = String.valueOf(prod.get("quantity"));
            i++;
        }
        return array;
    }

    void printStatements(String[][] array)
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        // Loop until gets correct product name
        do
        {
            // gets user input
            System.out.print("What is the product name? ");
            String productName = sc.nextLine();
            for (int i = 0; i < 3; i++)
            {
                if (productName.equals(array[i][0]))
                {
                    // Formatted as output
                    System.out.println("Name: " + array[i][0] +
                            "\nPrice: " + array[i][1] +
                            "\nQuantity: " + array[i][2]);
                    flag = false; //breaks loop
                }
            }
            // Tell user that their product is not in stock/json file
            if (flag)
                System.out.println("Sorry, that product was not found in our inventory");
        }while (flag); //false when correct name
    }

    public static void main(String[] args) throws IOException, ParseException {
        App app = new App();
        String[][] array = new String[3][3];
        array = app.jsonFileToStringArray(array);
        app.printStatements(array);
    }
}
