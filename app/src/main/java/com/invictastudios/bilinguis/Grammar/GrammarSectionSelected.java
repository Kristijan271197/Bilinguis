package com.invictastudios.bilinguis.Grammar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.invictastudios.bilinguis.R;

public class GrammarSectionSelected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_section_selected);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.getBoolean("image")) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ImageGrammarFragment fragment = new ImageGrammarFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } else {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                NoImageGrammarFragment fragment = new NoImageGrammarFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}