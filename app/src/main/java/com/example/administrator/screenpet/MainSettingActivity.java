package com.example.administrator.screenpet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import wechat_msg.*;

public class MainSettingActivity extends AppCompatActivity implements MyMessage {

    private ComeWxMessage comeWxMessage;
    private MyMessage myMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_setting);

        myMessage=new MainSettingActivity();
        comeWxMessage=new ComeWxMessage(myMessage,this);
        comeWxMessage.toggleNotificationListenerService();
        comeWxMessage.openSetting();

        Button startFloatWindow = (Button)findViewById(R.id.start_float_window);
        startFloatWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainSettingActivity.this, FloatWindowService.class);
                startService(intent);
               // finish();
            }
        });

        Button btn_clock = (Button)findViewById(R.id.add_clock);
        btn_clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "set clock", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_add_schedule = (Button)findViewById(R.id.add_schedule);
        btn_add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "add schedule", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_customize = (Button)findViewById(R.id.customize);
        btn_customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "customize your pet", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_adopt = (Button)findViewById(R.id.adopt);
        btn_adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "adopt a new pet", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_setting = (Button)findViewById(R.id.setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "setting", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void comeWxMessage() {
        Log.e("AAA","====回调中，收到微信消息===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        comeWxMessage.unRegistBroadcast();
    }
}
