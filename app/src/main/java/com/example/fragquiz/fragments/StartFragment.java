package com.example.fragquiz.fragments;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.fragquiz.MainActivity;
import com.example.fragquiz.R;


public class StartFragment extends Fragment {

    private Context context = this.getContext();
    /**
     * The first fragment, loaded by the MainActivity upon launch.
     */
    public StartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startpage, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ToggleButton gamemodeToggle = view.findViewById(R.id.gamemodeToggle);

        Button buttonToQuestion = view.findViewById(R.id.startButton);
        buttonToQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamemodeToggle.isChecked()){
                    // Gamemode is 25 in a row
                    ((MainActivity) getActivity()).start25InARow(((MainActivity) getActivity()).getContext());
                } else {
                    // gamemode is strikeout
                    ((MainActivity) getActivity()).startStrikeout(((MainActivity) getActivity()).getContext());
                }
                try {
                    Navigation.findNavController(view).navigate(R.id.action_startFragment_to_quizFragment);
                } catch (Exception e) {System.out.println(e);};
            }
        });

    }

}
