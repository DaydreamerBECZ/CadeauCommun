package com.example.cadeaucommun.FEL.Helpers.RecycleViewHelper;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadeaucommun.R;

public class EventsViewHolder extends RecyclerView.ViewHolder {
    TextView title_txt;
    TextView desc_txt;
    TextView startDate;
    TextView endDate;

    public EventsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title_txt = itemView.findViewById(R.id.titleView_lbl);
        this.desc_txt = itemView.findViewById(R.id.descriptionView_lbl);
        this.startDate = itemView.findViewById(R.id.startDateView_lbl);
        this.endDate = itemView.findViewById(R.id.endDateView_lbl );
    }
}
