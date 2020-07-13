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

public class ImageGrammarFragment extends Fragment {

    private TextView firstTextView;
    private TextView secondTextView;
    private TextView thirdTextView;
    private TextView firstFrameTextView;
    private TextView secondFrameTextView;
    private TextView thirdFrameTextView;
    private TextView fourthFrameTextView;
    private TextView fifthFrameTextView;
    private TextView sixthFrameTextView;
    private Button exerciseOneButtonImage;
    private Button exerciseTwoButtonImage;
    private Button exerciseThreeButtonImage;

    private int exerciseName;
    private int exerciseLevel;

    public ImageGrammarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_grammar, container, false);

        firstTextView = view.findViewById(R.id.first_text_view);
        secondTextView = view.findViewById(R.id.second_text_view);
        thirdTextView = view.findViewById(R.id.third_text_view);
        firstFrameTextView = view.findViewById(R.id.first_linear_text);
        secondFrameTextView = view.findViewById(R.id.second_linear_text);
        thirdFrameTextView = view.findViewById(R.id.third_linear_text);
        fourthFrameTextView = view.findViewById(R.id.fourth_linear_text);
        fifthFrameTextView = view.findViewById(R.id.fifth_linear_text);
        sixthFrameTextView = view.findViewById(R.id.sixth_linear_text);
        exerciseOneButtonImage = view.findViewById(R.id.exercise_one_button_image);
        exerciseTwoButtonImage = view.findViewById(R.id.exercise_two_button_image);
        exerciseThreeButtonImage = view.findViewById(R.id.exercise_three_button_image);


        if (this.getArguments() != null) {
            exerciseName = this.getArguments().getInt(GrammarA1.EXERCISE_NAME);
            exerciseLevel = this.getArguments().getInt(GrammarA1.EXERCISE_LEVEL);
        }
        if (exerciseLevel == 1) {
            if (exerciseName == 3) {
                enterText("grammar/A1/plural.txt", 1);
                enterText("grammar/A1/plural_left_table.txt", true, 1);
                enterText("grammar/A1/plural_right_table.txt", false, 1);
            } else if (exerciseName == 5) {
                firstTextView.append("Have/has got – Иметь (Has got используем только когда он, она или оно)");
                secondTextView.append("Отрицание");
                thirdTextView.append("Вопрос");
                enterText("grammar/A1/to_have_first_table_left.txt", true, 1);
                enterText("grammar/A1/to_have_first_table_right.txt", false, 1);
                enterText("grammar/A1/to_have_second_table_left.txt", true, 2);
                enterText("grammar/A1/to_have_second_table_right.txt", false, 2);
                enterText("grammar/A1/to_have_third_table_left.txt", true, 3);
                enterText("grammar/A1/to_have_third_table_right.txt", false, 3);
                secondTextView.setVisibility(View.VISIBLE);
                thirdTextView.setVisibility(View.VISIBLE);
                thirdFrameTextView.setVisibility(View.VISIBLE);
                fourthFrameTextView.setVisibility(View.VISIBLE);
                fifthFrameTextView.setVisibility(View.VISIBLE);
                sixthFrameTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 6) {
                enterText("grammar/A1/to_be_first_text.txt", 1);
                enterText("grammar/A1/to_be_second_text.txt", 2);
                enterText("grammar/A1/to_be_first_table_left.txt", true, 1);
                enterText("grammar/A1/to_be_first_table_right.txt", false, 1);
                secondTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 7) {
                enterText("grammar/A1/verbs_table_left.txt", true, 1);
                enterText("grammar/A1/verbs_table_right.txt", false, 1);
            } else if (exerciseName == 8) {
                enterText("grammar/A1/present_simple_first_text.txt", 1);
                enterText("grammar/A1/present_simple_second_text.txt", 2);
                enterText("grammar/A1/present_simple_first_table_left.txt", true, 1);
                enterText("grammar/A1/present_simple_first_table_right.txt", false, 1);
                enterText("grammar/A1/present_simple_second_table_left.txt", true, 2);
                enterText("grammar/A1/present_simple_second_table_right.txt", false, 2);
                secondTextView.setVisibility(View.VISIBLE);
                thirdFrameTextView.setVisibility(View.VISIBLE);
                fourthFrameTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 9) {
                enterText("grammar/A1/present_continuous_first_text.txt", 1);
                enterText("grammar/A1/present_continuous_second_text.txt", 2);
                enterText("grammar/A1/present_continuous_first_table_left.txt", true, 1);
                enterText("grammar/A1/present_continuous_first_table_right.txt", false, 1);
                enterText("grammar/A1/present_continuous_second_table_left.txt", true, 2);
                enterText("grammar/A1/present_continuous_second_table_right.txt", false, 2);
                secondTextView.setVisibility(View.VISIBLE);
                thirdFrameTextView.setVisibility(View.VISIBLE);
                fourthFrameTextView.setVisibility(View.VISIBLE);
            }
        } else if(exerciseLevel == 2){
            if (exerciseName == 1) {
                firstTextView.append("По-другому множественное число образуется если слово:");
                enterText("grammar/A2/plural_exceptions_second_text.txt", 2);
                enterText("grammar/A2/plural_exceptions_table_left.txt", true, 1);
                enterText("grammar/A2/plural_exceptions_table_right.txt", false, 1);
                secondTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 2) {
                enterText("grammar/A2/verbs_table_left.txt", true, 1);
                enterText("grammar/A2/verbs_table_right.txt", false, 1);
            } else if (exerciseName == 3) {
                enterText("grammar/A2/past_simple_first_text.txt", 1);
                enterText("grammar/A2/past_simple_first_table_left.txt", true, 1);
                enterText("grammar/A2/past_simple_first_table_right.txt", false, 1);
                enterText("grammar/A2/past_simple_second_text.txt", 2);
                enterText("grammar/A2/past_simple_second_table_left.txt", true, 2);
                enterText("grammar/A2/past_simple_second_table_right.txt", false, 2);
                secondTextView.setVisibility(View.VISIBLE);
                thirdFrameTextView.setVisibility(View.VISIBLE);
                fourthFrameTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 7) {
                enterText("grammar/A2/future_simple_first_text.txt", 1);
                enterText("grammar/A2/future_simple_first_table_left.txt", true, 1);
                enterText("grammar/A2/future_simple_first_table_right.txt", false, 1);
                enterText("grammar/A2/future_simple_second_text.txt", 2);
                enterText("grammar/A2/future_simple_second_table_left.txt", true, 2);
                enterText("grammar/A2/future_simple_second_table_right.txt", false, 2);
                secondTextView.setVisibility(View.VISIBLE);
                thirdFrameTextView.setVisibility(View.VISIBLE);
                fourthFrameTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 8) {
                enterText("grammar/A2/modals_must_first_text.txt", 1);
                enterText("grammar/A2/modals_must_table_left.txt", true, 1);
                enterText("grammar/A2/modals_must_table_right.txt", false, 1);
                enterText("grammar/A2/modals_must_second_text.txt", 2);
                secondTextView.setVisibility(View.VISIBLE);
            } else if (exerciseName == 11) {
                enterText("grammar/A2/future_be_going_to_first_text.txt", 1);
                enterText("grammar/A2/future_be_going_to_table_left.txt", true, 1);
                enterText("grammar/A2/future_be_going_to_table_right.txt", false, 1);
                enterText("grammar/A2/future_be_going_to_second_text.txt", 2);
                secondTextView.setVisibility(View.VISIBLE);
            }
        }

        exerciseOneButtonImage.setOnClickListener(v -> {
            Intent intent = null;
            if (exerciseLevel == 1) {
                if (exerciseName == 1 || exerciseName == 2 || exerciseName == 10)
                    intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
                else
                    intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            } else if(exerciseLevel == 2){
                if (exerciseName == 8)
                    intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
                else
                    intent = new Intent(view.getContext(), GrammarWritingExercise.class);
            }

            if(intent != null) {
                intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
                intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
                intent.putExtra(GrammarA1.EXERCISE_NUMBER, 1);
                startActivity(intent);
            }
        });

        exerciseTwoButtonImage.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
            intent.putExtra(GrammarA1.EXERCISE_NUMBER, 2);
            startActivity(intent);
        });

        exerciseThreeButtonImage.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarMultipleChoiceExercise.class);
            intent.putExtra(GrammarA1.EXERCISE_NAME, exerciseName);
            intent.putExtra(GrammarA1.EXERCISE_LEVEL, exerciseLevel);
            intent.putExtra(GrammarA1.EXERCISE_NUMBER, 3);
            startActivity(intent);
        });


        return view;
    }

    private void enterText(String path, int order) {
        if (getActivity() != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open(path), StandardCharsets.UTF_8))) {
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    if (order == 1)
                        firstTextView.append(mLine + "\n");
                    else if (order == 2)
                        secondTextView.append(mLine + "\n");
                    else if (order == 3)
                        thirdTextView.append(mLine + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void enterText(String path, boolean left, int order) {
        if (getActivity() != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open(path), StandardCharsets.UTF_8))) {
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    if (order == 1) {
                        if (left)
                            firstFrameTextView.append(mLine + "\n");
                        else
                            secondFrameTextView.append(mLine + "\n");
                    } else if (order == 2) {
                        if (left)
                            thirdFrameTextView.append(mLine + "\n");
                        else
                            fourthFrameTextView.append(mLine + "\n");
                    } else if (order == 3) {
                        if (left)
                            fifthFrameTextView.append(mLine + "\n");
                        else
                            sixthFrameTextView.append(mLine + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}