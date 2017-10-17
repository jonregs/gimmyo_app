package com.gimmyo.app.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.gimmyo.app.R;

/**
 * Created by jonegalado on 10/15/17, Gimmyo Project.
 */

public class LoginSignupVideoBgPage extends AppCompatActivity implements View.OnClickListener{

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_bg_page_login_signup);
        runVideo();

        Button loginButton = (Button) findViewById(R.id.gimmyLoginButton);
        loginButton.setOnClickListener(this);

        Button signupButton = (Button) findViewById(R.id.signupGimmyoButton);
        signupButton.setOnClickListener(this);

    }

    public void runVideo (){
        mVideoView = (VideoView) findViewById(R.id.bgVideoView);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg_video);

        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.gimmyLoginButton:
                Intent loginIntent = new Intent(LoginSignupVideoBgPage.this, Login.class);
                startActivity(loginIntent);
                break;
            case R.id.signupGimmyoButton:
                Intent signupIntent = new Intent(LoginSignupVideoBgPage.this, Signup.class);
                startActivity(signupIntent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        runVideo();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }
}