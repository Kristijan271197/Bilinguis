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
    private Button exerciseButtonNoImage;
    int name;
    boolean a1;

    public NoImageGrammarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_image_grammar, container, false);

        textView = view.findViewById(R.id.text_view);
        exerciseButtonNoImage = view.findViewById(R.id.exercise_button_no_image);
        if (this.getArguments() != null) {
            name = this.getArguments().getInt("name");
            a1 = this.getArguments().getBoolean("a1");
        }


        if (a1) {
            if (name == 1)
                enterText("grammar/A1/personal_pronouns.txt");
            else if (name == 2)
                enterText("grammar/A1/english_articles.txt");
            else if (name == 4)
                enterText("grammar/A1/demonstrative_pronouns.txt");
            else if (name == 10)
                enterText("grammar/A1/quantifiers_text.txt");
        } else {
            if (name == 4)
                enterText("grammar/A2/personal_pronouns_part_two.txt");
            else if (name == 5)
                enterText("grammar/A2/modal_verbs.txt");
            else if (name == 6)
                enterText("grammar/A2/there_is_are.txt");
            else if (name == 9)
                enterText("grammar/A2/prepositions_of_time.txt");
            else if (name == 10)
                enterText("grammar/A2/prepositions_of_place.txt");
        }


        exerciseButtonNoImage.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), GrammarExercise.class);
            intent.putExtra("name", name);
            intent.putExtra("a1", a1);
            startActivity(intent);
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