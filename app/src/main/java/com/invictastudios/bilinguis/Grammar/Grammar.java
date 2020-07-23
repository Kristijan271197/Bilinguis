package com.invictastudios.bilinguis.Grammar;

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

public class Grammar extends AppCompatActivity {

    private ViewPager2 grammarPager;
    private FragmentStateAdapter pagerAdapter;
    private TabLayout grammarLayout;
    public int grammarA1TestOne;
    public int grammarA1TestTwo;
    public int grammarA1TestThree;
    public int grammarA1TestFour;
    public int grammarA1TestFive;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        sharedPreferences = getSharedPreferences(Tests.LEVELS_UNLOCK, Context.MODE_PRIVATE);
        grammarA1TestOne = sharedPreferences.getInt("GrammarA1One", 0);
        grammarA1TestTwo = sharedPreferences.getInt("GrammarA1Two", 0);
        grammarA1TestThree = sharedPreferences.getInt("GrammarA1Three", 0);
        grammarA1TestFour = sharedPreferences.getInt("GrammarA1Four", 0);
        grammarA1TestFive = sharedPreferences.getInt("GrammarA1Five", 0);

        grammarPager = findViewById(R.id.grammar_pager);
        grammarLayout = findViewById(R.id.grammar_tabs);
        pagerAdapter = new ViewPagerAdapter(this);
        grammarPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(grammarLayout, grammarPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Beginner A1");
                    else if (position == 1)
                        tab.setText("Beginner A2");
                }).attach();


    }

    public static class ViewPagerAdapter extends FragmentStateAdapter {
        private static final int CARD_ITEM_SIZE = 2;
        Grammar grammar = new Grammar();

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0)
                return new GrammarA1();
            else if (position == 1) {
                if (grammar.grammarA1TestOne < 7 || grammar.grammarA1TestTwo < 8 ||
                        grammar.grammarA1TestThree < 7 || grammar.grammarA1TestFour < 8 ||
                        grammar.grammarA1TestFive < 7)
                    return new LockedSection();
                else
                    return new GrammarA2();
            } else
                return null;
        }

        @Override
        public int getItemCount() {
            return CARD_ITEM_SIZE;
        }
    }
}
