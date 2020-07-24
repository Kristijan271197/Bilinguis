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

public class VocabularyA2 extends Fragment {

    public static final String NATURE = "nature";
    public static final String ANIMALS = "animals";
    public static final String FACE_PARTS = "face_parts";
    public static final String BODY_PARTS = "body_parts";
    public static final String CLOTHES = "clothes";
    public static final String KITCHEN = "kitchen";
    public static final String FURNITURE = "furniture";
    public static final String BEVERAGES = "beverages";
    public static final String TIME = "time";
    public static final String CITY = "city";

    private ImageButton natureButton;
    private ImageButton animalsButton;
    private ImageButton facePartsButton;
    private ImageButton bodyPartsButton;
    private ImageButton clothesButton;
    private ImageButton kitchenButton;
    private ImageButton furnitureButton;
    private ImageButton beveragesButton;
    private ImageButton timeButton;
    private ImageButton cityButton;
    private ImageButton exercisesOneButton;
    private ImageButton exercisesTwoButton;
    private ImageButton exercisesThreeButton;
    private ImageButton testsButton;

    public VocabularyA2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocabulary_a2, container, false);

        natureButton = view.findViewById(R.id.nature);
        animalsButton = view.findViewById(R.id.animals);
        facePartsButton = view.findViewById(R.id.face_parts);
        bodyPartsButton = view.findViewById(R.id.body_parts);
        clothesButton = view.findViewById(R.id.clothes);
        kitchenButton = view.findViewById(R.id.kitchen);
        furnitureButton = view.findViewById(R.id.furniture);
        beveragesButton = view.findViewById(R.id.beverages);
        timeButton = view.findViewById(R.id.time);
        cityButton = view.findViewById(R.id.city);
        exercisesOneButton = view.findViewById(R.id.exerciseOneA2);
        exercisesTwoButton = view.findViewById(R.id.exerciseTwoA2);
        exercisesThreeButton = view.findViewById(R.id.exerciseThreeA2);
        testsButton = view.findViewById(R.id.testA2Vocabulary);

        natureButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", NATURE);
            startActivity(intent);
        });


        animalsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", ANIMALS);
            startActivity(intent);
        });


        facePartsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FACE_PARTS);
            startActivity(intent);
        });


        bodyPartsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", BODY_PARTS);
            startActivity(intent);
        });


        clothesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", CLOTHES);
            startActivity(intent);
        });


        kitchenButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", KITCHEN);
            startActivity(intent);
        });


        furnitureButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", FURNITURE);
            startActivity(intent);
        });


        beveragesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", BEVERAGES);
            startActivity(intent);
        });


        timeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", TIME);
            startActivity(intent);
        });


        cityButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), VocabularySectionSelected.class);
            intent.putExtra("section", CITY);
            startActivity(intent);
        });


        exercisesOneButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("level", 2);
            intent.putExtra("number", 1);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });


        exercisesTwoButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("level", 2);
            intent.putExtra("number", 2);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });


        exercisesThreeButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), Exercises.class);
            intent.putExtra("level", 2);
            intent.putExtra("number", 3);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });


        testsButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), TestSelection.class);
            intent.putExtra("level", 2);
            intent.putExtra("vocabulary", true);
            startActivity(intent);
        });

        return view;
    }
}