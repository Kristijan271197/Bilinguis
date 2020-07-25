package com.invictastudios.bilinguis.Writing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.adapters.WritingAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class WritingA1 extends Fragment {

    private RecyclerView recyclerView;
    private WritingAdapter writingAdapter;
    private List<String> title;
    private List<String> description;

    public WritingA1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_writing_a1, container, false);

        title = new ArrayList<>();
        description = new ArrayList<>();

        title.add("Знакомство");
        title.add("Опишите свой рабочий стол");
        title.add("Present Simple");
        title.add("В магазине");
        title.add("Present Continuous");
        title.add("Моя семья");

        enterText("writing/A1/writing_a1_one.txt");
        enterText("writing/A1/writing_a1_two.txt");
        enterText("writing/A1/writing_a1_three.txt");
        enterText("writing/A1/writing_a1_four.txt");
        enterText("writing/A1/writing_a1_five.txt");
        enterText("writing/A1/writing_a1_six.txt");

        recyclerView = view.findViewById(R.id.writing_a1_recycler_view);
        writingAdapter = new WritingAdapter(view.getContext(), title, description);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(writingAdapter);

        return view;
    }

    private void enterText(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        if (getActivity() != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open(path), StandardCharsets.UTF_8))) {
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    stringBuilder.append(mLine).append("\n");
                }
                description.add(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}