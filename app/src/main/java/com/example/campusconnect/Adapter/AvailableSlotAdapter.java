package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.AvailableSlot;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class AvailableSlotAdapter extends RecyclerView.Adapter<AvailableSlotAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView slot;
        AppCompatButton btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            slot=itemView.findViewById(R.id.text);
            btn=itemView.findViewById(R.id.take);
        }
    }
    List<AvailableSlot> slots = new ArrayList<>();
    Context context;
    public AvailableSlotAdapter(List<AvailableSlot> slots, Context context) {
        this.slots=slots;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.slot_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.slot.setText(slots.get(position).getSlot());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return slots.size();
    }


}
