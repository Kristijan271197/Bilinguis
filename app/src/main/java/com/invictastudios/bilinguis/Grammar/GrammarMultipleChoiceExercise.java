package com.invictastudios.bilinguis.Grammar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
import java.util.Random;

public class GrammarMultipleChoiceExercise extends AppCompatActivity {

    private TextView questionNumberTextView;
    private TextView exerciseTitleTextView;
    private TextView exerciseTextView;
    private Button answerOneButton;
    private Button answerTwoButton;
    private Button answerThreeButton;
    private Button answerFourButton;
    private CardView cardView;
    private List<String> questions;
    private List<String> allAnswers;
    private List<String> answers;
    private List<String> allAnswersCopy;
    private int exerciseName;
    private int exerciseNumber;
    private int correctAnswers;
    private int wrongAnswers;
    private int questionNumber;
    private int randomButton;
    private int numberOfButtons;
    private int exerciseLevel;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_multiplechoice_exercise);

        Bundle bundle = getIntent().getExtras();

        questionNumberTextView = findViewById(R.id.question_number_text_view);
        exerciseTitleTextView = findViewById(R.id.exercise_title_text_view);
        exerciseTextView = findViewById(R.id.exercise_text_view);
        answerOneButton = findViewById(R.id.answer_one_button);
        answerTwoButton = findViewById(R.id.answer_two_button);
        answerThreeButton = findViewById(R.id.answer_three_button);
        answerFourButton = findViewById(R.id.answer_four_button);
        cardView = findViewById(R.id.cardView);
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        allAnswers = new ArrayList<>();
        allAnswersCopy = new ArrayList<>();
        random = new Random();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        if (bundle != null) {
            exerciseName = bundle.getInt(GrammarA1.EXERCISE_NAME);
            exerciseLevel = bundle.getInt(GrammarA1.EXERCISE_LEVEL);
            exerciseNumber = bundle.getInt(GrammarA1.EXERCISE_NUMBER);
        }

        if (exerciseLevel == 1) {
            if (exerciseName == 1) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/personal_pronouns_questions.txt", questions);
                    fillArray("grammar/A1_exercises/personal_pronouns_answers.txt", answers);
                    fillArray("grammar/A1_exercises/personal_pronouns_all_answers.txt", allAnswers);
                    fillArray("grammar/A1_exercises/personal_pronouns_all_answers.txt", allAnswersCopy);
                    numberOfButtons = 4;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 2) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("a или an?");
                    fillArray("grammar/A1_exercises/english_articles_questions.txt", questions);
                    fillArray("grammar/A1_exercises/english_articles_answers.txt", answers);
                    fillArray("grammar/A1_exercises/english_articles_all_answers.txt", allAnswers);
                    fillArray("grammar/A1_exercises/english_articles_all_answers.txt", allAnswersCopy);
                    answerThreeButton.setVisibility(View.INVISIBLE);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 2;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 5) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Have или Has?");
                    fillArray("grammar/A1_exercises/verb_to_have_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/verb_to_have_answers_one.txt", answers);
                    fillArray("grammar/A1_exercises/verb_to_have_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A1_exercises/verb_to_have_all_answers_one.txt", allAnswersCopy);
                    answerThreeButton.setVisibility(View.INVISIBLE);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 2;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 6) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Am, Are или Is?");
                    fillArray("grammar/A1_exercises/to_be_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/to_be_answers_one.txt", answers);
                    fillArray("grammar/A1_exercises/to_be_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A1_exercises/to_be_all_answers_one.txt", allAnswersCopy);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 3;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 10) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Much/many?");
                    fillArray("grammar/A1_exercises/quantifiers_questions_one.txt", questions);
                    fillArray("grammar/A1_exercises/quantifiers_answers_one.txt", answers);
                    fillArray("grammar/A1_exercises/quantifiers_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A1_exercises/quantifiers_all_answers_one.txt", allAnswersCopy);
                    answerThreeButton.setVisibility(View.INVISIBLE);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 2;
                    setAnswerButtonsText();
                } else if (exerciseNumber == 3) {
                    exerciseTitleTextView.setText("Выберите правильный ответ: ");
                    fillArray("grammar/A1_exercises/quantifiers_questions_three.txt", questions);
                    fillArray("grammar/A1_exercises/quantifiers_answers_three.txt", answers);
                    fillArray("grammar/A1_exercises/quantifiers_all_answers_three.txt", allAnswers);
                    fillArray("grammar/A1_exercises/quantifiers_all_answers_three.txt", allAnswersCopy);
                    numberOfButtons = 4;
                    setAnswerButtonsText();
                }
            }
        } else if (exerciseLevel == 2) {
            if (exerciseName == 6) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("There is или There are?");
                    fillArray("grammar/A2_exercises/there_is_are_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/there_is_are_answers_one.txt", answers);
                    fillArray("grammar/A2_exercises/there_is_are_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A2_exercises/there_is_are_all_answers_one.txt", allAnswersCopy);
                    answerThreeButton.setVisibility(View.INVISIBLE);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 2;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 8) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("Must или Mustn’t?");
                    fillArray("grammar/A2_exercises/modals_must_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/modals_must_answers_one.txt", answers);
                    fillArray("grammar/A2_exercises/modals_must_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A2_exercises/modals_must_all_answers_one.txt", allAnswersCopy);
                    answerThreeButton.setVisibility(View.INVISIBLE);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 2;
                    setAnswerButtonsText();
                }
            } else if (exerciseName == 9) {
                if (exerciseNumber == 1) {
                    exerciseTitleTextView.setText("At, on или in?");
                    fillArray("grammar/A2_exercises/prepositions_of_time_questions_one.txt", questions);
                    fillArray("grammar/A2_exercises/prepositions_of_time_answers_one.txt", answers);
                    fillArray("grammar/A2_exercises/prepositions_of_time_all_answers_one.txt", allAnswers);
                    fillArray("grammar/A2_exercises/prepositions_of_time_all_answers_one.txt", allAnswersCopy);
                    answerFourButton.setVisibility(View.INVISIBLE);
                    numberOfButtons = 3;
                    setAnswerButtonsText();
                }
            }
        }


        questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
        exerciseTextView.setText(questions.get(questionNumber));

        answerOneButton.setOnClickListener(v -> {
            String answer = answerOneButton.getText().toString();
            if (answer.equals(answers.get(questionNumber))) {
                correctAnswers++;
                fadeView();
            } else {
                wrongAnswers++;

                rightAnswer();
                shakeAnimation();
            }
        });

        answerTwoButton.setOnClickListener(v -> {
            String answer = answerTwoButton.getText().toString();
            if (answer.equals(answers.get(questionNumber))) {
                correctAnswers++;
                fadeView();
            } else {
                wrongAnswers++;
                rightAnswer();
                shakeAnimation();
            }
        });

        answerThreeButton.setOnClickListener(v -> {
            String answer = answerThreeButton.getText().toString();
            if (answer.equals(answers.get(questionNumber))) {
                correctAnswers++;
                fadeView();
            } else {
                wrongAnswers++;

                rightAnswer();
                shakeAnimation();
            }
        });

        answerFourButton.setOnClickListener(v -> {
            String answer = answerFourButton.getText().toString();
            if (answer.equals(answers.get(questionNumber))) {
                correctAnswers++;
                fadeView();
            } else {
                wrongAnswers++;

                rightAnswer();
                shakeAnimation();
            }
        });
    }

    private void nextQuestion() {
        if (questionNumber + 1 < questions.size()) {
            questionNumber++;
            setAnswerButtonsText();
            questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
            exerciseTextView.setText(questions.get(questionNumber));
        } else {
            answerOneButton.setVisibility(View.INVISIBLE);
            answerTwoButton.setVisibility(View.INVISIBLE);
            answerThreeButton.setVisibility(View.INVISIBLE);
            answerFourButton.setVisibility(View.INVISIBLE);
            questionNumberTextView.setVisibility(View.INVISIBLE);
            exerciseTitleTextView.setText(String.format(Locale.ENGLISH, "Results: "));
            exerciseTitleTextView.setTextSize(18);
            exerciseTextView.setText(String.format(Locale.ENGLISH, "Correct: %d \nIncorrect: %d", correctAnswers, wrongAnswers));
        }
    }

    private void setAnswerButtonsText() {

        randomButton = random.nextInt(numberOfButtons);

        allAnswers.remove(answers.get(questionNumber));

        int randomAnswer = randomAnswer(allAnswers.size());

        if (randomButton == 0)
            answerOneButton.setText(answers.get(questionNumber));
        else {
            answerOneButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        randomAnswer = randomAnswer(allAnswers.size());
        if (randomButton == 1)
            answerTwoButton.setText(answers.get(questionNumber));
        else {
            answerTwoButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        if (numberOfButtons > 2) {
            randomAnswer = randomAnswer(allAnswers.size());
            if (randomButton == 2)
                answerThreeButton.setText(answers.get(questionNumber));
            else {
                answerThreeButton.setText(allAnswers.get(randomAnswer));
                allAnswers.remove(randomAnswer);
            }

            if (numberOfButtons > 3) {
                randomAnswer = randomAnswer(allAnswers.size());
                if (randomButton == 3)
                    answerFourButton.setText(answers.get(questionNumber));
                else {
                    answerFourButton.setText(allAnswers.get(randomAnswer));
                    allAnswers.remove(randomAnswer);
                }
            }
        }

        if (!allAnswers.isEmpty())
            allAnswers.clear();
        allAnswers.addAll(allAnswersCopy);
    }

    private int randomAnswer(int number) {
        if (number != 0)
            return random.nextInt(number);
        else
            return 1;
    }

    private void rightAnswer() {
        if (randomButton == 0)
            answerOneButton.setBackgroundColor(Color.GREEN);
        if (randomButton == 1)
            answerTwoButton.setBackgroundColor(Color.GREEN);
        if (randomButton == 2)
            answerThreeButton.setBackgroundColor(Color.GREEN);
        if (randomButton == 3)
            answerFourButton.setBackgroundColor(Color.GREEN);

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
                answerOneButton.setEnabled(false);
                answerTwoButton.setEnabled(false);
                answerThreeButton.setEnabled(false);
                answerFourButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
                nextQuestion();
                answerOneButton.setBackgroundColor(Color.WHITE);
                answerTwoButton.setBackgroundColor(Color.WHITE);
                answerThreeButton.setBackgroundColor(Color.WHITE);
                answerFourButton.setBackgroundColor(Color.WHITE);
                answerOneButton.setEnabled(true);
                answerTwoButton.setEnabled(true);
                answerThreeButton.setEnabled(true);
                answerFourButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    private void shakeAnimation() {
        Animation shake = AnimationUtils.loadAnimation(GrammarMultipleChoiceExercise.this,
                R.anim.shake_animation);

        cardView.startAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.RED);
                answerOneButton.setEnabled(false);
                answerTwoButton.setEnabled(false);
                answerThreeButton.setEnabled(false);
                answerFourButton.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
                nextQuestion();
                answerOneButton.setBackgroundColor(Color.WHITE);
                answerTwoButton.setBackgroundColor(Color.WHITE);
                answerThreeButton.setBackgroundColor(Color.WHITE);
                answerFourButton.setBackgroundColor(Color.WHITE);
                answerOneButton.setEnabled(true);
                answerTwoButton.setEnabled(true);
                answerThreeButton.setEnabled(true);
                answerFourButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}