package com.example.u.simpleradiobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by U on 2018/2/7.
 */

public class BootCompleteReceiver extends BroadcastReceiver{
 @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Boot Complete",Toast.LENGTH_LONG).show();
     }
}
