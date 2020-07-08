package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.model.VocabularySelectionModel;

import java.util.List;

public class VocabularySelectionAdapter extends RecyclerView.Adapter<VocabularySelectionAdapter.ViewHolder> {


    private List<VocabularySelectionModel> vocabularyModel;
    private Context context;

    public VocabularySelectionAdapter(List<VocabularySelectionModel> vocabularyModel, Context context) {
        this.vocabularyModel = vocabularyModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vocabulary_selected_section_adapter_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.englishWord.setText(vocabularyModel.get(position).getEnglishWord());
        holder.itemView.setOnClickListener(v -> {
            vocabularyModel.get(position).setShowTranslation(true);
            showText(position, holder);
        });
        showText(position, holder);


    }

    private void showText(int position, ViewHolder holder) {
        if (vocabularyModel.get(position).isShowTranslation())
            holder.russianWord.setText(vocabularyModel.get(position).getRussianWord());
        else
            holder.russianWord.setText("Show Translation");
    }

    @Override
    public int getItemCount() {
        return vocabularyModel.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView englishWord;
        private TextView russianWord;
        private Button playSoundButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            englishWord = itemView.findViewById(R.id.englishWord);
            russianWord = itemView.findViewById(R.id.russianWord);
            playSoundButton = itemView.findViewById(R.id.playSoundButton);
        }
    }
}
