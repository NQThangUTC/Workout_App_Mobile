package com.example.workout_app.Activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.workout_app.Adapter.WorkoutAdapter;
import com.example.workout_app.Domain.Lession;
import com.example.workout_app.Domain.Workout;
import com.example.workout_app.R;
import com.example.workout_app.databinding.ActivityIntroBinding;
import com.example.workout_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        binding.view1.setLayoutManager((new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false)));
        binding.view1.setAdapter(new WorkoutAdapter((getData())));
    }
    private ArrayList<Workout> getData(){
        ArrayList<Workout> list = new ArrayList<>();
        list.add(new Workout("Running", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ","pic_1",160,"9 min",getLession_1()));
        list.add(new Workout("Stretching", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ","pic_2",230,"9 min",getLession_2()));
        list.add(new Workout("Yoga", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ","pic_3",180,"9 min",getLession_3()));

        return list;
    }
    private ArrayList<Lession> getLession_1(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lession 1","03:46","HBPMvFkpNgE","pic_1_1"));
        list.add(new Lession("Lession 2","03:41","K6I24WgiiPw","pic_1_2"));
        list.add(new Lession("Lession 3","01:57","Zc08v4YYOeA","pic_1_3"));

        return list;
    }

    private ArrayList<Lession> getLession_2(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lession 1","20:23","L3eImBAXT7I","pic_2_1"));
        list.add(new Lession("Lession 2","18:27","47Exgz07FlU","pic_2_2"));
        list.add(new Lession("Lession 3","32:25","OmLx8tmaQ-4","pic_2_3"));
        list.add(new Lession("Lession 4","07:52","w86EalEoFRY","pic_2_4"));

        return list;
    }
    private ArrayList<Lession> getLession_3(){
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lession 1","23:00","v7AYKMP6rOe","pic_3_1"));
        list.add(new Lession("Lession 2","27:00","Eml2xnoLpYE","pic_3_2"));
        list.add(new Lession("Lession 3","25:00","v7SN-d4qXx0","pic_3_3"));
        list.add(new Lession("Lession 4","21:00","LqXZ628YNj4","pic_3_4"));

        return list;
    }
}