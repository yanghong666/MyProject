package com.example.mybroadcast;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.btn:

                Intent intent = new Intent();
                intent.setAction("com.example.mydemo.mystaticbroadcastreceiver");
                intent.setComponent( new ComponentName( "com.example.mydemo" ,"com.example.mydemo.MyStaticBroadcastReceiver") );
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent. FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);


                break;


            case R.id.btn1:

                Intent intent1 = new Intent();
                intent1.setAction("com.example");
                sendBroadcast(intent1);


                break;






            case R.id.btn2:
                Intent intent2 = new Intent();
                ComponentName componentName = new ComponentName("com.example.mydemo", "com.example.mydemo.MainActivity");
                intent2.setComponent(componentName);
                startActivity(intent2);

                break;



            case R.id.btn3:
                Intent intent3 = new Intent();
                ComponentName componentName3 = new ComponentName("com.example.mydemo", "com.example.mydemo.MainActivity");
                intent3.setComponent(componentName3);
                intent3.putExtra("BS","3");
                startActivityForResult(intent3,0);

                break;



            case R.id.btn4:
                Intent intent4 = new Intent();
                intent4.setAction("android.intent.action.demo");
                intent4.putExtra("BS","4");
                startActivityForResult(intent4,2);

                break;



        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==0||resultCode==1)
       {
           String xxx = data.getStringExtra("xxx");
           Toast.makeText(getApplication(),"回传的值P---"+xxx,Toast.LENGTH_SHORT).show();


       }else if(requestCode==2||resultCode==3)
        {
            String yyy = data.getStringExtra("yyy");
            Toast.makeText(getApplication(),"回传的值A---"+yyy,Toast.LENGTH_SHORT).show();

        }







    }
}
