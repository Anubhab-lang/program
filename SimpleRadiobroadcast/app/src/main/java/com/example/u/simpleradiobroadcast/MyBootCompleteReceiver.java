package com.example.u.simpleradiobroadcast;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by U on 2018/2/7.
 */

public class MyBootCompleteReceiver extends BootCompleteReceiver {
    public void onReceiver(Context context, Intent intent){
        Toast.makeText(context,"received in MyBroadcastReceiver",Toast.LENGTH_SHORT).show();
    }
}
