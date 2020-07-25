package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.Additional.AdditionalInformation;
import com.invictastudios.bilinguis.Grammar.Grammar;
import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.Reading.Reading;
import com.invictastudios.bilinguis.Vocabulary.Vocabulary;
import com.invictastudios.bilinguis.Writing.Writing;
import com.invictastudios.bilinguis.model.MainCardsModel;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<MainCardsModel> items;

    public MainAdapter(Context context, List<MainCardsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_adapter_item,
                parent, false);
        return new ViewHolder(view, context, items);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainCardsModel mainCardsModel = items.get(position);
        holder.mainItemName.setText(mainCardsModel.getMainItemName());
        holder.mainItemImage.setImageResource(mainCardsModel.getMainItemImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mainItemName;
        private ImageView mainItemImage;

        public ViewHolder(@NonNull View itemView, Context context, List<MainCardsModel> items) {
            super(itemView);

            mainItemName = itemView.findViewById(R.id.main_item_name);
            mainItemImage = itemView.findViewById(R.id.main_item_image);
            itemView.setOnClickListener(v -> {
                switch (items.get(getAdapterPosition()).getMainItemName()) {
                    case "Grammar":
                        context.startActivity(new Intent(context.getApplicationContext(), Grammar.class));
                        break;
                    case "Vocabulary":
                        context.startActivity(new Intent(context.getApplicationContext(), Vocabulary.class));
                        break;
                    case "Writing":
                        context.startActivity(new Intent(context.getApplicationContext(), Writing.class));
                        break;
                    case "Reading":
                        context.startActivity(new Intent(context.getApplicationContext(), Reading.class));
                        break;
                    case "Additional Information":
                        context.startActivity(new Intent(context.getApplicationContext(), AdditionalInformation.class));
                        break;
                }

            });
        }
    }
}
