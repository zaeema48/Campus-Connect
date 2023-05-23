package com.example.campusconnect.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.API.TeacherApiInterface;
import com.example.campusconnect.Models.AvailableSlot;
import com.example.campusconnect.R;
import com.example.campusconnect.TeacherPage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableSlotAdapter extends RecyclerView.Adapter<AvailableSlotAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView slot;
        AppCompatButton takeSlot;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            slot=itemView.findViewById(R.id.text);
            takeSlot=itemView.findViewById(R.id.take);
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

        ProgressDialog progressDialog= new ProgressDialog(context);
        progressDialog.setTitle("Notifying students about the class...");
        holder.takeSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                TeacherApi.getTeacherApiInterface().bookExtraClass(slots.get(position)).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Class booked successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, TeacherPage.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "An error has occurred!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return slots.size();
    }


}
