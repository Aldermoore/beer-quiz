package com.example.fragquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.fragquiz.R;

/**
 * This fragment is used when the correct answer has been selected.
 * It current only contains the a message saying the answer was correct,
 * and a navigation to the next question
 */
public class AnswerFragment extends Fragment {

    public AnswerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonToNextQuestion = view.findViewById(R.id.nextButton);
        buttonToNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                // Navigation.findNavController(view).navigate(R.id.action_answerFragment_to_quizFragment);
            }
        });

        Button buttonToExit = view.findViewById(R.id.exitButton);
        buttonToExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Navigation.findNavController(view).navigate(R.id.action_answerFragment_to_startFragment);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
