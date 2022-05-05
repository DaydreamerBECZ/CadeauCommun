package com.example.cadeaucommun.FEL.Helpers.RecycleViewHelper;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cadeaucommun.R;

import org.w3c.dom.Text;

public class ParticipantsViewHolder extends RecyclerView.ViewHolder {
    private TextView fullName;
    private View container;

    public ParticipantsViewHolder (View itemView)
    {
        super(itemView);
        this.fullName = (TextView) itemView.findViewById(R.id.ParticipantNameTextView);
    }

    public TextView getFullName() {
        return fullName;
    }

    public void setFullName(TextView fullName) {
        this.fullName = fullName;
    }

    public View getContainer() {
        return container;
    }

    public void setContainer(View container) {
        this.container = container;
    }
}
