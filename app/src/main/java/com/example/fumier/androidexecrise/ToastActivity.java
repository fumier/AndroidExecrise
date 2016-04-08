package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ToastActivity extends Activity implements View.OnClickListener{

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_toast);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Default Toast",Toast.LENGTH_LONG);
            toast.show();
        } else if (v.getId() == R.id.button2) {
            LayoutInflater inflater=getLayoutInflater();
            View layout=inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
            TextView textView=(TextView)layout.findViewById(R.id.text);
            textView.setText("This is a custom Toast");
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }

    }
}
