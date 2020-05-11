package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.notes.Adapter.CategoriesAdapter;
import com.example.notes.Adapter.NotesAdapter;

public class CategoryName extends AppCompatActivity {
    TextView name;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_name);
        View toolbar=findViewById(R.id.toolbar);
        name=toolbar.findViewById(R.id.categorynae_toolbar);
        name.setText(ShareContent.nameCategory);
        recyclerView=findViewById(R.id.recycle_note);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new NotesAdapter(this));
        toolbar.findViewById(R.id.linear_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryName.this,CreateNote.class);
                CategoryName.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                CategoryName.this.finish();
            }
        });
        toolbar.findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryName.this,Categories.class);
                CategoryName.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                CategoryName.this.finish();
            }
        });
    }
}
