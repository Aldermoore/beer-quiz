package com.example.fragquiz;

import com.example.fragquiz.framework.QuestionInterface;

public class QuestionImpl implements QuestionInterface {
    private int correctAnswerIndex;
    private String answerOne;
    private int difficultyTier;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String question;

    public QuestionImpl(String question, String answerOne, String answerTwo, String answerThree, String answerFour, int correctIndex, int difficultyTier)
    {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        correctAnswerIndex = correctIndex;
        this.difficultyTier = difficultyTier;
    }

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
