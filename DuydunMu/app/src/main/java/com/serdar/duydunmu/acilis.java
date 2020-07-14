package com.serdar.duydunmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class acilis extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acilis);

        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(acilis.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }


}
