package com.example.fragquiz;

import org.junit.After;
import org.junit.Before;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * NOT NEEDED; SINCE QUESTION IS ALL GETTERS!
 */
public class TestQuestion {
    StubQuestion question = new StubQuestion();

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }



}
