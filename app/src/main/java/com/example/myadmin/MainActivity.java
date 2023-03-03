package com.example.myadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ImageButton imgStar= findViewById(R.id.btnStar);
//        ImageButton imgBall= findViewById(R.id.btnBall);
//        ImageView btnStar= findViewById(R.id.imgStar);
//        ImageView btnBall= findViewById(R.id.imgBall);
//
//        MediaPlayer button4 = MediaPlayer.create(this, R.raw.clapping);
//        button4.start();
//
////        button4.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.clapping);
////                mediaPlayer.start();
////            }
////        });
//       btnBall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //hide star
////                ImageView imgStar= findViewById(R.id.btnStar);
////                imgStar.setAlpha(0f);
//                //show ball
////                ImageView imgBall= findViewById(R.id.btnBall);
////                imgBall.setAlpha(1f);
//                imgStar.animate().alpha(0).setDuration(2000);
//
//                imgBall.animate().alpha(1).setDuration(2000);
//            }
//        });
//        btnStar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imgBall.animate().alpha(0).setDuration(2000);
//
//                imgStar.animate().alpha(1).setDuration(2000);
//            }
//        });
//    }
    private ImageView character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set default display character
        character = findViewById(R.id.star);

        //spin
        Button btnSpin = findViewById(R.id.btnSpin);
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.animate().rotationBy(360*2).setDuration(1000);
            }
        });
        //jump
        Button btnJump = findViewById(R.id.btnJump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.animate().translationYBy(-200).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        character.animate().translationYBy(200).setDuration(1000);
                    }
                });
            }
        });

        //clap
        Button btnClap = findViewById(R.id.btnClap);
        btnClap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.clapping);
                mediaPlayer.start();
            }
        });
    }

    public void onCharacterClick(View view) {
        if (view == findViewById(R.id.btnStar)) {       //click on button ballStar
            character = findViewById(R.id.star);

            findViewById(R.id.star).animate().alpha(1).setDuration(1000); //star is displayed in 1000
            findViewById(R.id.ball).animate().alpha(0).setDuration(1000); // ball is disappear in 1000
        }else if (view == findViewById(R.id.btnBall)) {
            character = findViewById(R.id.ball);

            findViewById(R.id.ball).animate().alpha(1).setDuration(1000);
            findViewById(R.id.star).animate().alpha(0).setDuration(1000);
        }

    }

}