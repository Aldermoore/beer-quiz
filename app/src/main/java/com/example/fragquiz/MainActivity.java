package com.example.fragquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private SQLiteHelper db = new SQLiteHelper(this);
    private MyDB database;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new MyDB(this);
    }

    public MyDB getDatabase() {
        return database;
    }

    public Question getNextQuestion(int tier) {
        return database.getOneQuestionOfDifficulty(tier);
    }
}
