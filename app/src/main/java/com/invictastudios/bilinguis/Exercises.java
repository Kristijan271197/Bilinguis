package com.invictastudios.bilinguis;

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

import com.invictastudios.bilinguis.model.WritingExerciseModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Exercises extends AppCompatActivity {

    int randomQuestionBound;
    private CardView cardView;
    private TextView questionNumberTextView;
    private TextView exerciseTitleTextView;
    private TextView exerciseTextView;
    private TextView answerTextView;
    private TextView solutionTextView;
    private EditText answerEditText;
    private Button submitAnswerButton;
    private Button nextQuestionButton;
    private List<String> questions;
    private List<String> answers;
    private List<WritingExerciseModel> questionsAnswers;
    private int questionNumber;
    private int correctAnswers;
    private int wrongAnswers;
    private int exerciseNumber;
    private int exerciseLevel;
    private Random random;
    private boolean matches;
    private boolean isVocabulary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Bundle bundle = getIntent().getExtras();

        cardView = findViewById(R.id.card_view_vocabulary_exercises);
        questionNumberTextView = findViewById(R.id.question_number_vocabulary_exercises_text_view);
        exerciseTitleTextView = findViewById(R.id.exercise_title_vocabulary_exercises_text_view);
        exerciseTextView = findViewById(R.id.exercise_vocabulary_exercises_text_view);
        answerTextView = findViewById(R.id.answer_vocabulary_exercises_text_view);
        solutionTextView = findViewById(R.id.solution_vocabulary_exercises_text_view);
        answerEditText = findViewById(R.id.answer_vocabulary_exercises_edit_text);
        submitAnswerButton = findViewById(R.id.submit_vocabulary_exercises_answer_button);
        nextQuestionButton = findViewById(R.id.next_question_vocabulary_exercises_button);
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        questionsAnswers = new ArrayList<>();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;
        random = new Random();
        randomQuestionBound = 20;

        if (bundle != null) {
            exerciseLevel = bundle.getInt("level");
            exerciseNumber = bundle.getInt("number");
            isVocabulary = bundle.getBoolean("vocabulary");

        }


        if (isVocabulary) {
            if (exerciseLevel == 1) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("vocabulary/A1_exercises/a1_vocabulary_eng_rus_english.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_vocabulary_eng_rus_russian.txt", answers);
                    randomiseQuestions();
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("vocabulary/A1_exercises/a1_vocabulary_rus_eng_russian.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_vocabulary_rus_eng_english.txt", answers);
                    randomiseQuestions();
                }
            } else if (exerciseLevel == 2) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_eng_rus_english.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_eng_rus_russian.txt", answers);
                    randomiseQuestions();
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_rus_eng_russian.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_rus_eng_english.txt", answers);
                    randomiseQuestions();
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_additional_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_vocabulary_additional_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                }
            }
        } else {
            if (exerciseLevel == 1) {
                exerciseTitleTextView.setText("Упражнение 1: a/an");
                fillArray("grammar/A1_exercises/a1_exercises_questions.txt", questions);
                fillArray("grammar/A1_exercises/a1_exercises_answers.txt", answers);
                for (int i = 0; i < questions.size(); i++)
                    questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
            } else if (exerciseLevel == 2) {
                exerciseTitleTextView.setText("Упражнение 1: Образуйте множественное число");
                fillArray("grammar/A2_exercises/a2_exercises_questions.txt", questions);
                fillArray("grammar/A2_exercises/a2_exercises_answers.txt", answers);
                for (int i = 0; i < questions.size(); i++)
                    questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
            }
        }

        questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questionsAnswers.size()));
        exerciseTextView.setText(questionsAnswers.get(questionNumber).getQuestion());

        submitAnswerButton.setOnClickListener(v -> {
            if (!answerEditText.getText().toString().trim().isEmpty()) {
                String answer = answerEditText.getText().toString().trim();
                matches = questionsAnswers.get(questionNumber).getAnswer().equalsIgnoreCase(answer);

                if (matches) {
                    correctAnswers++;
                    fadeView();
                } else {
                    solutionTextView.append(questionsAnswers.get(questionNumber).getAnswer());
                    solutionTextView.setVisibility(View.VISIBLE);
                    wrongAnswers++;
                    shakeAnimation();
                }
            }
        });

        nextQuestionButton.setOnClickListener(v -> {
            nextQuestion();
            submitAnswerButton.setEnabled(true);
            nextQuestionButton.setVisibility(View.INVISIBLE);
            solutionTextView.setVisibility(View.INVISIBLE);
            solutionTextView.setText("Answer: \n");
        });
    }

    private void fillArray(String path, List<String> list) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                list.add(mLine.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void randomiseQuestions() {
        for (int i = 0; i < 20; i++) {
            int randomQuestion = random.nextInt(randomQuestionBound);
            questionsAnswers.add(new WritingExerciseModel(questions.get(randomQuestion), answers.get(randomQuestion)));
            questions.remove(randomQuestion);
            answers.remove(randomQuestion);
            randomQuestionBound--;
        }
    }

    private void nextQuestion() {
        answerEditText.setText("");
        if (questionNumber + 1 < 20) {
            questionNumber++;
            questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questionsAnswers.size()));
            exerciseTextView.setText(questionsAnswers.get(questionNumber).getQuestion());
        } else {
            questionNumberTextView.setVisibility(View.INVISIBLE);
            answerEditText.setVisibility(View.INVISIBLE);
            submitAnswerButton.setVisibility(View.INVISIBLE);
            answerTextView.setVisibility(View.INVISIBLE);
            exerciseTitleTextView.setText(String.format(Locale.ENGLISH, "Results: "));
            exerciseTitleTextView.setTextSize(18);
            exerciseTextView.setText(String.format(Locale.ENGLISH, "Correct: %d \nIncorrect: %d", correctAnswers, wrongAnswers));
        }

        if (!isVocabulary) {
            if (exerciseLevel == 1) {
                if (questionNumber < 7)
                    exerciseTitleTextView.setText("Упражнение 1: a/an");
                else if (questionNumber < 11)
                    exerciseTitleTextView.setText("Упражнение 2: Используйте this");
                else if (questionNumber < 16)
                    exerciseTitleTextView.setText("Упражнение 3: Используйте any/many/much");
                else if (questionNumber < 22)
                    exerciseTitleTextView.setText("Упражнение 4: Используйте Present Simple");
                else if (questionNumber < 28)
                    exerciseTitleTextView.setText("Упражнение 5: Используйте Present Continuous");
                else if (questionNumber < 35)
                    exerciseTitleTextView.setText("Упражнение 6: Present Continuous или Present Simple?");
                else
                    exerciseTitleTextView.setText("Упражнение 7: Present Continuous или Present Simple?");
            } else if (exerciseLevel == 2) {
                if (questionNumber < 10)
                    exerciseTitleTextView.setText("Упражнение 1: Образуйте множественное число");
                else if (questionNumber < 16)
                    exerciseTitleTextView.setText("Упражнение 2: Образуйте Past Simple");
                else if (questionNumber < 22)
                    exerciseTitleTextView.setText("Упражнение 3: Используйте правильное местоимение");
                else if (questionNumber < 28)
                    exerciseTitleTextView.setText("Упражнение 4: Can или Could?");
                else if (questionNumber < 34)
                    exerciseTitleTextView.setText("Упражнение 5: Используйте Future Simple");
                else if (questionNumber < 41)
                    exerciseTitleTextView.setText("Упражнение 6: at, on или in");
                else if (questionNumber < 47)
                    exerciseTitleTextView.setText("Упражнение 7: Используйте be going to");
                else
                    exerciseTitleTextView.setText("Упражнение 8: Past Simple или Future Simple?");
            }
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
                nextQuestionButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    private void shakeAnimation() {
        Animation shake = AnimationUtils.loadAnimation(Exercises.this,
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
                nextQuestionButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}