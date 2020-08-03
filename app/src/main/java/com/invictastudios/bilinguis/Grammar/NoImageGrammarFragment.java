package com.invictastudios.bilinguis.Grammar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NoImageGrammarFragment extends Fragment {

    private TextView textView;
    int exerciseName;
    int exerciseLevel;

    public NoImageGrammarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_image_grammar, container, false);

        textView = view.findViewById(R.id.text_view);
        Button exerciseOneButtonNoImage = view.findViewById(R.id.exercise_one_button_no_image);
        Button exerciseTwoButtonNoImage = view.findViewById(R.id.exercise_two_button_no_image);
        Button exerciseThreeButtonNoImage = view.findViewById(R.id.exercise_three_button_no_image);
        if (this.getArguments() != null) {
            exerciseName = this.getArguments().getInt(GrammarA1.EXERCISE_NAME);
            exerciseLevel = this.getArguments().getInt(GrammarA1.EXERCISE_LEVEL);
        }


        if (exerciseLevel == 1) {
            if (exerciseName == 1) {
                enterText("grammar/A1/personal_pronouns.txt");
                exerciseTwoButtonNoImage.setVisibility(View.INVISIBLE);
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 2) {
                enterText("grammar/A1/english_articles.txt");
                exerciseTwoButtonNoImage.setVisibility(View.INVISIBLE);
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 4) {
                enterText("grammar/A1/demonstrative_pronouns.txt");
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 10)
                enterText("grammar/A1/quantifiers_text.txt");
        } else if (exerciseLevel == 2) {
            if (exerciseName == 4) {
                enterText("grammar/A2/personal_pronouns_part_two.txt");
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 5) {
                enterText("grammar/A2/modal_verbs.txt");
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 6) {
                enterText("grammar/A2/there_is_are.txt");
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 9) {
                enterText("grammar/A2/prepositions_of_time.txt");
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            } else if (exerciseName == 10) {
                enterText("grammar/A2/prepositions_of_place.txt");
                exerciseOneButtonNoImage.setVisibility(View.INVISIBLE);
                exerciseTwoButtonNoImage.setVisibility(View.INVISIBLE);
                exerciseThreeButtonNoImage.setVisibility(View.INVISIBLE);
            }
        }


        exerciseOneButtonNoImage.setOnClickListener(v -> {
            Intent intent = null;
            if (exerciseLevel == 1) {
                if (exerciseName == 1 || exerciseName == 2 || exerciseName == 10)
                    intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
                else
                    intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            } else if (exerciseLevel == 2) {
                if (exerciseName == 5 || exerciseName == 6 || exerciseName == 9)
                    intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
                else
                    intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            }

            if (intent != null) {
                intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
                intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
                intent.putExtra(GrammarA1.EXERCISE_NUMBER, 1);
                startActivity(intent);
            }
        });

        exerciseTwoButtonNoImage.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
            intent.putExtra(GrammarA1.EXERCISE_NUMBER, 2);
            startActivity(intent);
        });

        exerciseThreeButtonNoImage.setOnClickListener(v -> {
            Intent intent = null;
            if (exerciseLevel == 1) {
                if (exerciseName == 10)
                    intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
                else
                    intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            }

            if (intent != null) {
                intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
                intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
                intent.putExtra(GrammarA1.EXERCISE_NUMBER, 3);
                startActivity(intent);
            }
        });


        return view;
    }

    private void enterText(String path) {
        if (getActivity() != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open(path), StandardCharsets.UTF_8))) {
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    textView.append(mLine + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}