package com.example.fragquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Objects;

public class QuizFragment extends Fragment {


    //private SQLiteHelper dbHelper = new SQLiteHelper(getContext());
    // private MyDB myDB = new MyDB(getContext());
    private Game game = new Game(getContext());

    /*
    Variables for the UI elements of the fragments view
     */
    private Button answerOne;
    private Button answerTwo;
    private Button answerThree;
    private Button answerFour;
    private TextView questionView;
    private TextView progress;

    /*
    Variables for the current question of the quiz
     */
    private Question currentQuestion;
    private String questionText;
    private String progressLabel;
    private String answerOneLabel;
    private String answerTwoLabel;
    private String answerThreeLabel;
    private String answerFourLabel;
    private int correctAnswerIndex;
    private int currentTier;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);

        }

        // game.setQuestions();
        // game.restartQuiz();
        // game.setNewQuestion(1);
        selectQuestionOfTier(1);
        currentQuestion = game.getCurrentQuestion();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }

        updateQuestion();
        updateDisplay(view);


        Button answerOne = view.findViewById(R.id.answerButtonOne);
        answerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion.getCorrectAnswerIndex() == 1 && currentQuestion.getTier() == 5) {
                    finishQuiz(view);
                } else if (currentQuestion.getCorrectAnswerIndex() == 1) {
                    correctAnswer(view);
                } else {
                    wrongAnswer(view);
                }
            }
        });

        Button answerTwo = view.findViewById(R.id.answerButtonTwo);
        answerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion.getCorrectAnswerIndex() == 2 && currentQuestion.getTier() == 5) {
                    finishQuiz(view);
                } else if (currentQuestion.getCorrectAnswerIndex() == 2) {
                    correctAnswer(view);
                } else {
                    wrongAnswer(view);
                }
            }
        });

        Button answerThree = view.findViewById(R.id.answerButtonThree);
        answerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion.getCorrectAnswerIndex() == 3 && currentQuestion.getTier() == 5) {
                    finishQuiz(view);
                } else if (currentQuestion.getCorrectAnswerIndex() == 3) {
                    correctAnswer(view);
                } else {
                    wrongAnswer(view);
                }
            }
        });

        Button answerFour = view.findViewById(R.id.answerButtonFour);
        answerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion.getCorrectAnswerIndex() == 4 && currentQuestion.getTier() == 5) {
                    finishQuiz(view);
                } else if (currentQuestion.getCorrectAnswerIndex() == 4) {
                    correctAnswer(view);
                } else {
                    wrongAnswer(view);
                }
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
    }

    /**
     * Called when the correct answer is selected
     * Gets a new question of a higher difficulty tier
     * Inserts this question in the calls variables to be displayed when the user returns to this
     * fragment
     * Navigates to the answerFragment which let the user know their answer was correct
     *
     * @param view      The fragments view
     */
    private void correctAnswer(@NonNull View view) {
        // game.nextQuestion();
        selectQuestionOfTier(currentTier + 1);
        updateQuestion();

        Navigation.findNavController(view).navigate(R.id.action_quizFragment_to_answerFragment);
    }

    /**
     * Called when the wrong answer is selected
     * Gets a question of tier 1, effectively resetting the quiz
     * Inserts this question in the calls variables to be displayed when the user returns to this
     * Returns the user the the start fragment to start over
     *
     * @param view      The fragments view
     */
    private void wrongAnswer(@NonNull View view) {
        // game.restartQuiz();
        selectQuestionOfTier(1);
        updateQuestion();

        Navigation.findNavController(view).navigate(R.id.action_quizFragment_to_wrongAnswerFragment);
    }

    /**
     * Called when the end of the quiz has been reached
     * Gets a question of tier 1, effectively resetting the quiz
     * Inserts this question in the calls variables to be displayed when the user returns to this
     * Returns the user the the finish fragment to let them know they completed the quiz
     *
     * @param view      The fragments view
     */
    private void finishQuiz(@NonNull View view) {
        // game.restartQuiz();
        selectQuestionOfTier(1);
        updateQuestion();

        Navigation.findNavController(view).navigate(R.id.action_quizFragment_to_finishFragment);
    }

    /**
     * Gets a question from the DB of the specified tier through the MainActivity
     * Sets the question of the global Game object
     *
     * @param tier      int     The tier of the question to be retrieved. Can be between 1 and 5
     */
    private void selectQuestionOfTier(int tier) {
        currentTier = tier;
        Question questionToSelect = ((MainActivity) getActivity()).getNextQuestion(tier);
        game.setQuestion(questionToSelect);
    }

    /**
     * Updates the field variables containing information on the current question
     * The new information is retrieved from the global Game object.
     */
    private void updateQuestion() {
        currentQuestion = game.getCurrentQuestion();
        questionText = game.getCurrentQuestion().getQuestion();
        answerOneLabel = game.getAnswerOne();
        answerTwoLabel = game.getAnswerTwo();
        answerThreeLabel = game.getAnswerThree();
        answerFourLabel = game.getAnswerFour();
        progressLabel = ("Question nr.: " + currentQuestion.getTier());
        correctAnswerIndex = game.getCurrentQuestion().getCorrectAnswerIndex();

    }

    /**
     * Updates the display with the latest question contained in the field variables.
     *
     * @param view      The view of the fragment
     */
    private void updateDisplay(@NonNull View view) {

        questionView = view.findViewById(R.id.questionTextView);
        questionView.setText(currentQuestion.getQuestion());

        progress = view.findViewById(R.id.progressTextView);
        progress.setText(getString(R.string.progressLabel) + currentQuestion.getTier());

        answerOne = view.findViewById(R.id.answerButtonOne);
        answerOne.setText(currentQuestion.getAnswerOne());

        answerTwo = view.findViewById(R.id.answerButtonTwo);
        answerTwo.setText(currentQuestion.getAnswerTwo());

        answerThree = view.findViewById(R.id.answerButtonThree);
        answerThree.setText(currentQuestion.getAnswerThree());

        answerFour = view.findViewById(R.id.answerButtonFour);
        answerFour.setText(currentQuestion.getAnswerFour());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("progress", progressLabel);
        savedInstanceState.putString("question", questionText);
        savedInstanceState.putString("answerOne", answerOneLabel);
        savedInstanceState.putString("answerTwo", answerTwoLabel);
        savedInstanceState.putString("answerThree", answerThreeLabel);
        savedInstanceState.putString("answerFour", answerFourLabel);
        savedInstanceState.putInt("correctAnswerIndex", correctAnswerIndex);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void restoreInstanceState(Bundle savedInstanceState) {
        progressLabel = savedInstanceState.getString("progress");
        questionText = savedInstanceState.getString("question");
        answerOneLabel = savedInstanceState.getString("answerOne");
        answerTwoLabel = savedInstanceState.getString("answerTwo");
        answerThreeLabel = savedInstanceState.getString("answerThree");
        answerFourLabel = savedInstanceState.getString("answerFour");
        correctAnswerIndex = savedInstanceState.getInt("correctAnswerIndex");
    }


}
