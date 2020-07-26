package com.invictastudios.bilinguis.Additional;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.adapters.PlanAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AdditionalInformationPlan extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanAdapter planAdapter;
    private ArrayList<String> title;
    private List<String> description;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information_plan);
        Bundle bundle = getIntent().getExtras();

        title = new ArrayList<>();
        description = new ArrayList<>();



        if (bundle != null)
            level = bundle.getInt("level");

        if (level == 1) {
            for (int i = 0; i < 12; i++)
                title.add("Day " + (i + 1));
            enterText("additional_info/A1/a1_plan_1.txt");
            enterText("additional_info/A1/a1_plan_2.txt");
            enterText("additional_info/A1/a1_plan_3.txt");
            enterText("additional_info/A1/a1_plan_4.txt");
            enterText("additional_info/A1/a1_plan_5.txt");
            enterText("additional_info/A1/a1_plan_6.txt");
            enterText("additional_info/A1/a1_plan_7.txt");
            enterText("additional_info/A1/a1_plan_8.txt");
            enterText("additional_info/A1/a1_plan_9.txt");
            enterText("additional_info/A1/a1_plan_10.txt");
            enterText("additional_info/A1/a1_plan_11.txt");
            enterText("additional_info/A1/a1_plan_12.txt");
            planAdapter = new PlanAdapter(this, title, description, 1);
        } else if (level == 2) {
            for (int i = 0; i < 15; i++)
                title.add("Day " + (i + 1));
            enterText("additional_info/A2/a2_plan_1.txt");
            enterText("additional_info/A2/a2_plan_2.txt");
            enterText("additional_info/A2/a2_plan_3.txt");
            enterText("additional_info/A2/a2_plan_4.txt");
            enterText("additional_info/A2/a2_plan_5.txt");
            enterText("additional_info/A2/a2_plan_6.txt");
            enterText("additional_info/A2/a2_plan_7.txt");
            enterText("additional_info/A2/a2_plan_8.txt");
            enterText("additional_info/A2/a2_plan_9.txt");
            enterText("additional_info/A2/a2_plan_10.txt");
            enterText("additional_info/A2/a2_plan_11.txt");
            enterText("additional_info/A2/a2_plan_12.txt");
            enterText("additional_info/A2/a2_plan_13.txt");
            enterText("additional_info/A2/a2_plan_14.txt");
            enterText("additional_info/A2/a2_plan_15.txt");
            planAdapter = new PlanAdapter(this, title, description, 2);
        }

        recyclerView = findViewById(R.id.additional_info_plan_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(planAdapter);
    }

    private void enterText(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
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