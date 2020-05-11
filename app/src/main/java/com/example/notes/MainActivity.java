package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notes.models.User;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    TextView Signup;
    EditText name, passward;
    Button login;
    Realm realm;
    TextView error;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit_name);
        passward = findViewById(R.id.edit_passwardlogin);
        error = findViewById(R.id.text_error);
        error.setVisibility(View.GONE);
        sharedPreferences=getSharedPreferences("setting",MODE_PRIVATE);
      name.setText(sharedPreferences.getString("name",""));

        findViewById(R.id.login_butt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.init(getApplicationContext());
                realm = Realm.getDefaultInstance();
                User user = realm.where(User.class).equalTo("Firstname", name.getText().toString())
                        .equalTo("Passward", passward.getText().toString()).findFirst();
                if (user != null) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("name",name.getText().toString());
                    editor.apply();
                    ShareContent.name=name.getText().toString();
                    ShareContent.passward=passward.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Categories.class);
                    MainActivity.this.startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_down);
                    MainActivity.this.finish();

                } else {
                    error.setVisibility(View.VISIBLE);
                }

            }
        });
        findViewById(R.id.text_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_down);
                MainActivity.this.finish();
            }
        });
    }
}
