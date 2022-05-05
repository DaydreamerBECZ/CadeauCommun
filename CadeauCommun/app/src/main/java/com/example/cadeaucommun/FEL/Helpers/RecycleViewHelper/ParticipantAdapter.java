package com.example.cadeaucommun.FEL.Helpers.RecycleViewHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadeaucommun.BLL.Model.Participant;
import com.example.cadeaucommun.R;

import java.util.List;

public class ParticipantAdapter extends RecyclerView.Adapter<ParticipantsViewHolder> {
    List<Participant> participants;

    @NonNull
    @Override
    public ParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_participants, parent, false);
        if (participants.size() <= 0)
        {
            participants.add(new Participant("Aucun(e) participant(e)s", "", "", "", ""));
            notifyDataSetChanged();
        }
        return new ParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantsViewHolder holder, int position) {
        String fullname = participants.get(position).getfName() + " " + participants.get(position).getlName();
        holder.getFullName().setText(fullname);
    }

    @Override
    public int getItemCount() {
        try {
            return participants.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
