package com.invictastudios.bilinguis.Grammar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.model.WritingExerciseModel;

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
    private Button nextQuestionButton;
    private List<String> questions;
    private List<String> answers;
    private List<WritingExerciseModel> questionsAnswers;
    private int questionNumber;
    private int correctAnswers;
    private int wrongAnswers;
    private int exerciseName;
    private int exerciseNumber;
    private int exerciseLevel;
    private boolean matches;
    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_writing_exercise);

        MobileAds.initialize(this, initializationStatus -> {
        });

        adContainerView = findViewById(R.id.adView_container_grammar_writing);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        Bundle bundle = getIntent().getExtras();

        cardView = findViewById(R.id.card_view_writing);
        questionNumberTextView = findViewById(R.id.question_number_writing_text_view);
        exerciseTitleTextView = findViewById(R.id.exercise_title_writing_text_view);
        exerciseTextView = findViewById(R.id.exercise_writing_text_view);
        answerTextView = findViewById(R.id.answer_text_view);
        solutionTextView = findViewById(R.id.solution_text_view);
        answerEditText = findViewById(R.id.answer_edit_text);
        submitAnswerButton = findViewById(R.id.submit_answer_button);
        nextQuestionButton = findViewById(R.id.next_question_button);
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        questionsAnswers = new ArrayList<>();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        if (bundle != null) {
            exerciseName = bundle.getInt(GrammarA1.EXERCISE_NAME);
            exerciseLevel = bundle.getInt(GrammarA1.EXERCISE_LEVEL);
            exerciseNumber = bundle.getInt(GrammarA1.EXERCISE_NUMBER);
        }

        if (exerciseLevel == 1) {
            if (exerciseName == 3) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Образуйте множественное число:");
                    fillArray("grammar/A1_exercises/plural_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/plural_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Образуйте единственное число: ");
                    fillArray("grammar/A1_exercises/plural_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/plural_answers_two.txt", answers);
                }
            } else if (exerciseName == 4) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/demonstrative_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/demonstrative_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/demonstrative_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/demonstrative_answers_two.txt", answers);
                }
            } else if (exerciseName == 5) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/verb_to_have_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/verb_to_have_answers_two.txt", answers);
                }
            } else if (exerciseName == 6) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/to_be_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/to_be_answers_two.txt", answers);
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/to_be_questions_three.txt", questions);
                    fillArray("grammar/A1_exercises/to_be_answers_three.txt", answers);
                }
            } else if (exerciseName == 8) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/present_simple_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/present_simple_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Раскройте скобки, употребляя глаголы в Present Simple:");
                    fillArray("grammar/A1_exercises/present_simple_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/present_simple_answers_two.txt", answers);
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/present_simple_questions_three.txt", questions);
                    fillArray("grammar/A1_exercises/present_simple_answers_three.txt", answers);
                }
            } else if (exerciseName == 9) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/present_continuous_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/present_continuous_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Раскройте скобки, употребляя глаголы в Present Continuous:");
                    fillArray("grammar/A1_exercises/present_continuous_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/present_continuous_answers_two.txt", answers);
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/present_continuous_questions_three.txt", questions);
                    fillArray("grammar/A1_exercises/present_continuous_answers_three.txt", answers);
                }
            } else if (exerciseName == 10) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/quantifiers_questions_two.txt", questions);
                    fillArray("grammar/A1_exercises/quantifiers_answers_two.txt", answers);
                }
            }
        } else if (exerciseLevel == 2) {
            if (exerciseName == 1) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Образуйте множественное число:");
                    fillArray("grammar/A2_exercises/plural_exceptions_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/plural_exceptions_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Образуйте множественное число:");
                    fillArray("grammar/A2_exercises/plural_exceptions_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/plural_exceptions_answers_two.txt", answers);
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/plural_exceptions_questions_three.txt", questions);
                    fillArray("grammar/A2_exercises/plural_exceptions_answers_three.txt", answers);
                }
            } else if (exerciseName == 3) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Раскройте скобки, употребляя глаголы в Past Simple:");
                    fillArray("grammar/A2_exercises/past_simple_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/past_simple_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/past_simple_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/past_simple_answers_two.txt", answers);
                }
            } else if (exerciseName == 4) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Выберите правильное местоимение:");
                    fillArray("grammar/A2_exercises/personal_pronouns_two_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/personal_pronouns_two_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/personal_pronouns_two_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/personal_pronouns_two_answers_two.txt", answers);
                }
            } else if (exerciseName == 5) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/modal_verbs_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/modal_verbs_answers_two.txt", answers);
                }
            } else if (exerciseName == 6) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/there_is_are_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/there_is_are_answers_two.txt", answers);
                }
            } else if (exerciseName == 7) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Раскройте скобки, употребляя глаголы в Future Simple:");
                    fillArray("grammar/A2_exercises/future_simple_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/future_simple_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/future_simple_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/future_simple_answers_two.txt", answers);
                }
            } else if (exerciseName == 8) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/modals_must_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/modals_must_answers_two.txt", answers);
                }
            } else if (exerciseName == 9) {
                if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/prepositions_of_time_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/prepositions_of_time_answers_two.txt", answers);
                }
            } else if (exerciseName == 11) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/be_going_to_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/be_going_to_answers_one.txt", answers);
                } else if (exerciseNumber == 2) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A2_exercises/be_going_to_questions_two.txt", questions);
                    fillArray("grammar/A2_exercises/be_going_to_answers_two.txt", answers);
                }
            }
        }

        for (int i = 0; i < questions.size(); i++)
            questionsAnswers.add(new WritingExerciseModel(questions.get(i), answers.get(i)));


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
                list.add(mLine);
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
                nextQuestionButton.setVisibility(View.VISIBLE);
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