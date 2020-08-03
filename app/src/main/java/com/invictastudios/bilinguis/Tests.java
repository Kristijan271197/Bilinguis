package com.invictastudios.bilinguis;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.invictastudios.bilinguis.model.WritingExerciseModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Tests extends AppCompatActivity {

    public static final String LEVELS_UNLOCK = "levelsUnlock";
    private CardView cardView;
    private TextView questionNumberTextView;
    private TextView exerciseTitleTextView;
    private TextView exerciseTextView;
    private TextView answerTextView;
    private TextView solutionTextView;
    private EditText answerEditText;
    private Button submitAnswerButton;
    private Button nextQuestionButton;
    private List<WritingExerciseModel> questionsAnswers;
    private int questionNumber;
    private int correctAnswers;
    private int wrongAnswers;
    private int exerciseLevel;
    private boolean isVocabulary;
    private int exerciseNumber;
    private SharedPreferences.Editor editor;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        MobileAds.initialize(this, initializationStatus -> {
        });

        FrameLayout adContainerView = findViewById(R.id.adView_container_exercises);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        SharedPreferences sharedPreferences = getSharedPreferences(LEVELS_UNLOCK, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();


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
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questionsAnswers = new ArrayList<>();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        if (bundle != null) {
            exerciseLevel = bundle.getInt("level");
            isVocabulary = bundle.getBoolean("vocabulary");
            exerciseNumber = bundle.getInt("exerciseNumber");
        }


        if (isVocabulary) {
            if (exerciseLevel == 1) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Упражнение 1.Переведите с английского на русский язык:");
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_one_questions.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_one_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Упражнение 2: Сделайте предложение:");
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_two_questions.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_two_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Упражнение 3: Переведите с русского на английский:");
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_three_questions.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_three_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 4) {
                    exerciseTitleTextView.setText("Упражнение 4: Переведите:");
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_four_questions.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_four_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 5) {
                    exerciseTitleTextView.setText("Упражнение 5: Ссоставьте слово из набора букв");
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_five_questions.txt", questions);
                    fillArray("vocabulary/A1_exercises/a1_test_vocabulary_five_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                }
            } else if (exerciseLevel == 2) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Упражнение 1.Переведите с английского на русский язык:");
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_one_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_one_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Упражнение 2: Сделайте предложение:");
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_two_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_two_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Упражнение 3: Переведите с русского на английский:");
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_three_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_three_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 4) {
                    exerciseTitleTextView.setText("Упражнение 4: Переведите:");
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_four_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_four_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 5) {
                    exerciseTitleTextView.setText("Упражнение 5: Ссоставьте слово из набора букв");
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_five_questions.txt", questions);
                    fillArray("vocabulary/A2_exercises/a2_test_vocabulary_five_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                }
            }
        } else {
            if (exerciseLevel == 1) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Упражнение 1: Используйте any/many/much");
                    fillArray("grammar/A1_exercises/a1_test_grammar_one_questions.txt", questions);
                    fillArray("grammar/A1_exercises/a1_test_grammar_one_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Упражнение 2: Present Simple или Present Continuous?");
                    fillArray("grammar/A1_exercises/a1_test_grammar_two_questions.txt", questions);
                    fillArray("grammar/A1_exercises/a1_test_grammar_two_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Упражнение 3: а/an");
                    fillArray("grammar/A1_exercises/a1_test_grammar_three_questions.txt", questions);
                    fillArray("grammar/A1_exercises/a1_test_grammar_three_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 4) {
                    exerciseTitleTextView.setText("Упражнение 4: Сделайте вопрос:");
                    fillArray("grammar/A1_exercises/a1_test_grammar_four_questions.txt", questions);
                    fillArray("grammar/A1_exercises/a1_test_grammar_four_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 5) {
                    exerciseTitleTextView.setText("Упражнение 5: Сделайте отрицание:");
                    fillArray("grammar/A1_exercises/a1_test_grammar_five_questions.txt", questions);
                    fillArray("grammar/A1_exercises/a1_test_grammar_five_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                }
            } else if (exerciseLevel == 2) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Упражнение 1: Используйте личные местоимения");
                    fillArray("grammar/A2_exercises/a2_test_grammar_one_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_one_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Упражнение 2: Образуйте Past Simple");
                    fillArray("grammar/A2_exercises/a2_test_grammar_two_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_two_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Упражнение 3: Образуйте множественное число существительных");
                    fillArray("grammar/A2_exercises/a2_test_grammar_three_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_three_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 4) {
                    exerciseTitleTextView.setText("Упражнение 4: Сделайте Future Simple:");
                    fillArray("grammar/A2_exercises/a2_test_grammar_four_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_four_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 5) {
                    exerciseTitleTextView.setText("Упражнение 5: Must(not) или Can(not)?");
                    fillArray("grammar/A2_exercises/a2_test_grammar_five_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_five_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                } else if (exerciseNumber == 6) {
                    exerciseTitleTextView.setText("Упражнение 6: Future Simple или Past Simple?");
                    fillArray("grammar/A2_exercises/a2_test_grammar_six_questions.txt", questions);
                    fillArray("grammar/A2_exercises/a2_test_grammar_six_answers.txt", answers);
                    for (int i = 0; i < questions.size(); i++)
                        questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));
                }
            }
        }

        questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questionsAnswers.size()));
        exerciseTextView.setText(questionsAnswers.get(questionNumber).getQuestion());

        submitAnswerButton.setOnClickListener(v -> {
            submitButton();
        });

        nextQuestionButton.setOnClickListener(v -> {
            nextQuestion();
            submitAnswerButton.setEnabled(true);
            nextQuestionButton.setVisibility(View.INVISIBLE);
            solutionTextView.setVisibility(View.INVISIBLE);
            solutionTextView.setText("Answer: \n");
        });

        answerEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE)
                submitButton();
            return false;
        });
    }

    private void submitButton() {
        if (!answerEditText.getText().toString().trim().isEmpty()) {
            String answer = answerEditText.getText().toString().trim();
            answer = answer.replaceAll("[,!.]*", "");
            boolean matches = questionsAnswers.get(questionNumber).getAnswer().equalsIgnoreCase(answer);

            if (matches) {
                correctAnswers++;
                fadeView();
                rememberAnswers();
                editor.apply();
            } else {
                solutionTextView.setText(questionsAnswers.get(questionNumber).getAnswer());
                solutionTextView.setVisibility(View.VISIBLE);
                wrongAnswers++;
                shakeAnimation();
            }
        }
    }

    private void rememberAnswers() {
        if (isVocabulary) {
            if (exerciseLevel == 1) {
                if (exerciseNumber == 1) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("VocabularyA1One", true);
                } else if (exerciseNumber == 2) {
                    if (correctAnswers >= 9)
                        editor.putBoolean("VocabularyA1Two", true);
                } else if (exerciseNumber == 3) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("VocabularyA1Three", true);
                } else if (exerciseNumber == 4) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("VocabularyA1Four", true);
                } else if (exerciseNumber == 5) {
                    if (correctAnswers >= 3)
                        editor.putBoolean("VocabularyA1Five", true);
                }
            } else if (exerciseLevel == 2) {
                if (exerciseNumber == 1) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("VocabularyA2One", true);
                } else if (exerciseNumber == 2) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("VocabularyA2Two", true);
                } else if (exerciseNumber == 3) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("VocabularyA2Three", true);
                } else if (exerciseNumber == 4) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("VocabularyA2Four", true);
                } else if (exerciseNumber == 5) {
                    if (correctAnswers >= 3)
                        editor.putBoolean("VocabularyA2Five", true);
                }
            }
        } else {
            if (exerciseLevel == 1) {
                if (exerciseNumber == 1) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA1One", true);
                } else if (exerciseNumber == 2) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("GrammarA1Two", true);
                } else if (exerciseNumber == 3) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA1Three", true);
                } else if (exerciseNumber == 4) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("GrammarA1Four", true);
                } else if (exerciseNumber == 5) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA1Five", true);
                }
            } else if (exerciseLevel == 2) {
                if (exerciseNumber == 1) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA2One", true);
                } else if (exerciseNumber == 2) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("GrammarA2Two", true);
                } else if (exerciseNumber == 3) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA2Three", true);
                } else if (exerciseNumber == 4) {
                    if (correctAnswers >= 8)
                        editor.putBoolean("GrammarA2Four", true);
                } else if (exerciseNumber == 5) {
                    if (correctAnswers >= 7)
                        editor.putBoolean("GrammarA2Five", true);
                } else if (exerciseNumber == 6) {
                    if (correctAnswers >= 2)
                        editor.putBoolean("GrammarA2Six", true);
                }
            }
        }
        editor.apply();
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

    private void nextQuestion() {
        answerEditText.setText("");
        if (questionNumber + 1 < questionsAnswers.size()) {
            questionNumber++;
            questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questionsAnswers.size()));
            exerciseTextView.setText(questionsAnswers.get(questionNumber).getQuestion());
        } else {
            questionNumberTextView.setVisibility(View.INVISIBLE);
            answerEditText.setVisibility(View.INVISIBLE);
            submitAnswerButton.setVisibility(View.INVISIBLE);
            answerTextView.setVisibility(View.INVISIBLE);
            exerciseTitleTextView.setText(R.string.results_text);
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
                nextQuestionButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    private void shakeAnimation() {
        Animation shake = AnimationUtils.loadAnimation(Tests.this,
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

    private void loadBanner() {
        AdRequest adRequest = new AdRequest.Builder().build();
        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
}