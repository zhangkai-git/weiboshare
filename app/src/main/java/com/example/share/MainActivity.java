package com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String APP_KY = "1731724173";
    private static final String REDIRECT_URL = "http://www.sina.com";
    private static final String SCOPE = "email,direct_messages_read,direct_messages_write," +
            "friendships_groups_read,friendships_groups_write,statuses_to_me_read," +
            "follow_app_official_microblog," + "invitation_write";
    private IWBAPI mWBAPI;
    private Button mClientShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClientShare = findViewById(R.id.btn_share);
        mClientShare.setOnClickListener(this);
        initSdk();
    }

    private void initSdk() {
        AuthInfo authInfo = new AuthInfo(this, APP_KY, REDIRECT_URL, SCOPE);
        mWBAPI = WBAPIFactory.createWBAPI(this);
        mWBAPI.registerApp(this, authInfo);
    }


    @Override
    public void onClick(View v) {
        if (v == mClientShare) {
            Intent intent = new Intent(MainActivity.this, ShareActivity.class);
            startActivity(intent);
        }
    }
}