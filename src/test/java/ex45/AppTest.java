/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Mateo Gamero
 */
package ex45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void containsUtilize()
    {
        App app = new App();
        assertTrue(app.containsUtilize("utilizes"));
        assertTrue(app.containsUtilize("utilize"));
        assertFalse(app.containsUtilize("util"));
        assertFalse(app.containsUtilize("use"));
        assertFalse(app.containsUtilize("UTILIZ"));
    }
}