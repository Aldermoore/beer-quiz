package com.example.fragquiz;

/**
 * The Question Interface outlines the main data objects in the game
 * Contains methods for accessing every variable of the object.
 */
public interface QuestionInterface {

    /**
     * Returns the correct answer index
     * NOTE: The fragments expect this to be a one-index, not a zero-index, so answerOne is 1, not 0
     * @return  int     The index of the correct answer
     */
    public int getCorrectAnswerIndex();

    /**
     * Returns the first possible answer in a string
     * @return  String      The string containing the first answer
     */
    public String getAnswerOne();

    /**
     * Returns the second possible answer in a string
     * @return  String      The string containing the second answer
     */
    public String getAnswerTwo();

    /**
     * Returns the third possible answer in a string
     * @return  String      The string containing the third answer
     */
    public String getAnswerThree();

    /**
     * Returns the fourth possible answer in a string
     * @return  String      The string containing the fourth answer
     */
    public String getAnswerFour();

    /**
     * Returns the difficulty tier of the current question
     * Can be between [1 and 5], 1 being easiest, and 5 being hardest
     * @return      int         The difficulty tier
     */
    public int getTier();

}
