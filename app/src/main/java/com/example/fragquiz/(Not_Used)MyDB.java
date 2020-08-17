package com.example.fragquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** NO LONGER USED
 * The MyDB class
 * allows access to the SQLite database
 * Contains functions for retrieving questions from the database
 */
/*
public class MyDB {
   // private SQLiteHelper dbHelper;

    private SQLiteDatabase database;

    public static final String DATABASE_NAME = "alcoholdb.db";
    public static final String TABLE_NAME = "AlcoholQestions";
    public static final String QUESTION_COLUMN = "Question";
    public static final String ANSWER_ONE_COLUMN = "Answer1";
    public static final String ANSWER_TWO_COLUMN = "Answer2";
    public static final String ANSWER_THREE_COLUMN = "Answer3";
    public static final String ANSWER_FOUR_COLUMN = "Answer4";
    public static final String CORRECT_INDEX_COLUMN = "CorrectAnswer";
    public static final String DIFFICULTY_TIER = "DifficultyTier";
    private Context context;

 */

    /**
     * Constructor
     * Sets up the SQlite helper and sets up and opens the database
     * @param context
     */
    /*
    public MyDB(Context context) {
        // dbHelper = new SQLiteHelper(context);
        this.context = context;
        // database = dbHelper.getReadableDatabase();
        setupDatabase();
        String name = "alcoholdb.db";
        String path = context.getDatabasePath(name).getPath();
        database = SQLiteDatabase.openDatabase((path), null, 0);
    }

     */

    /**
     * Returns a random Question object from the database with the specified difficulty tier
     * Since all queries are random, duplicate entries can occur for the same tier
     * @param difficulty    int     The difficulty tier can be 1-5
     * @return  Question    The Question object to return
     */
    /*
    public Question getOneQuestionOfDifficulty(int difficulty) {
        String question = null;
        String answer1 = null;
        String answer2 = null;
        String answer3 = null;
        String answer4 = null;
        String correctAnswer = null;
        String difficultyTier = null;
        Question questionToReturn = null;
        Cursor res = database.rawQuery( "SELECT * FROM AlcoholQestions WHERE DifficultyTier ="+difficulty+" ORDER BY random() LIMIT 1", new String[] {});
        /*
        if( res != null && res.moveToFirst() ){
            question = res.getString(res.getColumnIndex(QUESTION_COLUMN));
            answer1 = res.getString(res.getColumnIndex(ANSWER_ONE_COLUMN));
            answer2 = res.getString(2);
            answer3 = res.getString(3);
            answer4 = res.getString(4);
            correctAnswer = res.getString(5);
            difficultyTier = res.getString(6);
        }

     */
        /*
        System.out.println("The value of the cursor");
        System.out.println(res.toString());
        System.out.println(question);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(correctAnswer);
        System.out.println(difficultyTier);
         */
        /*
        if( res != null && res.moveToFirst() ) {
            questionToReturn = new Question(res.getString(res.getColumnIndex(QUESTION_COLUMN)),
                    res.getString(res.getColumnIndex(ANSWER_ONE_COLUMN)),
                    res.getString(res.getColumnIndex(ANSWER_TWO_COLUMN)),
                    res.getString(res.getColumnIndex(ANSWER_THREE_COLUMN)),
                    res.getString(res.getColumnIndex(ANSWER_FOUR_COLUMN)),
                    res.getInt(res.getColumnIndex(CORRECT_INDEX_COLUMN)),
                    res.getInt(res.getColumnIndex(DIFFICULTY_TIER)));
        }
        res.close();
        return questionToReturn;
    }

         */

    /**
     * Sets up the database from the db file.
     * Is only really needed for the first launch, or if the database has been altered
     */
    /*
    public void setupDatabase() {
        //get context by calling "this" in activity or getActivity() in fragment
        //call this if API level is lower than 17  String appDataPath = "/data/data/" + context.getPackageName() + "/databases/"
        String appDataPath = context.getApplicationInfo().dataDir;

        File dbFolder = new File(appDataPath + "/databases");//Make sure the /databases folder exists
        dbFolder.mkdir();//This can be called multiple times.

        File dbFilePath = new File(appDataPath + "/databases/alcoholdb.db");

        try {
            InputStream inputStream = context.getAssets().open("alcoholdb.db");
            OutputStream outputStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0)
            {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e){
            //handle
        }
    }
}

     */
