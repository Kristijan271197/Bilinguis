package com.invictastudios.bilinguis.Additional;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.invictastudios.bilinguis.R;

public class AdditionalA2 extends Fragment {

    private CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additional_a2, container, false);

        cardView = view.findViewById(R.id.a2_study_plan);

        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), AdditionalInformationPlan.class);
            intent.putExtra("level", 2);
            startActivity(intent);
        });

        return view;
    }
}