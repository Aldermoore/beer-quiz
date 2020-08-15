package com.example.fragquiz;

import android.database.Cursor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestSQLiteDataBaseHandler {
    private SQLiteDatabaseHandler dbHandler;

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

    @Test
    public void shouldReturnRawQuery() {
        // Cursor results = dbHandler.DatabaseQuery("SELECT * FROM AlcoholQestions ORDER BY random() LIMIT 1");
        // assertThat(results, is(not(nullValue())));
    }
}
