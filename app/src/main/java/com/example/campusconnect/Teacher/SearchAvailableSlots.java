package com.example.campusconnect.Teacher;

import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
EditText batchId;
AutoCompleteTextView day;
AppCompatButton button;
RecyclerView recyclerView;
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
        String [] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        ArrayAdapter<String> dropdownAdapter =new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, days);
        day.setThreshold(1);
        day.setAdapter(dropdownAdapter);

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
                            if(response.body()!=null) {
                                slots.clear();
                                slots.addAll(response.body());
                                adapter.notifyDataSetChanged();
                                progressDialog.dismiss();
                            }
                            if(slots.isEmpty()){
                                progressDialog.dismiss();
                                Toast.makeText(SearchAvailableSlots.this, "NO AVAILABLE SLOT!!", Toast.LENGTH_SHORT).show();
                            }
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