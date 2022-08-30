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

import com.example.fragquiz.MainActivity;
import com.example.fragquiz.R;
import com.example.fragquiz.SQLite_TierPlusOneNextQStrat;

/**
 * This fragment is used when the wrong answer has been selected.
 * It current only contains the a message saying the answer was wrong,
 * and a navigation to the next question
 */
public class WrongAnswerFragment extends Fragment {


    public WrongAnswerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wrong_answer, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonToNext = view.findViewById(R.id.nextButton);
        if(((MainActivity) getActivity()).getGame().getNextQuestionStrategy().getClass() == SQLite_TierPlusOneNextQStrat.class) {
            buttonToNext.setVisibility(view.INVISIBLE);
        }


        Button buttonToExit = view.findViewById(R.id.exitButton);
        buttonToExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Navigation.findNavController(view).navigate(R.id.action_wrongAnswerFragment_to_startFragment);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        buttonToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
