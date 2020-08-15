package com.example.fragquiz;

import com.example.fragquiz.framework.GameInterface;
import com.example.fragquiz.framework.NextQuestionStrategy;

public class GameImpl implements GameInterface {
    private QuestionImpl currentQuestion;
    private NextQuestionStrategy nextQuestionStrategy;

    public GameImpl(NextQuestionStrategy nextQuestionStrategy) {
        this.nextQuestionStrategy = nextQuestionStrategy;

        setNextQuestion();
    }

    @Override
    public QuestionImpl getCurrentQuestion() {
        return currentQuestion;
    }

    @Override
    public void setNextQuestion() {
        currentQuestion = nextQuestionStrategy.fetchNextQuestion(currentQuestion);
    }

    @Override
    public void restartQuiz() {
        currentQuestion = null;
        setNextQuestion();
    }


}
