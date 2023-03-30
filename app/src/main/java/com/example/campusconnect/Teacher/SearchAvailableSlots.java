package com.example.campusconnect.Teacher;

import static com.example.campusconnect.TeacherPage.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Adapter.AvailableSlotAdapter;
import com.example.campusconnect.Models.AvailableSlot;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAvailableSlots extends AppCompatActivity {
EditText batchId, day;
AppCompatButton button;
RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_available_slots);
        batchId=findViewById(R.id.batchId);
        day=findViewById(R.id.enterDay);
        button=findViewById(R.id.searchButton);
        recyclerView=findViewById(R.id.slotRecyclerView);

        ProgressDialog progressDialog=new ProgressDialog(SearchAvailableSlots.this);
        progressDialog.setTitle("Fetching Available Slots...");

        int teacherId=publicTeacher.getTeacherId();

        List<AvailableSlot> slots= new ArrayList<>();
        AvailableSlotAdapter adapter= new AvailableSlotAdapter(slots,SearchAvailableSlots.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchAvailableSlots.this));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batch_id = batchId.getText().toString() ;
                String slotDay = day.getText().toString();
                if(!batch_id.isEmpty() && !slotDay.isEmpty()){
                    progressDialog.show();
                    TeacherApi.getTeacherApiInterface().availableSlot(teacherId, batch_id, slotDay).enqueue(new Callback<List<AvailableSlot>>() {
                        @Override
                        public void onResponse(Call<List<AvailableSlot>> call, Response<List<AvailableSlot>> response) {
                            slots.clear();
                            slots.addAll(response.body());
                            adapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<AvailableSlot>> call, Throwable t) {

                        }
                    });
                }else
                    Toast.makeText(SearchAvailableSlots.this, "Enter Batch Id and Slot Day", Toast.LENGTH_SHORT).show();
            }
        });
    }
}