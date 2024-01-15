package com.example.broadcastexp8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    public void onReceive(Context context,Intent intent){
        if(isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context,"Airplane Mode is ON!",Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(context,"Airplane Mode is OFF!",Toast.LENGTH_LONG).show();
        }
    }

    private static boolean isAirplaneModeOn(Context applicationContext) {
        return Settings.System.getInt(applicationContext.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0)!=0;
    }
}


