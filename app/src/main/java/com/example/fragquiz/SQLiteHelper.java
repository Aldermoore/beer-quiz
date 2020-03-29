package com.example.fragquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alcoholdb.db";
    private static final String TABLE_NAME = "AlcoholQestions";
    private static final String QUESTION_COLUMN = "Question";
    private static final String ANSWER_ONE_COLUMN = "Answer1";
    private static final String ANSWER_TWO_COLUMN = "Answer2";
    private static final String ANSWER_THREE_COLUMN = "Answer3";
    private static final String ANSWER_FOUR_COLUMN = "Answer4";
    private static final String CORRECT_INDEX_COLUMN = "CorrectAnswer";
    private static final String DIFFICULTY_TIER = "DifficultyTier";

    private final Context mContext;
    private SQLiteDatabase db;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mContext = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                QUESTION_COLUMN + " TEXT PRIMARY KEY, " +
                ANSWER_ONE_COLUMN + " TEXT NOT NULL, " +
                ANSWER_TWO_COLUMN + " TEXT NOT NULL, " +
                ANSWER_THREE_COLUMN + " TEXT NOT NULL, " +
                ANSWER_FOUR_COLUMN + " TEXT NOT NULL, " +
                CORRECT_INDEX_COLUMN + " INTEGER," +
                DIFFICULTY_TIER + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Question getOneQuestionOfDifficulty(int difficulty) {
        // SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM AlcoholQestions WHERE DifficultyTier ="+difficulty+" ORDER BY random() LIMIT 1", null );
        String question = res.getString(0);
        String answer1 = res.getString(1);
        String answer2 = res.getString(2);
        String answer3 = res.getString(3);
        String answer4 = res.getString(4);
        String correctAnswer = res.getString(5);
        String difficultyTier = res.getString(6);

        System.out.println(question);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(correctAnswer);
        System.out.println(difficultyTier);
        Question questionToReturn = new Question(res.getString(0), res.getString(1),res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getInt(6));
        return questionToReturn;
    }

    public void open() {
        db = getReadableDatabase();
    }
}
