package com.invictastudios.bilinguis.Vocabulary;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.adapters.VocabularySelectionAdapter;
import com.invictastudios.bilinguis.model.VocabularySelectionModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VocabularySectionSelected extends AppCompatActivity {

    private List<String> englishWords;
    private List<String> russianWords;
    private List<VocabularySelectionModel> vocabularyModel;
    private RecyclerView vocabularySelectionRecyclerView;
    private VocabularySelectionAdapter adapter;
    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_section_selected);

        MobileAds.initialize(this, initializationStatus -> {
        });

        adContainerView = findViewById(R.id.adView_container_vocabulary_section_selected);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        englishWords = new ArrayList<>();
        russianWords = new ArrayList<>();
        vocabularyModel = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        String section = null;

        if (bundle != null)
            section = bundle.getString("section");

        if (section != null) {
            switch (section) {
                case VocabularyA1.GREETINGS:
                    initializeWords(englishWords, "vocabulary/A1/greetings/greetings_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/greetings/greetings_russian.txt");
                    break;
                case VocabularyA1.GEOGRAPHY:
                    initializeWords(englishWords, "vocabulary/A1/geography/geography_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/geography/geography_russian.txt");
                    break;
                case VocabularyA1.COLORS:
                    initializeWords(englishWords, "vocabulary/A1/colors/colors_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/colors/colors_russian.txt");
                    break;
                case VocabularyA1.THINGS:
                    initializeWords(englishWords, "vocabulary/A1/things/things_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/things/things_russian.txt");
                    break;
                case VocabularyA1.FOOD:
                    initializeWords(englishWords, "vocabulary/A1/food/food_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/food/food_russian.txt");
                    break;
                case VocabularyA1.PRODUCTS:
                    initializeWords(englishWords, "vocabulary/A1/products/products_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/products/products_russian.txt");
                    break;
                case VocabularyA1.HOME:
                    initializeWords(englishWords, "vocabulary/A1/home/home_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/home/home_russian.txt");
                    break;
                case VocabularyA1.FAMILY:
                    initializeWords(englishWords, "vocabulary/A1/family/family_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/family/family_russian.txt");
                    break;
                case VocabularyA1.WEATHER:
                    initializeWords(englishWords, "vocabulary/A1/weather/weather_english.txt");
                    initializeWords(russianWords, "vocabulary/A1/weather/weather_russian.txt");
                    break;
                case VocabularyA2.NATURE:
                    initializeWords(englishWords, "vocabulary/A2/nature/nature_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/nature/nature_russian.txt");
                    break;
                case VocabularyA2.ANIMALS:
                    initializeWords(englishWords, "vocabulary/A2/animals/animals_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/animals/animals_russian.txt");
                    break;
                case VocabularyA2.FACE_PARTS:
                    initializeWords(englishWords, "vocabulary/A2/face_parts/face_parts_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/face_parts/face_parts_russian.txt");
                    break;
                case VocabularyA2.BODY_PARTS:
                    initializeWords(englishWords, "vocabulary/A2/body_parts/body_parts_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/body_parts/body_parts_russian.txt");
                    break;
                case VocabularyA2.CLOTHES:
                    initializeWords(englishWords, "vocabulary/A2/clothes/clothes_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/clothes/clothes_russian.txt");
                    break;
                case VocabularyA2.KITCHEN:
                    initializeWords(englishWords, "vocabulary/A2/kitchen/kitchen_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/kitchen/kitchen_russian.txt");
                    break;
                case VocabularyA2.FURNITURE:
                    initializeWords(englishWords, "vocabulary/A2/furniture/furniture_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/furniture/furniture_russian.txt");
                    break;
                case VocabularyA2.BEVERAGES:
                    initializeWords(englishWords, "vocabulary/A2/beverages/beverages_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/beverages/beverages_russian.txt");
                    break;
                case VocabularyA2.TIME:
                    initializeWords(englishWords, "vocabulary/A2/time/time_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/time/time_russian.txt");
                    break;
                case VocabularyA2.CITY:
                    initializeWords(englishWords, "vocabulary/A2/city/city_english.txt");
                    initializeWords(russianWords, "vocabulary/A2/city/city_russian.txt");
                    break;

            }
        }

        for (int i = 0; i < englishWords.size(); i++)
            vocabularyModel.add(new VocabularySelectionModel(englishWords.get(i),
                    russianWords.get(i), false));

        vocabularySelectionRecyclerView = findViewById(R.id.vocabulary_recycler_view);
        adapter = new VocabularySelectionAdapter(vocabularyModel, this);
        vocabularySelectionRecyclerView.setAdapter(adapter);
        vocabularySelectionRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initializeWords(List<String> list, String path) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open(path), StandardCharsets.UTF_8))) {
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                list.add(mLine);
            }
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