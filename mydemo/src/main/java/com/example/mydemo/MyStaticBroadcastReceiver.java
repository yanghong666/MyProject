package com.example.mydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by yanghong on 2018/10/25.
 */

public class MyStaticBroadcastReceiver  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);


    }


}
