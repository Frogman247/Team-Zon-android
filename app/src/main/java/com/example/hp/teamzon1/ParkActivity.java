package com.example.hp.teamzon1;
import android.widget.ProgressBar;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.provider.Telephony;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;
import android.os.Build;
import android.util.Log;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import android.widget.EditText;
import android.support.design.widget.TextInputEditText;
import android.os.Handler;
import android.graphics.Color;
import android.content.res.ColorStateList;

import android.support.v4.widget.ContentLoadingProgressBar;
import java.util.ArrayList;

public class ParkActivity extends AppCompatActivity {

    //private static ParkActivity inst;
    //ArrayList<String> smsMessagesList = new ArrayList<String>();
    //ListView smsListView;
    //ArrayAdapter arrayAdapter;
    private static ParkActivity insta;
    ArrayAdapter arrayAdapter;
    EditText SMSm;
    EditText SMSmb;
    String phoneNumber1;
    String SMSBody1;
    String ch;
    String[] separate;
    int parkm;
    int parkmb;
    private ProgressBar mProgress;
    private ProgressBar mProgressb;
    public static ParkActivity instance() {
        return insta;
    }


    public void getSmsDetails(String phoneNumber, String SMSBody) {
        phoneNumber1 = phoneNumber;
        SMSBody1 = SMSBody;
    }
    public void onStart() {
        super.onStart();
        insta = this;
    }
   // public static Context parkcontext() {
    //    return insta.getApplicationContext();
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        SMSm = (EditText) findViewById(R.id.inputText);
        SMSmb = (EditText) findViewById(R.id.inputText2);
        mProgress = (ProgressBar) findViewById(R.id.progresspark);
        mProgress.setScaleY(6f);
        mProgressb = (ProgressBar) findViewById(R.id.progressparkback);
        mProgressb.setScaleY(6f);
        ch = new String();
        Log.v("TEXT","text");
        //SMSm.setText("Phone Number: " + phoneNumber1 + " " + "SMS: " +
          //      SMSBody1);
        Log.v("TEXT","text");

    }
    public void update(final String smsMessage) {



        ch=smsMessage;
        separate=ch.split(":");
        SMSm.setText(separate[2]);
        SMSmb.setText(separate[3]);
        parkm=Integer.parseInt(separate[2]);
        parkmb=Integer.parseInt(separate[3]);
        if(parkm>100){
            mProgress.setProgress(0);
        }
        else if(parkm>70){
            mProgress.setProgressTintList(ColorStateList.valueOf(Color.RED));
            mProgress.setProgress(100-parkm);

        }
        else if(parkm>40 && parkm<=70){
            mProgress.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            mProgress.setProgress(100-parkm);
        }
        else{
            mProgress.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            mProgress.setProgress(100-parkm);
        }
        if(parkmb>100){
            mProgressb.setProgress(0);
        }
        else if(parkmb>70){
            mProgressb.setProgressTintList(ColorStateList.valueOf(Color.RED));
            mProgressb.setProgress(100-parkmb);

        }
        else if(parkmb>40 && parkmb<=70){
            mProgressb.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            mProgressb.setProgress(100-parkmb);
        }
        else{
            mProgressb.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            mProgressb.setProgress(100-parkmb);
        }
        /*new Thread(new Runnable() {
            public void run() {
                while (parkm > 100) {


                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            if(parkm>70){
                                mProgress.setProgressTintList(ColorStateList.valueOf(Color.RED));
                                mProgress.setProgress(parkm);

                            }
                            else if(parkm>40 && parkm<=70){
                                mProgress.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                                mProgress.setProgress(parkm);
                            }
                            else{
                                mProgress.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                                mProgress.setProgress(parkm);
                            }
                        }
                    });
                }
            }
        }).start();
        */

    }


    /*public static ParkActivity instance() {
        return inst;
    }
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        inputText= (EditText) findViewById(R.id.inputText);
        //smsListView = (ListView) findViewById(R.id.SMSList);
        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, smsMessagesList);
        //smsListView.setAdapter(arrayAdapter);
        //smsListView.setOnItemClickListener(this);

        refreshSmsInbox();
    }
    public void refreshSmsInbox() {

        ContentResolver contentResolver = getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;

        do {
            String str = "SMS From: " + smsInboxCursor.getString(indexAddress) +
                    "\n" + smsInboxCursor.getString(indexBody) + "\n";
            inputText.setText(str);
        } while (smsInboxCursor.moveToNext());
    }

// Store EditText in Variable
    */

}
   /*public class SMSReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Bundle myBundle = intent.getExtras();
            SmsMessage[] messages = null;
            String strMessage = "";

            if (myBundle != null) {
                Object[] pdus = (Object[]) myBundle.get("pdus");

                messages = new SmsMessage[pdus.length];

                for (int i = 0; i < messages.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = myBundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    }
                    strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                    strMessage += " : ";
                    strMessage += messages[i].getMessageBody();
                    strMessage += "\n";
                }

                //Log.v("SMS", strMessage);
                Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
                // get EditText by id


// Store EditText in Variable

                strMessage = inputText.getText().toString();
                inputText.setText(strMessage);
            }
        }
    }
    */


