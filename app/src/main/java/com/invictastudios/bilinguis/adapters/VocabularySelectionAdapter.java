package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;
import com.invictastudios.bilinguis.model.VocabularySelectionModel;

import java.io.IOException;
import java.util.List;

public class VocabularySelectionAdapter extends RecyclerView.Adapter<VocabularySelectionAdapter.ViewHolder> {


    private List<VocabularySelectionModel> vocabularyModel;
    private Context context;
    Uri uri;
    private String url;
    private MediaPlayer mediaPlayer;

    public VocabularySelectionAdapter(List<VocabularySelectionModel> vocabularyModel, Context context) {
        this.vocabularyModel = vocabularyModel;
        this.context = context;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        url = "https://firebasestorage.googleapis.com/v0/b/bilinguis-248b7.appspot.com/o/Vocabulary%2FA1%2FGreetings%2Fhi.wav?alt=media&token=9784ac7b-2009-4236-9089-af17b1ba04ee";
        uri = Uri.parse(url);
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


        holder.playSoundButton.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                holder.playSoundButton.setBackgroundResource(R.drawable.sound_icon);
            } else {
                try {
                    mediaPlayer.setDataSource(context, uri);
                    mediaPlayer.prepareAsync();
                    holder.playSoundButton.setBackgroundResource(R.drawable.pause_icon);
                } catch (IOException e) {
                    Toast.makeText(context, "No audio available", Toast.LENGTH_SHORT).show();
                }
                mediaPlayer.setOnPreparedListener(MediaPlayer::start);
                mediaPlayer.setOnCompletionListener(mp -> {
                    mp.stop();
                    mp.reset();
                    holder.playSoundButton.setBackgroundResource(R.drawable.sound_icon);
                });
            }
        });
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
