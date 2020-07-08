package com.invictastudios.bilinguis.Vocabulary;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.invictastudios.bilinguis.R;

public class Vocabulary extends AppCompatActivity {

    private ViewPager2 vocabularyPager;
    private FragmentStateAdapter pagerAdapter;
    private TabLayout vocabularyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

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

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0)
                return new VocabularyA1();
            else if (position == 1)
                return new VocabularyA2();
            else
                return null;
        }

        @Override
        public int getItemCount() {
            return CARD_ITEM_SIZE;
        }
    }
}




