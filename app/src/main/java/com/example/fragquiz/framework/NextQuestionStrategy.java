package com.example.fragquiz.framework;

import com.example.fragquiz.QuestionImpl;

/**
 * The NextQuestionStrategy
 * Allows for flexibility in how the next question is chosen for the game
 */
public interface NextQuestionStrategy {
    /**
     * Returns the next question for the game
     * @return Question     The next Question object in the game
     */
    public QuestionImpl fetchNextQuestion(QuestionInterface currentQuestion);
}
