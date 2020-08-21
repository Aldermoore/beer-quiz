package com.example.fragquiz;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;

import com.example.fragquiz.framework.NextQuestionStrategy;
import com.example.fragquiz.framework.QuestionInterface;

public class SQLite_TierPlusOneNextQStrat implements NextQuestionStrategy {

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

    public SQLite_TierPlusOneNextQStrat(SQLiteDatabaseHandler sqLiteDatabaseHandler) {
        databaseHandler = sqLiteDatabaseHandler;
    }

    /**
     * Fetches a single random question with a tier of 1 higher than the input.
     * If the input is null, the fetched questions tier is 1.
     * @return
     */
    @Override
    public QuestionImpl fetchNextQuestion(QuestionInterface currentQuestion) {
        QuestionImpl questionToReturn;
        int difficulty = 1; // defaults to one, so a question can always be retrieved.
        if(currentQuestion == null) {
            difficulty = 1;
        } else if(currentQuestion.getTier()<=5){
            difficulty = currentQuestion.getTier()+1;
        } else if(currentQuestion.getTier() <= 5){
            return null;
        }
        String query = "SELECT * FROM AlcoholQestions WHERE DifficultyTier ="+difficulty+" ORDER BY random() LIMIT 1";
        Cursor res = databaseHandler.DatabaseQuery(query);
        res.moveToNext(); // Moves to the next entry, since the cursor starts at index -1 :-/
        // Inserts the values from the cursor into a new QuestionImpl object
        if (res != null) {
            try {
                questionToReturn = new QuestionImpl(
                        res.getString(res.getColumnIndex(QUESTION_COLUMN)),
                        res.getString(res.getColumnIndex(ANSWER_ONE_COLUMN)),
                        res.getString(res.getColumnIndex(ANSWER_TWO_COLUMN)),
                        res.getString(res.getColumnIndex(ANSWER_THREE_COLUMN)),
                        res.getString(res.getColumnIndex(ANSWER_FOUR_COLUMN)),
                        res.getInt(res.getColumnIndex(CORRECT_INDEX_COLUMN)),
                        res.getInt(res.getColumnIndex(DIFFICULTY_TIER)));
            } catch (CursorIndexOutOfBoundsException e) {
                return null;
            }

        } else {
            // Returns an empty question in case res is empty ( has not happened, yet)
            questionToReturn = new QuestionImpl("Q", "1", "2", "3", "4", 1, 2);
        }
        res.close(); // Closes the cursor.
        return questionToReturn;
    }
}
