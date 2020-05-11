package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.models.Category;
import com.example.notes.models.User;

import io.realm.Realm;

public class CreateCategory extends AppCompatActivity {
    Realm realm;
    EditText name,desciption;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        save=findViewById(R.id.butt_save);
        name=findViewById(R.id.name_category);
        desciption=findViewById(R.id.description_category);
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(name.getText().toString()==""||desciption.getText().toString()=="")
                   Toast.makeText(CreateCategory.this, "You should fill all the field", Toast.LENGTH_SHORT).show();
               else{
                   realm.beginTransaction();
                   User user=realm.where(User.class).equalTo("Firstname",ShareContent.name)
                           .equalTo("Passward",ShareContent.passward).findFirst();
                   user.getCategories().add(new Category(name.getText().toString(),desciption.getText().toString()));
                   realm.commitTransaction();
                   Toast.makeText(CreateCategory.this, "Saved", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(CreateCategory.this,Categories.class);
                   CreateCategory.this.startActivity(intent);
                   overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                   CreateCategory.this.finish();
               }
            }
        });
    }
}
