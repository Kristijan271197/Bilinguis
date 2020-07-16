package com.invictastudios.bilinguis.Vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.R;

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


    private ImageButton greetingsButton;
    private ImageButton geographyButton;
    private ImageButton colorsButton;
    private ImageButton thingsButton;
    private ImageButton foodButton;
    private ImageButton productsButton;
    private ImageButton homeButton;
    private ImageButton familyButton;
    private ImageButton weatherButton;
    private ImageButton exercisesOneButton;
    private ImageButton exercisesTwoButton;


    public VocabularyA1() {
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocabulary_a1, container, false);

        greetingsButton = view.findViewById(R.id.greetings);
        greetingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", GREETINGS);
            startActivity(intent);
        });

        geographyButton = view.findViewById(R.id.geography);
        geographyButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", GEOGRAPHY);
            startActivity(intent);
        });

        colorsButton = view.findViewById(R.id.colors);
        colorsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", COLORS);
            startActivity(intent);
        });

        thingsButton = view.findViewById(R.id.things);
        thingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", THINGS);
            startActivity(intent);
        });

        foodButton = view.findViewById(R.id.food);
        foodButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FOOD);
            startActivity(intent);
        });

        productsButton = view.findViewById(R.id.products);
        productsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", PRODUCTS);
            startActivity(intent);
        });

        homeButton = view.findViewById(R.id.home);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", HOME);
            startActivity(intent);
        });

        familyButton = view.findViewById(R.id.family);
        familyButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FAMILY);
            startActivity(intent);
        });

        weatherButton = view.findViewById(R.id.weather);
        weatherButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", WEATHER);
            startActivity(intent);
        });

        exercisesOneButton = view.findViewById(R.id.exerciseOneA1);
        exercisesOneButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularyExercises.class);
            intent.putExtra("level", 1);
            intent.putExtra("number", 1);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        exercisesTwoButton = view.findViewById(R.id.exerciseTwoA1);
        exercisesTwoButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularyExercises.class);
            intent.putExtra("level", 1);
            intent.putExtra("number", 2);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        return view;
    }


}