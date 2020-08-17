package com.example.fragquiz.framework;

import com.example.fragquiz.QuestionImpl;

/**
 * The Game interface
 * Contains information about the current game, such as the current question
 * also allows for access to said question
 * All game logic and changes to it's state should happen through the game interface
 */
public interface GameInterface {
    /**
     * Returns the current question stored in the object
     * @return      Question    The current question
     */
    public QuestionImpl getCurrentQuestion();

    /**
     * Sets the game objects question variable to the next question
     */
    public void setNextQuestion();

    /**
     * Clears the current question so that the game will restart.
     */
    public void restartQuiz();
}
