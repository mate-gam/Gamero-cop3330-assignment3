/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    ArrayList<String> readFile = new ArrayList<>();
    ArrayList<String> newWords = new ArrayList<>();
    void readFile()
    {
        Scanner sc2 = new Scanner(System.in);
        try {
            sc2 = new Scanner(new File("src/main/java/ex46/exercise46_input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                readFile.add(s);
            }
        }
    }
    void findNewWords()
    {
        newWords.add(readFile.get(0)); //initialize
        boolean flag;
        int i = 0;
        for (String s : readFile)
        {
            for (String string : newWords)
            {
                flag = !string.equals(s);
                if (flag)
                    i++;
            }
            if (i== newWords.size())
            {
                newWords.add(s);
            }
            i = 0;
        }
    }
    void repetitionOfNewWords()
    {
        int word;
        for (String s : newWords)
        {
            word = 0;
            for (String string : readFile)
            {
                if (string.equals(s))
                {
                    word++;
                }
            }
            System.out.print(s + ":");
            for (int i = 0; i < word; i++)
                System.out.print("*");
            System.out.println(" ");
        }
    }
    public static void main(String[] args)
    {
        App app = new App();
        app.readFile();
        app.findNewWords();
        app.repetitionOfNewWords();
    }
}
