package com.invictastudios.bilinguis.Grammar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.invictastudios.bilinguis.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GrammarExercise extends AppCompatActivity {

    private TextView questionNumberTextView;
    private TextView exerciseTitleTextView;
    private TextView exerciseTextView;
    private Button answerOneButton;
    private Button answerTwoButton;
    private Button answerThreeButton;
    private Button answerFourButton;
    private List<String> questions;
    private List<String> allAnswers;
    private List<String> answers;
    private List<String> allAnswersCopy;
    private int correctAnswers;
    private int wrongAnswers;
    private int questionNumber;
    private int randomAnswer;
    private int randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_exercise);

        Bundle bundle = getIntent().getExtras();

        questionNumberTextView = findViewById(R.id.question_number_text_view);
        exerciseTitleTextView = findViewById(R.id.exercise_title_text_view);
        exerciseTextView = findViewById(R.id.exercise_text_view);
        answerOneButton = findViewById(R.id.answer_one_button);
        answerTwoButton = findViewById(R.id.answer_two_button);
        answerThreeButton = findViewById(R.id.answer_three_button);
        answerFourButton = findViewById(R.id.answer_four_button);
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        allAnswers = new ArrayList<>();
        allAnswersCopy = new ArrayList<>();
        questionNumber = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        if (bundle != null) {
            if (bundle.getBoolean("a1")) {
                if (bundle.getInt("name") == 1) {
                    exerciseTitleTextView.setText("Попробуйте перевести:");
                    fillArray("grammar/A1_exercises/personal_pronouns_questions.txt", questions);
                    fillArray("grammar/A1_exercises/personal_pronouns_answers.txt", answers);
                    fillArray("grammar/A1_exercises/personal_pronouns_all_answers.txt", allAnswers);
                    fillArray("grammar/A1_exercises/personal_pronouns_all_answers.txt", allAnswersCopy);
                    setAnswerButtonsText();
                }
            }

        }

        questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
        exerciseTextView.setText(questions.get(questionNumber));

        answerOneButton.setOnClickListener(v -> {
            String answer = answerOneButton.getText().toString();
            if (answer.equals(answers.get(questionNumber)))
                correctAnswer(true);
            else
                correctAnswer(false);
        });

        answerTwoButton.setOnClickListener(v -> {
            String answer = answerTwoButton.getText().toString();
            if (answer.equals(answers.get(questionNumber)))
                correctAnswer(true);
            else
                correctAnswer(false);
        });

        answerThreeButton.setOnClickListener(v -> {
            String answer = answerThreeButton.getText().toString();
            if (answer.equals(answers.get(questionNumber)))
                correctAnswer(true);
            else
                correctAnswer(false);
        });

        answerFourButton.setOnClickListener(v -> {
            String answer = answerFourButton.getText().toString();
            if (answer.equals(answers.get(questionNumber)))
                correctAnswer(true);
            else
                correctAnswer(false);
        });


    }

    private void correctAnswer(boolean correct) {
        if (correct) {
            correctAnswers++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            wrongAnswers++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        if (questionNumber + 1 < questions.size()) {
            questionNumber++;
            setAnswerButtonsText();
            questionNumberTextView.setText(String.format(Locale.ENGLISH, "Question %d/%d", questionNumber + 1, questions.size()));
            exerciseTextView.setText(questions.get(questionNumber));
        } else{
            answerOneButton.setVisibility(View.INVISIBLE);
            answerTwoButton.setVisibility(View.INVISIBLE);
            answerThreeButton.setVisibility(View.INVISIBLE);
            answerFourButton.setVisibility(View.INVISIBLE);
            questionNumberTextView.setVisibility(View.INVISIBLE);
            exerciseTitleTextView.setText(String.format(Locale.ENGLISH,"Results: "));
            exerciseTitleTextView.setTextSize(18);
            exerciseTextView.setText(String.format(Locale.ENGLISH,"Correct: %d \nIncorrect: %d",correctAnswers,wrongAnswers));
        }



    }

    private void setAnswerButtonsText() {
        Random random = new Random();
        randomButton = random.nextInt(4);
        Toast.makeText(this, "Text" + randomButton, Toast.LENGTH_SHORT).show();
        randomAnswer = random.nextInt(allAnswers.size());
        if(questionNumber == 0)
            allAnswers.remove(5);
        else if(questionNumber == 1)
            allAnswers.remove(3);
        else if(questionNumber == 2)
            allAnswers.remove(7);
        else if(questionNumber == 3)
            allAnswers.remove(1);

        if (randomButton == 0)
            answerOneButton.setText(answers.get(questionNumber));
        else {
            answerOneButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        randomAnswer = random.nextInt(allAnswers.size());
        if (randomButton == 1)
            answerTwoButton.setText(answers.get(questionNumber));
        else {
            answerTwoButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        randomAnswer = random.nextInt(allAnswers.size());
        if (randomButton == 2)
            answerThreeButton.setText(answers.get(questionNumber));
        else {
            answerThreeButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        randomAnswer = random.nextInt(allAnswers.size());
        if (randomButton == 3)
            answerFourButton.setText(answers.get(questionNumber));
        else {
            answerFourButton.setText(allAnswers.get(randomAnswer));
            allAnswers.remove(randomAnswer);
        }
        allAnswers.clear();
        allAnswers.addAll(allAnswersCopy);
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
}