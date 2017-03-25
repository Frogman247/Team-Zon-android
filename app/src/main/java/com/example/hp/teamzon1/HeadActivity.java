package com.example.hp.teamzon1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class HeadActivity extends AppCompatActivity {
    EditText HeadText;
    String chhead;
    private static HeadActivity instanc;
    String[] separatehead;
    public static HeadActivity instance() {
        return instanc;
    }


    public void onStart() {
        super.onStart();
        instanc = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        HeadText = (EditText) findViewById(R.id.inputText3);
    }

    public void updateHead(final String smsMessage) {
        chhead=smsMessage;
        separatehead = chhead.split(":");
        HeadText.setText(separatehead[4]);
    }
}
