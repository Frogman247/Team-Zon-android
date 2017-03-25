package com.example.hp.teamzon1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import android.app.ActivityManager;
import java.util.List;
import android.content.ComponentName;
import java.lang.String;
import android.app.Activity;

public class IncomingSms extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            String smsMessageStr1="";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();

                //smsMessageStr += "SMS From: " + address + "\n";
                smsMessageStr += smsBody;
                smsMessageStr1 += smsBody;
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
            //MapsActivity1 instan = MapsActivity1.instance();
           // ParkActivity insta = ParkActivity.instance();

            //insta.update(smsMessageStr);




            //ParkActivity insta = ParkActivity.instance();
            //insta.update(smsMessageStr1);

            //this will update the UI with message
            //SmsActivity inst = SmsActivity.instance();
            //inst.updateList(smsMessageStr);

        }
    }
    public boolean isForeground(final Context context){

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List< ActivityManager.RunningTaskInfo > runningTaskInfo = am.getRunningTasks(1);

        ComponentName componentInfo = runningTaskInfo.get(0).topActivity;
        if(componentInfo.getPackageName().equals(context.getPackageName())) return true;
        return false;
    }
}