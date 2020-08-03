package com.invictastudios.bilinguis.Grammar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.Exercises;
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.TestSelection;

public class GrammarA2 extends Fragment {

    public GrammarA2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grammar_a2, container, false);

        Button pluralExceptionsButton = view.findViewById(R.id.plural_exceptions);
        Button verbsButton = view.findViewById(R.id.verbs);
        Button pastSimpleTenseButton = view.findViewById(R.id.past_simple_tense_button);
        Button personalPronounsPartTwoButton = view.findViewById(R.id.personal_pronouns_2_button);
        Button modalVerbsButton = view.findViewById(R.id.modal_verbs_button);
        Button thereIsAreButton = view.findViewById(R.id.there_is_are_button);
        Button futureSimpleTenseButton = view.findViewById(R.id.future_simple_tense_button);
        Button modalsMustButton = view.findViewById(R.id.modals_must_button);
        Button prepositionsOfTimeButton = view.findViewById(R.id.prepositions_of_time_button);
        Button prepositionsOfPlaceButton = view.findViewById(R.id.prepositions_of_place_button);
        Button futureBeGoingToButton = view.findViewById(R.id.future_be_going_to_button);
        Button exercisesButton = view.findViewById(R.id.exercise_a2_grammar);
        Button testsButton = view.findViewById(R.id.test_a2_grammar);

        pluralExceptionsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 1);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        verbsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 2);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        pastSimpleTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 3);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        personalPronounsPartTwoButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 4);
            intent.putExtra("image", false);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        modalVerbsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 5);
            intent.putExtra("image", false);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        thereIsAreButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 6);
            intent.putExtra("image", false);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        futureSimpleTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 7);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        modalsMustButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 8);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        prepositionsOfTimeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 9);
            intent.putExtra("image", false);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        prepositionsOfPlaceButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 10);
            intent.putExtra("image", false);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        futureBeGoingToButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 11);
            intent.putExtra("image", true);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            startActivity(intent);
        });

        exercisesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("vocabulary", false);
            intent.putExtra("level", 2);
            startActivity(intent);
        });

        testsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), TestSelection.class);
            intent.putExtra("level", 2);
            intent.putExtra("vocabulary", false);
            startActivity(intent);
        });

        return view;
    }
}