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

public class NoImageGrammarFragment extends Fragment {

    private TextView textView;

    public NoImageGrammarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_image_grammar, container, false);
        int name;
        textView = view.findViewById(R.id.text_view);


        if (this.getArguments() != null) {
            name = this.getArguments().getInt("name");

            if (name == 1)
                enterText("grammar/A1/personal_pronouns.txt");
            else if(name == 2)
                enterText("grammar/A1/english_articles.txt");
            else if(name == 4)
                enterText("grammar/A1/demonstrative_pronouns.txt");
            else if(name == 10)
                enterText("grammar/A1/quantifiers_text.txt");
        }


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