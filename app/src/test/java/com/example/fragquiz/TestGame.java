package com.example.fragquiz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestGame {
    private GameImpl game;

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        game = new GameImpl(new StubNextQuestionStrategy());
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldNotReturnNullForCurrentQuestionAtStartUp() {
        assertThat(game.getCurrentQuestion(), is(not(nullValue())));
    }

    @Test
    public void shouldNotReturnNullAfter_setNextQuestion_IsCalled() {
        game.setNextQuestion();
        assertThat(game.getCurrentQuestion(), is(not(nullValue())));
    }
}
