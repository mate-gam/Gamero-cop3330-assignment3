/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex42;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void sizeOfArray()
    {
        App app = new App();
        ArrayList<String> checkSize = new ArrayList<>();
        checkSize.add("Ling,Mai,55900");
        int[] stringValues = new int[3];
        int[] size = {4,3,5};
        assertArrayEquals(size, app.sizeOfArray(checkSize, 0, stringValues));

        checkSize = new ArrayList<>();
        checkSize.add("Zarnecki,Sabrina,51500");
        stringValues = new int[3];
        int[] sizeSecond = {8,7,5};
        assertArrayEquals(sizeSecond, app.sizeOfArray(checkSize, 0, stringValues));
    }
}