package com.invictastudios.bilinguis.Grammar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.invictastudios.bilinguis.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GrammarWritingExercise extends AppCompatActivity {

    private CardView cardView;
    private TextView questionNumberTextView;
    private TextView exerciseTitleTextView;
    private TextView exerciseTextView;
    private TextView answerTextView;
    private TextView solutionTextView;
    private EditText answerEditText;
    private Button submitAnswerButton;
    private List<String> questions;
    private List<String> answers;
    private int questionNumber;
    private int correctAnswers;
    private int wrongAnswers;
    private int exerciseName;
    private int exerciseNumber;
    private int exerciseLevel;
    private boolean matches;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_writing_exercise);

        Bundle bundle = getIntent().getExtras();

        cardView = findViewById(R.id.card_view_writing);
        questionNumberTextView = findViewById(R.id.question_number_writing_text_view);
        exerciseTitleTextView = findViewById(R.id.exercise_title_writing_text_view);
        exerciseTextView = findViewById(R.id.exercise_writing_text_view);
        answerTextView = findViewById(R.id.answer_text_view);
        solutionTextView = findViewById(R.id.solution_text_view);
        answerEditText = findViewById(R.id.answer_edit_text);
        submitAnswerButton = findViewById(R.id.submit_answer_button);
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        if (bundle != null) {
            exerciseName = bundle.getInt(GrammarA1.EXERCISE_NAME);
            exerciseLevel = bundle.getInt(GrammarA1.EXERCISE_LEVEL);
            exerciseNumber = bundle.getInt(GrammarA1.EXERCISE_NUMBER);
        }

        if (exerciseLevel == 1) {
            if (exerciseName == 4) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/demonstrative_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/demonstrative_answers_one.txt", answers);
                }
            }
        }

        questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
        exerciseTextView.setText(questions.get(questionNumber));

        submitAnswerButton.setOnClickListener(v -> {
            if (!answerEditText.getText().toString().trim().isEmpty()) {
                String answer = answerEditText.getText().toString().trim();
                for (int i = 0; i < answers.size(); i++) {
                    matches = answers.get(i).equalsIgnoreCase(answer);
                    if (matches) {
                        answers.remove(i);
                        break;
                    }
                }

                if (matches) {
                    correctAnswers++;
                    fadeView();
                } else {
                    solutionTextView.append(answers.get(questionNumber));
                    solutionTextView.setVisibility(View.VISIBLE);
                    wrongAnswers++;
                    shakeAnimation();
                }
            }
        });
    }

    private void fillArray(String path, List<String> list) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                list.add(mLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void nextQuestion() {
        answerEditText.setText("");
        if (questionNumber + 1 < questions.size()) {
            questionNumber++;
            questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
            exerciseTextView.setText(questions.get(questionNumber));
        } else {
            questionNumberTextView.setVisibility(View.INVISIBLE);
            answerEditText.setVisibility(View.INVISIBLE);
            submitAnswerButton.setVisibility(View.INVISIBLE);
            answerTextView.setVisibility(View.INVISIBLE);
            exerciseTitleTextView.setText(String.format(Locale.ENGLISH, "Results: "));
            exerciseTitleTextView.setTextSize(18);
            exerciseTextView.setText(String.format(Locale.ENGLISH, "Correct: %d \nIncorrect: %d", correctAnswers, wrongAnswers));
        }
    }

    private void fadeView() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        cardView.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.GREEN);
                submitAnswerButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
                nextQuestion();
                submitAnswerButton.setEnabled(true);
                solutionTextView.setVisibility(View.INVISIBLE);
                solutionTextView.setText("Answer: \n");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    private void shakeAnimation() {
        Animation shake = AnimationUtils.loadAnimation(GrammarWritingExercise.this,
                R.anim.shake_animation);

        cardView.startAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.RED);
                submitAnswerButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
                nextQuestion();
                submitAnswerButton.setEnabled(true);
                solutionTextView.setVisibility(View.INVISIBLE);
                solutionTextView.setText("Answer: \n");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}