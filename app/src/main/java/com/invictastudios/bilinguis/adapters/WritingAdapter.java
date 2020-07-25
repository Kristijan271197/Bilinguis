package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;

import java.util.List;

public class WritingAdapter extends RecyclerView.Adapter<WritingAdapter.ViewHolder> {

    private Context context;
    private List<String> titles;
    private List<String> description;

    public WritingAdapter(Context context, List<String> titles, List<String> description) {
        this.context = context;
        this.titles = titles;
        this.description = description;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.writing_adapter_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.description.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.writing_title);
            description = itemView.findViewById(R.id.writing_description);
        }
    }
}
