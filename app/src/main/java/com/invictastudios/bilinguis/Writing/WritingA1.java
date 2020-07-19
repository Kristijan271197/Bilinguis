package com.invictastudios.bilinguis.Writing;

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


public class WritingA1 extends Fragment {

    private TextView writingTextView;


    public WritingA1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_writing_a1, container, false);

        writingTextView = view.findViewById(R.id.writing_a1);
        enterText("writing/writing_a1.txt");

        return view;
    }

    private void enterText(String path) {
        if (getActivity() != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open(path), StandardCharsets.UTF_8))) {
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    writingTextView.append(mLine + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}