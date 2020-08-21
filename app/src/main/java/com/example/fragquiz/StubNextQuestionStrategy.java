package com.example.fragquiz;

import com.example.fragquiz.framework.NextQuestionStrategy;
import com.example.fragquiz.framework.QuestionInterface;

public class StubNextQuestionStrategy implements NextQuestionStrategy {
    @Override
    public QuestionImpl fetchNextQuestion(QuestionInterface currentQuestion) {
        return new QuestionImpl("question", "AnswerOne", "AnswerTwo",
                "AnswerThree", "AnswerFour", 1, 1);
    }
}
