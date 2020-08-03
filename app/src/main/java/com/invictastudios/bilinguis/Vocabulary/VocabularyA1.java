package com.invictastudios.bilinguis.Vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.Exercises;
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.TestSelection;

public class VocabularyA1 extends Fragment {

    public static final String GREETINGS = "greetings";
    public static final String GEOGRAPHY = "geography";
    public static final String COLORS = "colors";
    public static final String THINGS = "things";
    public static final String FOOD = "food";
    public static final String PRODUCTS = "products";
    public static final String HOME = "home";
    public static final String FAMILY = "family";
    public static final String WEATHER = "weather";


    public VocabularyA1() {
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocabulary_a1, container, false);

        ImageButton greetingsButton = view.findViewById(R.id.greetings);
        greetingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", GREETINGS);
            startActivity(intent);
        });

        ImageButton geographyButton = view.findViewById(R.id.geography);
        geographyButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", GEOGRAPHY);
            startActivity(intent);
        });

        ImageButton colorsButton = view.findViewById(R.id.colors);
        colorsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", COLORS);
            startActivity(intent);
        });

        ImageButton thingsButton = view.findViewById(R.id.things);
        thingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", THINGS);
            startActivity(intent);
        });

        ImageButton foodButton = view.findViewById(R.id.food);
        foodButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FOOD);
            startActivity(intent);
        });

        ImageButton productsButton = view.findViewById(R.id.products);
        productsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", PRODUCTS);
            startActivity(intent);
        });

        ImageButton homeButton = view.findViewById(R.id.home);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", HOME);
            startActivity(intent);
        });

        ImageButton familyButton = view.findViewById(R.id.family);
        familyButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FAMILY);
            startActivity(intent);
        });

        ImageButton weatherButton = view.findViewById(R.id.weather);
        weatherButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", WEATHER);
            startActivity(intent);
        });

        ImageButton exercisesOneButton = view.findViewById(R.id.exerciseOneA1);
        exercisesOneButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("level", 1);
            intent.putExtra("number", 1);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        ImageButton exercisesTwoButton = view.findViewById(R.id.exerciseTwoA1);
        exercisesTwoButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("level", 1);
            intent.putExtra("number", 2);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        ImageButton testsButton = view.findViewById(R.id.testA1Vocabulary);
        testsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), TestSelection.class);
            intent.putExtra("level", 1);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        return view;
    }


}