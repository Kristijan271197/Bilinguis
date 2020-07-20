package com.invictastudios.bilinguis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.adapters.MainAdapter;
import com.invictastudios.bilinguis.model.MainCardsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mainItemRecyclerView = findViewById(R.id.main_item_recycler_view);
        List<MainCardsModel> mainCardsModels = new ArrayList<>();
        mainCardsModels.add(new MainCardsModel("Grammar", R.mipmap.grammar));
        mainCardsModels.add(new MainCardsModel("Vocabulary", R.mipmap.vocabulary));
//        mainCardsModels.add(new MainCardsModel("Listening", R.mipmap.listening));
        mainCardsModels.add(new MainCardsModel("Reading", R.mipmap.reading));
        mainCardsModels.add(new MainCardsModel("Writing", R.mipmap.writing));
        mainCardsModels.add(new MainCardsModel("Additional Information", R.mipmap.additional_info));

        MainAdapter mainAdapter = new MainAdapter(this, mainCardsModels);
        mainItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainItemRecyclerView.setAdapter(mainAdapter);

    }
}