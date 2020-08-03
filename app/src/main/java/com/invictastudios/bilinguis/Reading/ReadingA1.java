package com.invictastudios.bilinguis.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.Grammar.GrammarA1;
import com.invictastudios.bilinguis.R;


public class ReadingA1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading_a1, container, false);

        Button greetingsButton = view.findViewById(R.id.greetings_button);
        Button inSchoolButton = view.findViewById(R.id.in_school_button);
        Button inTheMarketButton = view.findViewById(R.id.in_the_market_button);
        Button homeFamilyButton = view.findViewById(R.id.home_family_button);
        Button ourDayButton = view.findViewById(R.id.our_day_button);

        greetingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 1);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 1);
            startActivity(intent);
        });

        inSchoolButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 1);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 2);
            startActivity(intent);
        });

        inTheMarketButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 1);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 3);
            startActivity(intent);
        });

        homeFamilyButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 1);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 4);
            startActivity(intent);
        });

        ourDayButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 1);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 5);
            startActivity(intent);
        });


        return view;
    }
}