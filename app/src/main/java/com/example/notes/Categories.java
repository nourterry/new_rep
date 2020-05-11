package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes.Adapter.CategoriesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Categories extends AppCompatActivity {
FloatingActionButton button;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        View toolbar=findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Categories.this,MainActivity.class);
                Categories.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_in_up);
                Categories.this.finish();
            }
        });
        recyclerView=findViewById(R.id.recycle_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new CategoriesAdapter(this));
        findViewById(R.id.floating_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Categories.this,CreateCategory.class);
                Categories.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                Categories.this.finish();
            }
        });
        toolbar.findViewById(R.id.image_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Categories.this,Setting.class);
                Categories.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                Categories.this.finish();
            }
        });
    }
}
