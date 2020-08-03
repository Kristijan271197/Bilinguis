package com.invictastudios.bilinguis.Additional;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.R;


public class AdditionalA1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additional_a1, container, false);

        CardView cardView = view.findViewById(R.id.a1_study_plan);

        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), AdditionalInformationPlan.class);
            intent.putExtra("level", 1);
            startActivity(intent);
        });


        return view;
    }
}