package com.gimmyo.app.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.gimmyo.app.R;

/**
 * Created by jonegalado on 10/15/17, Gimmyo Project.
 */

public class Signup extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_gimmyo_layout);

        /*// Enable Local Data Store.
        Parse.enableLocalDatastore(this);

        *//*
         Parse Login Credentials
         URL: http://ec2-18-220-7-92.us-east-2.compute.amazonaws.com/apps/My%20Bitnami%20Parse%20API/browser/_User
         Login to Parse Server
         username: user
         password: j8yiiNOCeurK
         *//*
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("8812ae35cb75fe6d52f018ec0a8add5339b999e8")
                .clientKey("dc0190dd5f7ca905b849a6ab18d292c4602dec93")
                .server("http://ec2-18-220-7-92.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );*/
    }
}