package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplachScreen extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    private final int SPLASH_DISPLAY_LENGTH = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        imageView=findViewById(R.id.imge_app);
        textView=findViewById(R.id.text_anim);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.blink_animation);
       imageView.startAnimation(animation);
       animation.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {

           }

           @Override
           public void onAnimationEnd(Animation animation) {
               Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
               textView.setVisibility(View.VISIBLE);
               textView.startAnimation(anim);
               new Handler().postDelayed(new Runnable(){
                   @Override
                   public void run() {
                       /* Create an Intent that will start the Menu-Activity. */
                       Intent mainIntent = new Intent(SplachScreen.this,MainActivity.class);
                       SplachScreen.this.startActivity(mainIntent);
                       overridePendingTransition(  R.anim.slide_in_up, R.anim.slide_out_up );
                       SplachScreen.this.finish();
                   }
               }, SPLASH_DISPLAY_LENGTH);
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });
    }
}
