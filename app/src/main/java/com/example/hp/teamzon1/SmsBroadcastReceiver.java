package com.example.hp.teamzon1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ActivityManager;
import java.util.List;
import android.content.ComponentName;
import java.lang.String;
import android.content.pm.PackageManager;
import java.util.Iterator;
import android.app.Activity;

public class SmsBroadcastReceiver extends BroadcastReceiver {
    EditText SMSm;
    String ch;
    public static final String SMS_BUNDLE = "pdus";

    private Context ctext;
    public void onReceive(Context context, Intent intent) {
        ctext=context;
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
            MapsActivity1 instan = MapsActivity1.instance();
            ParkActivity insta = ParkActivity.instance();
            HeadActivity instanc = HeadActivity.instance();
            if(isForeground("com.example.hp.teamzon1.MapsActivity1")==true)
                instan.updatemap(smsMessageStr);
            if(isForeground("com.example.hp.teamzon1.ParkActivity")==true)
                insta.update(smsMessageStr1);
            if(isForeground("com.example.hp.teamzon1.HeadActivity")==true)
                instanc.updateHead(smsMessageStr1);



            //ParkActivity insta = ParkActivity.instance();
            //insta.update(smsMessageStr1);

            //this will update the UI with message
            //SmsActivity inst = SmsActivity.instance();
            //inst.updateList(smsMessageStr);

        }
    }
    public boolean isForeground(String activityName){

        ActivityManager am = (ActivityManager) ctext.getSystemService(Context.ACTIVITY_SERVICE);
        List< ActivityManager.RunningTaskInfo > runningTaskInfo = am.getRunningTasks(1);

        ComponentName componentInfo = am.getRunningTasks(1).get(0).topActivity;
        Log.w("LABEL",am.getRunningTasks(1).get(0).topActivity.getClassName());
        if(am.getRunningTasks(1).get(0).topActivity.getClassName().equals(activityName)) return true;
        return false;
    }


    public void getRunning(){
        ActivityManager am = (ActivityManager)ctext.getSystemService(Context.ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = ctext.getPackageManager();
        while(i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo)(i.next());
            try {
                CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                Log.w("LABEL", c.toString());
                //runningApplications.add(c.toString());
            }catch(Exception e) {
                //Name Not Found Exception
            }
        }

    }
}