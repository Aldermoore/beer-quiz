package com.example.fragquiz;

import com.example.fragquiz.framework.QuestionInterface;

import org.apache.tools.ant.types.resources.Difference;

public class StubQuestion implements QuestionInterface {
    private int correctAnswerIndex = 1;
    private String answerOne = "one";
    private int difficultyTier = 2;
    private String answerTwo = "two";
    private String answerThree = "three";
    private String answerFour = "four";
    private String question = "Is this a question?";

/*
    public StubQuestion(String question, String answerOne, String answerTwo, String answerThree, String answerFour, int correctIndex, int difficultyTier)
    {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        correctAnswerIndex = correctIndex;
        this.difficultyTier = difficultyTier;
    }

 */

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    @Override
    public String getAnswerOne() {
        return answerOne;
    }

    @Override
    public String getAnswerTwo() {
        return answerTwo;
    }

    @Override
    public String getAnswerThree() {
        return answerThree;
    }

    @Override
    public String getAnswerFour() {
        return answerFour;
    }

    @Override
    public int getTier() {
        return difficultyTier;
    }
}
