package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentFilterActivity extends Activity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);
        editText=(EditText)findViewById(R.id.recipient);

        Button sms1=(Button)findViewById(R.id.sendto_sms);
        sms1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String uri="smsto:"+editText.getText().toString();
                Intent intent=new Intent(android.content.Intent.ACTION_SENDTO, Uri.parse(uri));
                startActivity(intent);
            }
        });

        Button sms2=(Button)findViewById(R.id.smsintent_sms);
        sms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="smsto:"+editText.getText().toString();
                Intent intent=new Intent("com.example.fumier.androidexecrise.SMS_INTENT",Uri.parse(uri));
                intent.putExtra("from","androidexecrise");
                startActivity(intent);
            }
        });
    }
}
