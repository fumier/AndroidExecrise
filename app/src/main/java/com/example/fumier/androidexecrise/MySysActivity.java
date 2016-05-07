package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MySysActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sys);

        String output=null;
        TextView dataIntent=(TextView)findViewById(R.id.output_intent);

        Uri uri=getIntent().getData();
        Bundle extras=getIntent().getExtras();

        output=uri.toString();

        if(extras!=null){
            output=output+"from"+extras.getString("from");
        }
        dataIntent.setText(output);
    }
}
