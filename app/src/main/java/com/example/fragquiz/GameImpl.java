package com.example.fragquiz;

import com.example.fragquiz.framework.GameInterface;
import com.example.fragquiz.framework.NextQuestionStrategy;

/**
 * Default implementation of the Game Interface
 * The fragments should only need to interface with the implementation of game, and not the
 * underlying classes game uses.
 */
public class GameImpl implements GameInterface {
    private QuestionImpl currentQuestion;
    private NextQuestionStrategy nextQuestionStrategy;

    /**
     * Constructor
     * @param nextQuestionStrategy  The strategy used to retrieve the next question
     */
    public GameImpl(NextQuestionStrategy nextQuestionStrategy) {
        this.nextQuestionStrategy = nextQuestionStrategy;
        setNextQuestion();
    }

    @Override
    public QuestionImpl getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Sets the current question to the next question
     * Can be null if there are no more questions!
     * If currentQuestion is already null, this means that game asks for the first question.
     */
    @Override
    public void setNextQuestion() {
        currentQuestion = nextQuestionStrategy.fetchNextQuestion(currentQuestion);
    }

    /**
     * Restarts the game by setting the currentQuestion to null and setting the next question.
     */
    @Override
    public void restartQuiz() {
        currentQuestion = null;
        setNextQuestion();
    }


}
