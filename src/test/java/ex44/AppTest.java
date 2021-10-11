/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex44;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class AppTest {

    @Test
    void addValues() throws IOException, ParseException {
        App app = new App();
        String[][] expected = {{"Widget", "25.0", "5"},
                {"Thing", "15.0", "5"},
                {"Doodad", "5.0", "10"}};
        String[][] input = new String[3][3];
        JSONArray ja = app.getJSONArray();
        assertArrayEquals(expected, app.addValues(input, ja));
    }
}