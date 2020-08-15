package com.example.fragquiz.framework;

import android.database.Cursor;

/**
 * The DataBaseHandler interface
 * Connects to a database of questions
 * Contains functions for setting up the connection to the database and for raw querying
 */
public interface DataBaseHandlerInterface {
    /**
     * This method should set up the connection to the database and open it up.
     * Once the method returns, the database should be ready to be queried
     */
    public void setupDatabase();

    /**
     * Sends a raw query to the database and returns the raw result to be handled by the caller
     * This is in order to allow for greater flexibility in how many questions can be retrieved
     * by a single query.
     * @param query     A valid SQL query
     * @return Cursor   An Android Cursor object containing the result of the SQL query
     */
    public Cursor DatabaseQuery(String query);
}
