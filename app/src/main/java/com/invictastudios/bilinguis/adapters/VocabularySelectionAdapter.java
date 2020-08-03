package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    private List<String> audioLinks;
    private Context context;
    Uri uri;
    private MediaPlayer mediaPlayer;

    public VocabularySelectionAdapter(List<VocabularySelectionModel> vocabularyModel, Context context, List<String> audioLinks, MediaPlayer mediaPlayer) {
        this.vocabularyModel = vocabularyModel;
        this.context = context;
        this.audioLinks = audioLinks;
        this.mediaPlayer = mediaPlayer;

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
            if (isNetworkAvailable()) {
                if (!vocabularyModel.get(position).isSoundIcon()) {
                    for (int i = 0; i < vocabularyModel.size(); i++)
                        vocabularyModel.get(i).setSoundIcon(false);
                    changeSoundIcon(position, holder);
                    notifyDataSetChanged();
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    for (int i = 0; i < vocabularyModel.size(); i++)
                        vocabularyModel.get(i).setSoundIcon(false);
                    changeSoundIcon(position, holder);
                    notifyDataSetChanged();
                } else {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    try {
                        uri = Uri.parse(audioLinks.get(position));
                        mediaPlayer.setDataSource(context, uri);
                        mediaPlayer.prepareAsync();
                        vocabularyModel.get(position).setSoundIcon(true);
                        changeSoundIcon(position, holder);
                        notifyDataSetChanged();
                    } catch (IOException e) {
                        Toast.makeText(context, R.string.no_audio_available, Toast.LENGTH_SHORT).show();
                    }
                    mediaPlayer.setOnPreparedListener(MediaPlayer::start);
                    mediaPlayer.setOnCompletionListener(mp -> {
                        mp.stop();
                        mp.reset();
                        for (int i = 0; i < vocabularyModel.size(); i++)
                            vocabularyModel.get(i).setSoundIcon(false);
                        changeSoundIcon(position, holder);
                        notifyDataSetChanged();
                    });
                }
            } else
                Toast.makeText(context.getApplicationContext(), R.string.internet_for_audios, Toast.LENGTH_LONG).show();
        });
        changeSoundIcon(position, holder);

    }

    private void changeSoundIcon(int position, ViewHolder holder) {
        if (vocabularyModel.get(position).isSoundIcon())
            holder.playSoundButton.setBackgroundResource(R.drawable.pause_icon);
        else
            holder.playSoundButton.setBackgroundResource(R.drawable.sound_icon);

    }

    private void showText(int position, ViewHolder holder) {
        if (vocabularyModel.get(position).isShowTranslation())
            holder.russianWord.setText(vocabularyModel.get(position).getRussianWord());
        else
            holder.russianWord.setText(R.string.show_translation);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
