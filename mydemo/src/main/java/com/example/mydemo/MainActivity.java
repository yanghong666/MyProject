package com.example.mydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private Button gobackbtn;
    private String bs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gobackbtn = findViewById(R.id.gobackbtn);


        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example");
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,filter);




       gobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent0 = getIntent();
                if(intent0!=null)
                {
                      bs = intent0.getStringExtra("BS");
                      if(bs!=null){
                          if(bs.equals("3"))
                          {
                              Intent intent = new Intent();
                              intent.putExtra("xxx","123");
                              setResult(1,intent);
                              finish();
                          }else if(bs.equals("4")){

                              Intent intent4 = new Intent();
                              intent4.putExtra("yyy","456");
                              setResult(3,intent4);
                              finish();
                          }


                      }

                }

                  finish();

            }
        });




    }

     public  class MyReceiver extends BroadcastReceiver{


       @Override
       public void onReceive(Context context, Intent intent) {


        Toast.makeText(getApplication(),"接受成功",Toast.LENGTH_LONG).show();

           Intent intent1 = new Intent(context, MainActivity.class);
           context.startActivity(intent1);
           finish();


       }
   }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }













}
