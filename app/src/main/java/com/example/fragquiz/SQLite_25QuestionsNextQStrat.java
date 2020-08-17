package com.example.fragquiz;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;

import com.example.fragquiz.framework.NextQuestionStrategy;
import com.example.fragquiz.framework.QuestionInterface;

import java.util.ArrayList;

public class SQLite_25QuestionsNextQStrat implements NextQuestionStrategy {

    private SQLiteDatabaseHandler databaseHandler;
    /*
    Field variables pertaining to the specific database file and structure
     */
    public static final String DATABASE_NAME = "alcoholdb.db";
    public static final String TABLE_NAME = "AlcoholQestions";
    public static final String QUESTION_COLUMN = "Question";
    public static final String ANSWER_ONE_COLUMN = "Answer1";
    public static final String ANSWER_TWO_COLUMN = "Answer2";
    public static final String ANSWER_THREE_COLUMN = "Answer3";
    public static final String ANSWER_FOUR_COLUMN = "Answer4";
    public static final String CORRECT_INDEX_COLUMN = "CorrectAnswer";
    public static final String DIFFICULTY_TIER = "DifficultyTier";

    private ArrayList<QuestionImpl> questions;
    private int currentQuestionNumber = 0;

    public SQLite_25QuestionsNextQStrat(SQLiteDatabaseHandler sqLiteDatabaseHandler) {
        databaseHandler = sqLiteDatabaseHandler;
    }

    /**
     * Fetches 25 questions of random order from the database and places them in the 'questions'
     * arraylist and returns the first.
     * If the arraylist is already populated, the function iterates over all questions, until it
     * reaches the end.
     * @param currentQuestion
     * @return
     */
    @Override
    public QuestionImpl fetchNextQuestion(QuestionInterface currentQuestion) {
        QuestionImpl questionToReturn = null;
        if (currentQuestionNumber >= 25) {
            return null;
        }
        if (questions == null) {
            questions = new ArrayList();
            String query = "SELECT * FROM AlcoholQestions ORDER BY random() LIMIT 25";
            Cursor res = databaseHandler.DatabaseQuery(query);

            if (res != null) {
                try {
                    // Adds all 25 questions to the arraylist
                    for (int i = 0; i < 25; i++) {
                        res.moveToNext();
                        questions.add(
                                new QuestionImpl(
                                        res.getString(res.getColumnIndex(QUESTION_COLUMN)),
                                        res.getString(res.getColumnIndex(ANSWER_ONE_COLUMN)),
                                        res.getString(res.getColumnIndex(ANSWER_TWO_COLUMN)),
                                        res.getString(res.getColumnIndex(ANSWER_THREE_COLUMN)),
                                        res.getString(res.getColumnIndex(ANSWER_FOUR_COLUMN)),
                                        res.getInt(res.getColumnIndex(CORRECT_INDEX_COLUMN)),
                                        res.getInt(res.getColumnIndex(DIFFICULTY_TIER)))
                        );

                    }
                } catch (CursorIndexOutOfBoundsException e) {
                    return null;
                }
                res.close();
            }
        }
        questionToReturn = questions.get(currentQuestionNumber);
        currentQuestionNumber++;
        return questionToReturn;
    }
}
