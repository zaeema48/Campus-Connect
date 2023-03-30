package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.campusconnect.Adapter.PagerAdapter;
import com.example.campusconnect.Adapter.TeacherPagerAdapter;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TeacherPage extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem homeFragment, noticeFragment, profileFragment;
    ViewPager viewPager;
    TeacherPagerAdapter teacherPagerAdapter;

    public static TeacherModel publicTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_page);

        tabLayout = findViewById(R.id.tabLayout);
        homeFragment = findViewById(R.id.home);
        noticeFragment = findViewById(R.id.notice);
        profileFragment = findViewById(R.id.profile);
        viewPager = findViewById(R.id.fragment_container);

        publicTeacher=new TeacherModel();
        int id=getIntent().getIntExtra("teacherId",0);
        String name=getIntent().getStringExtra("teacherName");
        String password=getIntent().getStringExtra("teacherPaswd");
        publicTeacher.setTeacherId(id);
        publicTeacher.setTeacherName(name);
        publicTeacher.setTeacherPassword(password);
        SubjectModel subject= new SubjectModel();
        int subjectId=getIntent().getIntExtra("subjectId", 0);
        String subjectName=getIntent().getStringExtra("subjectName");
        subject.setSubjectId(subjectId);
        subject.setSubjectName(subjectName);
        publicTeacher.setSubject(subject);

        teacherPagerAdapter = new TeacherPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(teacherPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2)
                    teacherPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}