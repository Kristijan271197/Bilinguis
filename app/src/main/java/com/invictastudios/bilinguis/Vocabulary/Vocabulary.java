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

    private ViewPager2 vocabularyPager;
    private FragmentStateAdapter pagerAdapter;
    private TabLayout vocabularyLayout;
    public int vocabularyA1Test;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        sharedPreferences = getSharedPreferences(Tests.LEVELS_UNLOCK, Context.MODE_PRIVATE);
        vocabularyA1Test = sharedPreferences.getInt("VocabularyA1", 0);

        vocabularyPager = findViewById(R.id.vocabulary_pager);
        vocabularyLayout = findViewById(R.id.vocabulary_tabs);
        pagerAdapter = new ViewPagerAdapter(this);
        vocabularyPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(vocabularyLayout, vocabularyPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Beginner A1");
                    else if (position == 1)
                        tab.setText("Beginner A2");
                }).attach();


    }

    public static class ViewPagerAdapter extends FragmentStateAdapter {
        private static final int CARD_ITEM_SIZE = 2;
        private Vocabulary vocabulary = new Vocabulary();

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0)
                return new VocabularyA1();
            else if (position == 1) {
                if (vocabulary.vocabularyA1Test < 34)
                    return new LockedSection();
                else
                    return new VocabularyA2();
            } else
                return null;
        }

        @Override
        public int getItemCount() {
            return CARD_ITEM_SIZE;
        }
    }
}




