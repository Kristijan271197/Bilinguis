package com.invictastudios.bilinguis.Additional;

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

public class AdditionalInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information);

        ViewPager2 grammarPager = findViewById(R.id.additional_info_pager);
        TabLayout grammarLayout = findViewById(R.id.additional_info_tabs);
        FragmentStateAdapter pagerAdapter = new ViewPagerAdapter(this);
        grammarPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(grammarLayout, grammarPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Beginner A1");
                    else if (position == 1)
                        tab.setText("Elementary English A2");
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
                return new AdditionalA1();
            else if (position == 1)
                return new AdditionalA2();
            else
                return null;
        }

        @Override
        public int getItemCount() {
            return CARD_ITEM_SIZE;
        }
    }
}