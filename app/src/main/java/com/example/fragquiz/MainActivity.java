package com.example.fragquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.fragquiz.framework.GameInterface;

/**
 * Main activity for the Quiz app
 * Sets up the fragments and views
 */
public class MainActivity extends AppCompatActivity {
    // private Not_Used_SQLiteHelper db = new Not_Used_SQLiteHelper(this);

    private MyDB database; // The database handler


    /**
     * OnCreate set up the database handler sets the view to be the nav host,
     * displaying the initial fragment
     * @param savedInstanceState    The saved state if there is any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new MyDB(this);
    }

    /**
     * Returns the database handler object
     * @return  MyDB    The DB handler object
     */
    public MyDB getDatabase() {
        return database;
    }

    /**
     * Returns a Question object with the specified difficulty tier
     * The question is retireved via the database handler
     * @param tier  int     The difficulty of the question. Can be [1-5]
     * @return  Question    A question object with the specified difficulty tier.
     */
    public Question getNextQuestion(int tier) {
        return database.getOneQuestionOfDifficulty(tier);
    }




    private Context context = this;
    private GameInterface game;

    public GameInterface getGame() {
        return game;
    }

    public Context getContext() {
        return context;
    }

    public void startGame(Context context) {
        game = new GameImpl(new SQLite_TierPlusOneNextQStrat(new SQLiteDatabaseHandler(context)));
    }
}
