package com.invictastudios.bilinguis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.invictastudios.bilinguis.R;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

    private Context context;
    private List<String> titles;
    private List<String> description;
    private boolean[] checkBoxes;

    public PlanAdapter(Context context, List<String> titles, List<String> description) {
        this.context = context;
        this.titles = titles;
        this.description = description;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additional_plan_adapter_item,
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
        private CheckBox passedCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.additional_plan_title);
            description = itemView.findViewById(R.id.additional_plan_description);
            passedCheckBox = itemView.findViewById(R.id.passed_check_box);
        }
    }
}
