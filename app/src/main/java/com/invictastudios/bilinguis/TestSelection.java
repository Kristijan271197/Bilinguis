package com.invictastudios.bilinguis;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selector);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            level = bundle.getInt("level");
            vocabulary = bundle.getBoolean("vocabulary");
        }

        firstExercise = findViewById(R.id.first_exercise);
        secondExercise = findViewById(R.id.second_exercise);
        thirdExercise = findViewById(R.id.third_exercise);
        fourthExercise = findViewById(R.id.fourth_exercise);
        fifthExercise = findViewById(R.id.fifth_exercise);
        sixthExercise = findViewById(R.id.sixth_exercise);

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
}