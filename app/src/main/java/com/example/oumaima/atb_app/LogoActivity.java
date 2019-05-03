package com.example.oumaima.atb_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LogoActivity extends AppCompatActivity {

    ImageView atb_logo ;
    Animation anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);


        atb_logo=(ImageView) findViewById(R.id.logo);
        anime= AnimationUtils.loadAnimation(this,R.anim.logo_animation);

        atb_logo.setAnimation(anime);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (LogoActivity.this,LoginActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(LogoActivity.this,findViewById(R.id.logo),"atblogo");
                startActivity(intent,optionsCompat.toBundle());

            }
        },2200);
    }
    }

