package com.example.fragquiz;

import com.example.fragquiz.framework.NextQuestionStrategy;
import com.example.fragquiz.framework.QuestionInterface;

public class SQLite_50QuestionsNextQStrat implements NextQuestionStrategy {
    @Override
    public QuestionImpl fetchNextQuestion(QuestionInterface currentQuestion) {
        return null;
    }
}
