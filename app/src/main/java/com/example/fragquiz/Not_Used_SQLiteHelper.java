package com.example.fragquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
=============================== THIS FILE IS NOT USED =======================================
 */
/**
 * The SQLite helper class
 * Contains information about the db file
 * Connects the the Android SQLiteOpenHelper class for manipulation of SQLite databases
 *
 */
public class Not_Used_SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alcoholdb.db";
    private static final int DATABASE_VERSION = 1;

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

    public Not_Used_SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    /**
     * Creates a new database in the correct format in case this does not exist
     * @param db
     */
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

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
