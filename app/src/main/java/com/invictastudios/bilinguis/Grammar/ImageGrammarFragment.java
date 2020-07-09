package com.invictastudios.bilinguis.Grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        int name;
        boolean a1;

        if (this.getArguments() != null) {
            name = this.getArguments().getInt("name");
            a1 = this.getArguments().getBoolean("a1");

            if (a1) {
                if (name == 3) {
                    enterText("grammar/A1/plural.txt", 1);
                    enterText("grammar/A1/plural_left_table.txt", true, 1);
                    enterText("grammar/A1/plural_right_table.txt", false, 1);
                } else if (name == 5) {
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
                } else if (name == 6) {
                    enterText("grammar/A1/to_be_first_text.txt", 1);
                    enterText("grammar/A1/to_be_second_text.txt", 2);
                    enterText("grammar/A1/to_be_first_table_left.txt", true, 1);
                    enterText("grammar/A1/to_be_first_table_right.txt", false, 1);
                    secondTextView.setVisibility(View.VISIBLE);
                } else if (name == 7) {
                    enterText("grammar/A1/verbs_table_left.txt", true, 1);
                    enterText("grammar/A1/verbs_table_right.txt", false, 1);
                } else if (name == 8) {
                    enterText("grammar/A1/present_simple_first_text.txt", 1);
                    enterText("grammar/A1/present_simple_second_text.txt", 2);
                    enterText("grammar/A1/present_simple_first_table_left.txt", true, 1);
                    enterText("grammar/A1/present_simple_first_table_right.txt", false, 1);
                    enterText("grammar/A1/present_simple_second_table_left.txt", true, 2);
                    enterText("grammar/A1/present_simple_second_table_right.txt", false, 2);
                    secondTextView.setVisibility(View.VISIBLE);
                    thirdFrameTextView.setVisibility(View.VISIBLE);
                    fourthFrameTextView.setVisibility(View.VISIBLE);
                } else if (name == 9) {
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
            } else{
                if(name == 1){
                    firstTextView.append("По-другому множественное число образуется если слово:");

                }
            }


        }


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