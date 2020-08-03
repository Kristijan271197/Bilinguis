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

    private FragmentStateAdapter pagerAdapter;
    public boolean grammarA1TestOne;
    public boolean grammarA1TestTwo;
    public boolean grammarA1TestThree;
    public boolean grammarA1TestFour;
    public boolean grammarA1TestFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        SharedPreferences sharedPreferences = getSharedPreferences(Tests.LEVELS_UNLOCK, Context.MODE_PRIVATE);
        grammarA1TestOne = sharedPreferences.getBoolean("GrammarA1One", false);
        grammarA1TestTwo = sharedPreferences.getBoolean("GrammarA1Two", false);
        grammarA1TestThree = sharedPreferences.getBoolean("GrammarA1Three", false);
        grammarA1TestFour = sharedPreferences.getBoolean("GrammarA1Four", false);
        grammarA1TestFive = sharedPreferences.getBoolean("GrammarA1Five", false);


        ViewPager2 grammarPager = findViewById(R.id.grammar_pager);
        TabLayout grammarLayout = findViewById(R.id.grammar_tabs);
        pagerAdapter = new ViewPagerAdapter(this);
        grammarPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(grammarLayout, grammarPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Beginner A1");
                    else if (position == 1)
                        tab.setText("Elementary English A2");
                }).attach();


    }

    @Override
    protected void onResume() {
        super.onResume();
        pagerAdapter.notifyDataSetChanged();
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
                return new GrammarA1();
            else if (position == 1) {
                if (grammarA1TestOne && grammarA1TestTwo && grammarA1TestThree &&
                        grammarA1TestFour && grammarA1TestFive)
                    return new GrammarA2();
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
