package com.example.yellowbook.launch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yellowbook.MainActivity;
import com.example.yellowbook.R;

public class splashscreen extends AppCompatActivity {
    private static int splash_timer=2000;
    ImageView logo;
    TextView title;
    Animation sideanim,bottomanim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logo=findViewById(R.id.logo);
        title=findViewById(R.id.title);
        sideanim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        logo.setAnimation(sideanim);
        title.setAnimation(bottomanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashscreen.this, MainActivity.class);
                startActivity(Intent);
                finish();
            }
        },splash_timer)
    }
}