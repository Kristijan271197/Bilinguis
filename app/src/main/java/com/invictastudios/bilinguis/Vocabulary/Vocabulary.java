package com.invictastudios.bilinguis.Vocabulary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.invictastudios.bilinguis.LockedSection;
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.Tests;

public class Vocabulary extends AppCompatActivity {

    public boolean vocabularyA1TestOne;
    public boolean vocabularyA1TestTwo;
    public boolean vocabularyA1TestThree;
    public boolean vocabularyA1TestFour;
    public boolean vocabularyA1TestFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        SharedPreferences sharedPreferences = getSharedPreferences(Tests.LEVELS_UNLOCK, Context.MODE_PRIVATE);
        vocabularyA1TestOne = sharedPreferences.getBoolean("VocabularyA1One", false);
        vocabularyA1TestTwo = sharedPreferences.getBoolean("VocabularyA1Two", false);
        vocabularyA1TestThree = sharedPreferences.getBoolean("VocabularyA1Three", false);
        vocabularyA1TestFour = sharedPreferences.getBoolean("VocabularyA1Four", false);
        vocabularyA1TestFive = sharedPreferences.getBoolean("VocabularyA1Five", false);

        ViewPager2 vocabularyPager = findViewById(R.id.vocabulary_pager);
        TabLayout vocabularyLayout = findViewById(R.id.vocabulary_tabs);
        FragmentStateAdapter pagerAdapter = new ViewPagerAdapter(this);
        vocabularyPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(vocabularyLayout, vocabularyPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Beginner A1");
                    else if (position == 1)
                        tab.setText("Elementary English A2");
                }).attach();


    }

    public class ViewPagerAdapter extends FragmentStateAdapter {
        private static final int CARD_ITEM_SIZE = 2;

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0)
                return new VocabularyA1();
            else if (position == 1) {
                if (vocabularyA1TestOne && vocabularyA1TestTwo && vocabularyA1TestThree &&
                        vocabularyA1TestFour && vocabularyA1TestFive)
                    return new VocabularyA2();
                else
                    return new LockedSection();

            } else
                return null;
        }

        @Override
        public int getItemCount() {
            return CARD_ITEM_SIZE;
        }
    }
}




