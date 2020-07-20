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


public class ReadingA2 extends Fragment {

    private Button zooButton;
    private Button describingManButton;
    private Button clothesButton;
    private Button describingRoomButton;
    private Button restaurantButton;
    private Button seasonMonthButton;
    private Button cityButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading_a2, container, false);

        zooButton = view.findViewById(R.id.zoo_button);
        describingManButton = view.findViewById(R.id.describing_man_button);
        clothesButton = view.findViewById(R.id.clothes_button);
        describingRoomButton = view.findViewById(R.id.describing_room_button);
        restaurantButton = view.findViewById(R.id.restaurant_button);
        seasonMonthButton = view.findViewById(R.id.season_month_button);
        cityButton = view.findViewById(R.id.city_button);

        zooButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 1);
            startActivity(intent);
        });

        describingManButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 2);
            startActivity(intent);
        });

        clothesButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 3);
            startActivity(intent);
        });

        describingRoomButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 4);
            startActivity(intent);
        });

        restaurantButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 5);
            startActivity(intent);
        });

        seasonMonthButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 6);
            startActivity(intent);
        });

        cityButton.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ReadingSectionSelected.class);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, 2);
            intent.putExtra(GrammarA1.EXERCISE_NAME, 7);
            startActivity(intent);
        });


        return view;
    }
}