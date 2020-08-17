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

    private Context context = this;
    private GameInterface game;

    /**
     * OnCreate set up the database handler sets the view to be the nav host,
     * displaying the initial fragment
     * @param savedInstanceState    The saved state if there is any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
