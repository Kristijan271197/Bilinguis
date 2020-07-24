package com.invictastudios.bilinguis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TestSelection extends AppCompatActivity {

    private Button firstExercise;
    private Button secondExercise;
    private Button thirdExercise;
    private Button fourthExercise;
    private Button fifthExercise;
    private Button sixthExercise;
    private int level;
    private boolean vocabulary;
    boolean grammarA1TestOne;
    boolean grammarA1TestTwo;
    boolean grammarA1TestThree;
    boolean grammarA1TestFour;
    boolean grammarA1TestFive;
    boolean grammarA2TestOne;
    boolean grammarA2TestTwo;
    boolean grammarA2TestThree;
    boolean grammarA2TestFour;
    boolean grammarA2TestFive;
    boolean grammarA2TestSix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selector);

        firstExercise = findViewById(R.id.first_exercise);
        secondExercise = findViewById(R.id.second_exercise);
        thirdExercise = findViewById(R.id.third_exercise);
        fourthExercise = findViewById(R.id.fourth_exercise);
        fifthExercise = findViewById(R.id.fifth_exercise);
        sixthExercise = findViewById(R.id.sixth_exercise);


        SharedPreferences sharedPreferences = getSharedPreferences(Tests.LEVELS_UNLOCK, Context.MODE_PRIVATE);
        grammarA1TestOne = sharedPreferences.getBoolean("GrammarA1One", false);
        grammarA1TestTwo = sharedPreferences.getBoolean("GrammarA1Two", false);
        grammarA1TestThree = sharedPreferences.getBoolean("GrammarA1Three", false);
        grammarA1TestFour = sharedPreferences.getBoolean("GrammarA1Four", false);
        grammarA1TestFive = sharedPreferences.getBoolean("GrammarA1Five", false);
        grammarA2TestOne = sharedPreferences.getBoolean("GrammarA2One", false);
        grammarA2TestTwo = sharedPreferences.getBoolean("GrammarA2Two", false);
        grammarA2TestThree = sharedPreferences.getBoolean("GrammarA2Three", false);
        grammarA2TestFour = sharedPreferences.getBoolean("GrammarA2Four", false);
        grammarA2TestFive = sharedPreferences.getBoolean("GrammarA2Five", false);
        grammarA2TestSix = sharedPreferences.getBoolean("GrammarA2Six", false);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            level = bundle.getInt("level");
            vocabulary = bundle.getBoolean("vocabulary");
        }


        if (level == 2 && !vocabulary)
            sixthExercise.setVisibility(View.VISIBLE);

        firstExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 1);
            startActivity(intent);
        });

        secondExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 2);
            startActivity(intent);
        });

        thirdExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 3);
            startActivity(intent);
        });

        fourthExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 4);
            startActivity(intent);
        });

        fifthExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 5);
            startActivity(intent);
        });

        sixthExercise.setOnClickListener(v -> {
            Intent intent = new Intent(TestSelection.this, Tests.class);
            intent.putExtra("level", level);
            intent.putExtra("vocabulary", vocabulary);
            intent.putExtra("exerciseNumber", 6);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonColors();

    }

    private void buttonColors() {
        if (vocabulary) {

        } else {
            if (level == 1) {
                if (grammarA1TestOne) {
                    firstExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    firstExercise.setTextColor(Color.WHITE);
                }
                if (grammarA1TestTwo) {
                    secondExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    secondExercise.setTextColor(Color.WHITE);
                }
                if (grammarA1TestThree) {
                    thirdExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    thirdExercise.setTextColor(Color.WHITE);
                }
                if (grammarA1TestFour) {
                    fourthExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    fourthExercise.setTextColor(Color.WHITE);
                }
                if (grammarA1TestFive) {
                    fifthExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    fifthExercise.setTextColor(Color.WHITE);
                }
            } else if (level == 2) {
                if (grammarA2TestOne) {
                    firstExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    firstExercise.setTextColor(Color.WHITE);
                }
                if (grammarA2TestTwo) {
                    secondExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    secondExercise.setTextColor(Color.WHITE);
                }
                if (grammarA2TestThree) {
                    thirdExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    thirdExercise.setTextColor(Color.WHITE);
                }
                if (grammarA2TestFour) {
                    fourthExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    fourthExercise.setTextColor(Color.WHITE);
                }
                if (grammarA2TestFive) {
                    fifthExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    fifthExercise.setTextColor(Color.WHITE);
                }
                if (grammarA2TestSix) {
                    sixthExercise.setBackground(getDrawable(R.drawable.rounded_corners_green));
                    sixthExercise.setTextColor(Color.WHITE);
                }
            }
        }
    }
}