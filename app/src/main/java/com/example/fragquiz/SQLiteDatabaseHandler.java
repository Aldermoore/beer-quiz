package com.example.fragquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fragquiz.framework.DataBaseHandlerInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * The SQLiteDatabaseHandler class
 * allows access to the SQLite database (currently only one db)
 * Responsible for retrieving the raw query from the database
 */
public class SQLiteDatabaseHandler implements DataBaseHandlerInterface {

    private SQLiteDatabase database;
    private Context context;

    /**
     * Constructor
     * Sets up the SQlite helper and sets up and opens the database
     * @param context
     */
    public SQLiteDatabaseHandler(Context context) {
        this.context = context;
        setupDatabase();
        String name = "alcoholdb.db";
        String path = context.getDatabasePath(name).getPath();
        database = SQLiteDatabase.openDatabase((path), null, 0);
    }

    /**
     * Sets up the database from the db file.
     * Is only really needed for the first launch, or if the database has been altered
     */
    @Override
    public void setupDatabase() {
        //get context by calling "this" in activity or getActivity() in fragment
        //call this if API level is lower than 17
        // String appDataPath = "/data/data/" + context.getPackageName() + "/databases/"
        String appDataPath = context.getApplicationInfo().dataDir;

        File dbFolder = new File(appDataPath + "/databases");//Make sure the /databases folder exists
        dbFolder.mkdir();//This can be called multiple times.

        File dbFilePath = new File(appDataPath + "/databases/alcoholdb.db");

        try {
            InputStream inputStream = context.getAssets().open("alcoholdb.db");
            OutputStream outputStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e){
            //handle
        }
    }

    @Override
    public Cursor DatabaseQuery(String query) {
        Cursor results = database.rawQuery( query, new String[] {});
        return results;
    }
}

