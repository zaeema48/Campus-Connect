package com.example.campusconnect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.R;
import com.example.campusconnect.ViewNotice;

import java.util.ArrayList;
import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,message;
        LinearLayout notice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.message);
            notice=itemView.findViewById(R.id.notice);
        }
    }

    Context context;
    List<NoticeModel> notices= new ArrayList<>();

    public NoticeAdapter(Context context, List<NoticeModel> notices) {
        this.context = context;
        this.notices = notices;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_notice_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notices.get(position).getNotificationTitle());
        holder.message.setText(notices.get(position).getNotificationMessage());
        holder.notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ViewNotice.class);
                intent.putExtra("title",notices.get(position).getNotificationTitle());
                intent.putExtra("message",notices.get(position).getNotificationMessage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notices.size();
    }

}
