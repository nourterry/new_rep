package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.notes.models.User;

import io.realm.Realm;

public class SignUp extends AppCompatActivity {
   Realm realm;
   EditText firstname,lastname,email,passward,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstname=findViewById(R.id.edit_firstname);
        lastname=findViewById(R.id.edit_lastname);
        email=findViewById(R.id.edit_email);
        passward=findViewById(R.id.edit_passward);
        phone=findViewById(R.id.edit_phone);
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             }
        });
        findViewById(R.id.butt_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((firstname.getText().toString().equals(""))||(lastname.getText().toString().equals(""))||(email.getText().toString().equals(""))||(passward.getText().toString().equals(""))||(phone.getText().toString().equals(""))) {
                    Toast.makeText(SignUp.this, "you_should_fill_all_the_field", Toast.LENGTH_SHORT).show();
                }
                else{
                    realm.beginTransaction();
                    User user= realm.createObject(User.class);
                    user.setFirstname(firstname.getText().toString());
                    user.setLastname(lastname.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassward(passward.getText().toString());
                    realm.commitTransaction();
                    if(user!=null){
                        ShareContent.name=user.getFirstname();
                        ShareContent.passward=user.getPassward();
                Intent intent=new Intent(SignUp.this,Categories.class);
                SignUp.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_down);
                SignUp.this.finish();
            }}}
        });

}}
