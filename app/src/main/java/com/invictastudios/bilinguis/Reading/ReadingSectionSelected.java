package com.invictastudios.bilinguis.Reading;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.invictastudios.bilinguis.Grammar.GrammarA1;
import com.invictastudios.bilinguis.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadingSectionSelected extends AppCompatActivity {

    private Button playTextButton;
    private TextView exerciseOneQuestionTextView;
    private TextView exerciseOneAnswerTextView;
    private TextView readingTextView;
    private TextView exerciseTwoQuestionTextView;
    private TextView exerciseTwoAnswerTextView;
    private int level;
    private int name;
    private String firstAnswer;
    private String secondAnswer;
    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_section_selected);

        MobileAds.initialize(this, initializationStatus -> {
        });

        adContainerView = findViewById(R.id.adView_container_reading_section_selected);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        Bundle bundle = getIntent().getExtras();

        playTextButton = findViewById(R.id.play_text_button);
        exerciseOneQuestionTextView = findViewById(R.id.exercise_one_question);
        exerciseOneAnswerTextView = findViewById(R.id.exercise_one_answer);
        readingTextView = findViewById(R.id.reading_text_view);
        exerciseTwoQuestionTextView = findViewById(R.id.exercise_two_question);
        exerciseTwoAnswerTextView = findViewById(R.id.exercise_two_answer);

        if (bundle != null) {
            level = bundle.getInt(GrammarA1.EXERCISE_LEVEL);
            name = bundle.getInt(GrammarA1.EXERCISE_NAME);
        }

        if (level == 1) {
            if (name == 1) {
                enterText("reading/A1_exercises/greetings_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/greetings_exercise_one_answer.txt", 2);
                enterText("reading/A1/greetings_text.txt", 3);
                enterText("reading/A1_exercises/greetings_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/greetings_exercise_two_answer.txt", 5);
            } else if (name == 2) {
                enterText("reading/A1_exercises/in_school_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/in_school_exercise_one_answer.txt", 2);
                enterText("reading/A1/in_school_text.txt", 3);
                enterText("reading/A1_exercises/in_school_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/in_school_exercise_two_answer.txt", 5);
            } else if (name == 3) {
                enterText("reading/A1_exercises/market_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/market_exercise_one_answer.txt", 2);
                enterText("reading/A1/market_text.txt", 3);
                enterText("reading/A1_exercises/market_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/market_exercise_two_answer.txt", 5);
            } else if (name == 4) {
                enterText("reading/A1_exercises/home_family_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/home_family_exercise_one_answer.txt", 2);
                enterText("reading/A1/home_family_text.txt", 3);
                enterText("reading/A1_exercises/home_family_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/home_family_exercise_two_answer.txt", 5);
            } else if (name == 5) {
                enterText("reading/A1_exercises/our_day_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/our_day_exercise_one_answer.txt", 2);
                enterText("reading/A1/our_day_text.txt", 3);
                enterText("reading/A1_exercises/our_day_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/our_day_exercise_two_answer.txt", 5);
            }
        } else if (level == 2) {
            if (name == 1) {
                enterText("reading/A2_exercises/zoo_exercise_one_question.txt", 1);
                enterText("reading/A2_exercises/zoo_exercise_one_answer.txt", 2);
                enterText("reading/A2/zoo_text.txt", 3);
                enterText("reading/A2_exercises/zoo_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/zoo_exercise_two_answer.txt", 5);
            } else if (name == 2) {
                enterText("reading/A2_exercises/describing_man_exercise_one_question.txt", 1);
                enterText("reading/A2_exercises/describing_man_exercise_one_answer.txt", 2);
                enterText("reading/A2/describing_man_text.txt", 3);
                enterText("reading/A2_exercises/describing_man_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/describing_man_exercise_two_answer.txt", 5);
            } else if (name == 3) {
                enterText("reading/A2_exercises/clothes_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/clothes_text.txt", 3);
                enterText("reading/A2_exercises/clothes_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/clothes_exercise_two_answer.txt", 5);
            } else if (name == 4) {
                enterText("reading/A2_exercises/describing_room_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/describing_room_text.txt", 3);
                enterText("reading/A2_exercises/describing_room_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/describing_room_exercise_two_answer.txt", 5);
            } else if (name == 5) {
                enterText("reading/A2_exercises/restaurant_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/restaurant_text.txt", 3);
                enterText("reading/A2_exercises/restaurant_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/restaurant_exercise_two_answer.txt", 5);
            } else if (name == 6) {
                enterText("reading/A2_exercises/season_month_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/season_month_text.txt", 3);
                enterText("reading/A2_exercises/season_month_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/season_month_exercise_two_answer.txt", 5);
            } else if (name == 7) {
                enterText("reading/A2_exercises/city_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/city_text.txt", 3);
                enterText("reading/A2_exercises/city_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/city_exercise_two_answer.txt", 5);
            }
        }

        exerciseOneAnswerTextView.setOnClickListener(v -> exerciseOneAnswerTextView.setText(firstAnswer));

        exerciseTwoAnswerTextView.setOnClickListener(v -> exerciseTwoAnswerTextView.setText(secondAnswer));
    }

    private void enterText(String path, int order) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (order == 1)
                    exerciseOneQuestionTextView.append(mLine + "\n");
                else if (order == 2)
                    stringBuilder.append(mLine).append("\n");
                else if (order == 3)
                    readingTextView.append(mLine + "\n");
                else if (order == 4)
                    exerciseTwoQuestionTextView.append(mLine + "\n");
                else if (order == 5)
                    stringBuilder.append(mLine).append("\n");
            }
            if (order == 2)
                firstAnswer = stringBuilder.toString();
            else if (order == 5)
                secondAnswer = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadBanner() {
        AdRequest adRequest = new AdRequest.Builder().build();

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
}