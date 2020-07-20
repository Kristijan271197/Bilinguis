package com.invictastudios.bilinguis.Reading;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.invictastudios.bilinguis.Grammar.GrammarA1;
import com.invictastudios.bilinguis.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadingSectionSelected extends AppCompatActivity {

    private TextView readingTextView;
    private int level;
    private int name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_section_selected);

        Bundle bundle = getIntent().getExtras();
        readingTextView = findViewById(R.id.reading_text_view);

        if (bundle != null) {
            level = bundle.getInt(GrammarA1.EXERCISE_LEVEL);
            name = bundle.getInt(GrammarA1.EXERCISE_NAME);
        }

        if (level == 1) {
            if (name == 1) {
                enterText("reading/A1/greetings_text.txt");
            } else if (name == 2) {
                enterText("reading/A1/in_school_text.txt");
            } else if (name == 3) {
                enterText("reading/A1/market_text.txt");
            } else if (name == 4) {
                enterText("reading/A1/home_family_text.txt");
            } else if (name == 5) {
                enterText("reading/A1/our_day_text.txt");
            }
        } else if (level == 2) {
            if (name == 1) {
                enterText("reading/A2/zoo_text.txt");
            } else if (name == 2) {
                enterText("reading/A2/describing_man_text.txt");
            } else if (name == 3) {
                enterText("reading/A2/clothes_text.txt");
            } else if (name == 4) {
                enterText("reading/A2/describing_room_text.txt");
            } else if (name == 5) {
                enterText("reading/A2/restaurant_text.txt");
            } else if (name == 6) {
                enterText("reading/A2/season_month_text.txt");
            } else if (name == 7) {
                enterText("reading/A2/city_text.txt");
            }
        }
    }

    private void enterText(String path) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                readingTextView.append(mLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}