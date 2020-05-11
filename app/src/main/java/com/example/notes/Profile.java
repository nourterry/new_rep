package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notes.models.User;

import io.realm.Realm;

public class Profile extends AppCompatActivity {
   TextView name;
   Realm realm;
   TextView sub,nameprofile,email,numbercategory,numbernotedone,numberwaitenote;
   EditText firstname,lastname,phone,emailn;
   Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        View toolbar=findViewById(R.id.toolbar);
        name=toolbar.findViewById(R.id.new_name);
        name.setText("Profile");
        sub=findViewById(R.id.text_sub_name_profile);
        nameprofile=findViewById(R.id.name_profile);
        email=findViewById(R.id.email_profile);
        numbercategory=findViewById(R.id.number_category);
        numbernotedone=findViewById(R.id.number_donenotes);
        numberwaitenote=findViewById(R.id.number_waitednotes);
        save=findViewById(R.id.butt_save);
        firstname=findViewById(R.id.name_new);
        lastname=findViewById(R.id.last_new);
        phone=findViewById(R.id.phone_new);
        emailn=findViewById(R.id.email_new);
        firstname.setFocusable(true);
        firstname.setEnabled(true);
        firstname.setFocusableInTouchMode(true);
        firstname.setClickable(true);
        firstname.setCursorVisible(true);
        firstname.requestFocus();
       final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        final User user=realm.where(User.class).equalTo("Firstname",ShareContent.name)
                .equalTo("Passward",ShareContent.passward).findFirst();
        nameprofile.setText(user.getFirstname()+" "+user.getLastname());
        email.setText(user.getEmail());
        sub.setText(user.getFirstname().substring(0,1));
        numbercategory.setText(user.getCategories().size()+"");
        int numberdone=0;
        int numbernot=0;
        for (int i=0;i<user.getCategories().size();i++) {
            for (int j = 0; j < user.getCategories().get(i).getNotes().size(); j++){
                if (user.getCategories().get(i).getNotes().get(j).isIschecked())
                    numberdone++;else numbernot++;
        }}
        numbernotedone.setText(""+numberdone);numberwaitenote.setText("" +numbernot);
        firstname.setText(user.getFirstname());
        lastname.setText(user.getLastname());
        phone.setText(user.getPhone());
        emailn.setText(user.getEmail());
      toolbar.findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,Categories.class);
                Profile.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_in_up);
                Profile.this.finish();
            }
        });

   save.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

// Add the buttons
           builder.setIcon(R.drawable.ic_app_icon);
           builder.setMessage("Do you want to save the changes?");
           builder.setTitle("Notes App");
           builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // User clicked OK button
                   realm.beginTransaction();
                   user.setFirstname(firstname.getText().toString());
                   user.setLastname(lastname.getText().toString());
                   user.setEmail(emailn.getText().toString());
                   user.setPhone(phone.getText().toString());
                   realm.commitTransaction();
                   ShareContent.name=user.getFirstname();


               }
           });
           builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // User cancelled the dialog
               }
           });
           AlertDialog dialog = builder.create();
           dialog.show();
// Set other dialog properties


       }
   });
}}
