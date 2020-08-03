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


public class GrammarA1 extends Fragment {

    public static final String EXERCISE_NAME = "exerciseName";
    public static final String EXERCISE_LEVEL = "exerciseLevel";
    public static final String EXERCISE_NUMBER = "exerciseNumber";

    public GrammarA1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grammar_a1, container, false);

        Button personalPronounsButton = view.findViewById(R.id.personal_pronouns_button);
        Button englishArticlesButton = view.findViewById(R.id.english_articles_button);
        Button demonstrativePronounsButton = view.findViewById(R.id.demonstrative_button);
        Button verbToHaveButton = view.findViewById(R.id.to_have_button);
        Button pluralButton = view.findViewById(R.id.plural_button);
        Button verbsButton = view.findViewById(R.id.verbs_button);
        Button presentSimpleTenseButton = view.findViewById(R.id.present_simple_tense);
        Button quantifiersButton = view.findViewById(R.id.quantifiers_button);
        Button toBeButton = view.findViewById(R.id.to_be_button);
        Button presentContinuousTenseButton = view.findViewById(R.id.present_continuous_tense);
        Button exercisesButton = view.findViewById(R.id.exercise_a1_grammar);
        Button testsButton = view.findViewById(R.id.test_a1_grammar);

        personalPronounsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 1);
            intent.putExtra("image", false);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        englishArticlesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 2);
            intent.putExtra("image", false);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        demonstrativePronounsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 4);
            intent.putExtra("image", false);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        verbToHaveButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 5);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        pluralButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 3);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        verbsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 7);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        presentSimpleTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 8);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        quantifiersButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 10);
            intent.putExtra("image", false);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });


        toBeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 6);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        presentContinuousTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra(EXERCISE_NAME, 9);
            intent.putExtra("image", true);
            intent.putExtra(EXERCISE_LEVEL, 1);
            startActivity(intent);
        });

        exercisesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("vocabulary", false);
            intent.putExtra("level", 1);
            startActivity(intent);
        });


        testsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), TestSelection.class);
            intent.putExtra("level", 1);
            intent.putExtra("vocabulary", false);
            startActivity(intent);
        });


        return view;
    }
}