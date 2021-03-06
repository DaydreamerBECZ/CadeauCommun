package com.example.cadeaucommun.FEL.Helpers.EventContext;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cadeaucommun.BLL.Model.Evenement;
import com.example.cadeaucommun.R;

import java.time.LocalDate;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventsViewHolder> {
    List<Evenement> evenements;

    public EventAdapter(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_event, parent, false);
        if(evenements.size() <= 0){
            evenements.add(new Evenement("Placeholder event", "Il n'y a aucun évènement afficher présentement.", null, null));
            notifyDataSetChanged();
        }
        return new EventsViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        String title = evenements.get(position).getTitle();
        holder.title_txt.setText(title);
        holder.desc_txt.setText(evenements.get(position).getDescription());
        holder.startDate.setText(evenements.get(position).getBeginDate().toString());
        holder.endDate.setText(evenements.get(position).getBeginDate().toString());
    }

    @Override
    public int getItemCount() {
        try {
            return evenements.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
