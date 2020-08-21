package com.example.fragquiz;

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

/**
 * This fragment is used when the user has completed the quiz
 * Has navigation to start over, or return the the start screen
 */
public class FinishFragment extends Fragment {
    public FinishFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView correctQuestions = view.findViewById(R.id.correctlyQuestionsTextView);
        int answeredQuestions = (((MainActivity) getActivity()).getGame().getCorrectlyAnsweredQuestions());
        correctQuestions.setText(answeredQuestions+"");


        Button buttonToExit = view.findViewById(R.id.exitButton);
        buttonToExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Navigation.findNavController(view).navigate(R.id.action_finishFragment_to_startFragment);
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
