/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex43;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    String siteName, siteAuthor, siteJS, siteCSS;
    void getInputs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Site name: ");
        this.siteName = sc.nextLine();
        System.out.print("Author: ");
        this.siteAuthor = sc.nextLine();
        System.out.print("Do you want a folder for Javascript? ");
        this.siteJS = sc.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        this.siteCSS = sc.nextLine();
        System.out.println(siteJS);
    }

    void makeDirectory()
    {
        App app = new App();
        File f;
        boolean bool;
        String path = "src/main/java/ex43/website/" + this.siteName;
        try {

            // returns path names for files and directory
            f = new File(path);

            // create directories
            bool = f.mkdirs();

            // print
            System.out.println("Created ./website/"+this.siteName);

        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
        // adds the files under path directory
        app.addFiles(path, this.siteJS, this.siteCSS);
    }

    void addFiles(String path, String js, String css)
    {
        File f;
        boolean bool;
        try {
            File myObj = new File(path + "/index.html");
            // creates file if not created already
            if (myObj.createNewFile()) {
                System.out.println("Created ./website/" + this.siteName + "/index.html");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            // if error occurs
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // adds javascript directory if user needed
        if (js.equals("y"))
        {
            try {

                // returns path names for files and directory
                f = new File(path + "/js");

                // create directories
                bool = f.mkdirs();

                // print
                System.out.print("Created ./website/"+ this.siteName + "/js/");

            } catch(Exception e) {
                // if any error occurs
                e.printStackTrace();
            }
        }
        // adds css directory if user needed
        if (css.equals("y"))
        {
            try {

                // returns path names for files and directory
                f = new File(path + "/css");

                // create directories
                bool = f.mkdirs();

                // print
                System.out.print("Created ./website/"+ this.siteName + "/css/");

            } catch(Exception e) {
                // if any error occurs
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args)
    {
        App app = new App();
        app.getInputs();
        app.makeDirectory();
    }
}
