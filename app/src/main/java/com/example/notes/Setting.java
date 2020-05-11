package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.notes.Adapter.MultiViewAdapter;
import com.example.notes.models.MultiView;

import java.util.ArrayList;

public class Setting extends AppCompatActivity {
    TextView name;
    RecyclerView recyclerView;
    ArrayList<MultiView> multiViews=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        View toolbar=findViewById(R.id.toolbar);
        name=toolbar.findViewById(R.id.new_name);
        recyclerView=findViewById(R.id.recycle_setting);
        name.setText("Setting");
        multiViews.add(new MultiView("Language","Your Selected Language is : en",R.drawable.ic_language,0));
        multiViews.add(new MultiView("Profile","Update Your Data",R.drawable.ic_profile,1));
        multiViews.add(new MultiView("About App","Let's Talked about App",R.drawable.ic_about_app,0));
        multiViews.add(new MultiView("About Course","Let's Talked about Course",R.drawable.ic_about_course,1));
        multiViews.add(new MultiView("Log Out","Wait your Return",R.drawable.ic_logout,0));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new MultiViewAdapter(multiViews,this));

        toolbar.findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Setting.this,Categories.class);
                Setting.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                Setting.this.finish();
            }
        });

    }
}
