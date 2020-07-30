package com.invictastudios.bilinguis.Reading;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private String url;
    private AdView adView;
    private MediaPlayer mediaPlayer;

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
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );

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
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA1%2Fgreetings.wav?alt=media&token=23eaa698-dc2f-4625-847b-5a145f1f515b";
            } else if (name == 2) {
                enterText("reading/A1_exercises/in_school_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/in_school_exercise_one_answer.txt", 2);
                enterText("reading/A1/in_school_text.txt", 3);
                enterText("reading/A1_exercises/in_school_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/in_school_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA1%2Fin%20school.wav?alt=media&token=357a4d88-b0c0-4580-99b7-0f8a10a4a8cc";
            } else if (name == 3) {
                enterText("reading/A1_exercises/market_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/market_exercise_one_answer.txt", 2);
                enterText("reading/A1/market_text.txt", 3);
                enterText("reading/A1_exercises/market_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/market_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA1%2Fmarket.wav?alt=media&token=1bf4f9e8-c737-4475-bec9-70b8c595c7fb";
            } else if (name == 4) {
                enterText("reading/A1_exercises/home_family_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/home_family_exercise_one_answer.txt", 2);
                enterText("reading/A1/home_family_text.txt", 3);
                enterText("reading/A1_exercises/home_family_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/home_family_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA1%2Fhome%20family.wav?alt=media&token=c3f32fb1-d781-4364-a27b-23a75b882e5f";
            } else if (name == 5) {
                enterText("reading/A1_exercises/our_day_exercise_one_question.txt", 1);
                enterText("reading/A1_exercises/our_day_exercise_one_answer.txt", 2);
                enterText("reading/A1/our_day_text.txt", 3);
                enterText("reading/A1_exercises/our_day_exercise_two_question.txt", 4);
                enterText("reading/A1_exercises/our_day_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA1%2Four%20day.wav?alt=media&token=98cb7e16-4832-488d-a36d-e2f89216a92b";
            }
        } else if (level == 2) {
            if (name == 1) {
                enterText("reading/A2_exercises/zoo_exercise_one_question.txt", 1);
                enterText("reading/A2_exercises/zoo_exercise_one_answer.txt", 2);
                enterText("reading/A2/zoo_text.txt", 3);
                enterText("reading/A2_exercises/zoo_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/zoo_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fzoo.wav?alt=media&token=41056576-4910-44e4-9171-0f1310415a9c";
            } else if (name == 2) {
                exerciseOneQuestionTextView.setVisibility(View.INVISIBLE);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/describing_man_text.txt", 3);
                enterText("reading/A2_exercises/describing_man_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/describing_man_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fdescribing%20man.wav?alt=media&token=aaefd769-f421-4a26-8d7c-34866a5ca2d1";
            } else if (name == 3) {
                enterText("reading/A2_exercises/clothes_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/clothes_text.txt", 3);
                enterText("reading/A2_exercises/clothes_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/clothes_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fclothes.wav?alt=media&token=c86365c3-b276-4d30-b02a-b62a7bb2e828";
            } else if (name == 4) {
                enterText("reading/A2_exercises/describing_room_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/describing_room_text.txt", 3);
                enterText("reading/A2_exercises/describing_room_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/describing_room_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fdescribing%20room.wav?alt=media&token=a844d723-3b8a-4864-aa87-d3bfe8fab3f0";
            } else if (name == 5) {
                enterText("reading/A2_exercises/restaurant_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/restaurant_text.txt", 3);
                enterText("reading/A2_exercises/restaurant_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/restaurant_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Frestaurant.wav?alt=media&token=ce914bee-3005-4ed5-befe-511cb050e9ed";
            } else if (name == 6) {
                enterText("reading/A2_exercises/season_month_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/season_month_text.txt", 3);
                enterText("reading/A2_exercises/season_month_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/season_month_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fseason%20month.wav?alt=media&token=1ede6525-a217-4dc1-8434-7c76655dcc48";
            } else if (name == 7) {
                enterText("reading/A2_exercises/city_exercise_one_question.txt", 1);
                exerciseOneAnswerTextView.setVisibility(View.INVISIBLE);
                enterText("reading/A2/city_text.txt", 3);
                enterText("reading/A2_exercises/city_exercise_two_question.txt", 4);
                enterText("reading/A2_exercises/city_exercise_two_answer.txt", 5);
                url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Reading%2FA2%2Fcity.wav?alt=media&token=745ad603-2ebe-42d4-b67b-52be30be52bc";
            }
        }

        exerciseOneAnswerTextView.setOnClickListener(v -> exerciseOneAnswerTextView.setText(firstAnswer));

        exerciseTwoAnswerTextView.setOnClickListener(v -> exerciseTwoAnswerTextView.setText(secondAnswer));

        playTextButton.setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    playTextButton.setBackgroundResource(R.drawable.sound_icon);
                } else {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    try {
                        Uri uri = Uri.parse(url);
                        mediaPlayer.setDataSource(ReadingSectionSelected.this, uri);
                        mediaPlayer.prepareAsync();
                        playTextButton.setBackgroundResource(R.drawable.pause_icon);
                    } catch (IOException e) {
                        Toast.makeText(ReadingSectionSelected.this, "No audio available", Toast.LENGTH_SHORT).show();
                    }
                    mediaPlayer.setOnPreparedListener(MediaPlayer::start);
                    mediaPlayer.setOnCompletionListener(mp -> {
                        playTextButton.setBackgroundResource(R.drawable.sound_icon);
                        mp.stop();
                        mp.reset();
                    });
                }
            } else
                Toast.makeText(ReadingSectionSelected.this, "Чтобы пользоватся аудиозаписами, пожалуйста подключитесь к интернету", Toast.LENGTH_LONG).show();
        });


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}