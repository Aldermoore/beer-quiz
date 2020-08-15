package com.example.fragquiz;

import com.example.fragquiz.framework.NextQuestionStrategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestTierPlusOneQStrat {
    SQLite_TierPlusOneNextQStrat nextQuestionStrategy;

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        NextQuestionStrategy nextQuestionStrategy = new SQLite_TierPlusOneNextQStrat();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldReturnQuestionObjectWithValues() {
        //QuestionImpl fetchedQuestion = nextQuestionStrategy.fetchNextQuestion(new StubQuestion());
        //assertThat(fetchedQuestion.getQuestion(), is(not(nullValue())));

    }

}
