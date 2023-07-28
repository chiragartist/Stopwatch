package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatExtras;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int second=0;

        Button btn1;

        boolean isrunning;

        int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);


            startimer();
        }

    public void onclickstart(View view ){
        isrunning = true;
    }
    public void onclickresume(View view ){
       if(flag==0) {
           isrunning = true;
       }

    }
    public void onclickrestart(View view ) {
        isrunning=false;
        second=0;
    }
    public void onclickstop(View view ){
        isrunning=false;
    }
    public void startimer(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                        int s=second%60;
                        int h=second/60;
                        int m=second/60;
                    if(isrunning) {
                        second++;
                    }

                        String fromat=String.format(Locale.getDefault(),"%02d:%02d:%02d", h, m, s);

                        txt.setText(fromat);
                        handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
}

