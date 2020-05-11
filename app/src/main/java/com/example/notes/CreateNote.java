package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notes.models.User;
import com.example.notes.models.note;

import io.realm.Realm;

public class CreateNote extends AppCompatActivity {
    TextView name;
    EditText notename,description;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        View toolbar=findViewById(R.id.toolbar);
        name=toolbar.findViewById(R.id.new_name);
        name.setText("New Note");
        notename=findViewById(R.id.name_note);
        description=findViewById(R.id.description_note);
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        findViewById(R.id.butt_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notename.getText().toString()==""||description.getText().toString()=="")
                    Toast.makeText(CreateNote.this, "You should fill all the field", Toast.LENGTH_SHORT).show();
              else{
                  User user=realm.where(User.class).equalTo("Firstname",ShareContent.name)
                        .equalTo("Passward",ShareContent.passward).findFirst();
                  realm.beginTransaction();
                  user.getCategories().get(ShareContent.position).getNotes().add(new note(notename.getText().toString(),description.getText().toString(),false));
                  realm.commitTransaction();
                    Intent intent=new Intent(CreateNote.this,CategoryName.class);
                    CreateNote.this.startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                    CreateNote.this.finish();
            }}
        });
        toolbar.findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CreateNote.this,CategoryName.class);
                CreateNote.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                CreateNote.this.finish();
            }
        });
    }
}
