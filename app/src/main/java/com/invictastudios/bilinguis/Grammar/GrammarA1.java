package com.invictastudios.bilinguis.Grammar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.R;


public class GrammarA1 extends Fragment {

    private Button personalPronounsButton;
    private Button englishArticlesButton;
    private Button pluralButton;
    private Button demonstrativePronounsButton;
    private Button verbToHaveButton;
    private Button toBeButton;
    private Button verbsButton;
    private Button presentSimpleTenseButton;
    private Button presentContinuousTenseButton;

    public GrammarA1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grammar_a1, container, false);

        personalPronounsButton = view.findViewById(R.id.personal_pronouns_button);
        englishArticlesButton = view.findViewById(R.id.english_articles_button);
        pluralButton = view.findViewById(R.id.plural_button);
        demonstrativePronounsButton = view.findViewById(R.id.demonstrative_button);
        verbToHaveButton = view.findViewById(R.id.to_have_button);
        toBeButton = view.findViewById(R.id.to_be_button);
        verbsButton = view.findViewById(R.id.verbs_button);
        presentSimpleTenseButton = view.findViewById(R.id.present_simple_tense);
        presentContinuousTenseButton = view.findViewById(R.id.present_continuous_tense);

        personalPronounsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 1);
            intent.putExtra("image", false);
            startActivity(intent);
        });

        englishArticlesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 2);
            intent.putExtra("image", false);
            startActivity(intent);
        });

        pluralButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 3);
            intent.putExtra("image", true);
            startActivity(intent);
        });


        demonstrativePronounsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 4);
            intent.putExtra("image", false);
            startActivity(intent);
        });

        verbToHaveButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 5);
            intent.putExtra("image", true);
            startActivity(intent);
        });

        toBeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 6);
            intent.putExtra("image", true);
            startActivity(intent);
        });

        verbsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 7);
            intent.putExtra("image", true);
            startActivity(intent);
        });

        presentSimpleTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 8);
            intent.putExtra("image", true);
            startActivity(intent);
        });

        presentContinuousTenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarSectionSelected.class);
            intent.putExtra("name", 9);
            intent.putExtra("image", true);
            startActivity(intent);
        });


        return view;
    }
}