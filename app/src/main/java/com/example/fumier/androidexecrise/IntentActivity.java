package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class IntentActivity extends Activity implements View.OnClickListener {

    private Button emailButton;
    private Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        emailButton=(Button)findViewById(R.id.email_button);
        browserButton=(Button)findViewById(R.id.browser_button);
        emailButton.setOnClickListener(this);
        browserButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent, menu);
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
        }else if (item.getItemId()==R.id.share){
            ShareDialogActivity.startShare(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.email_button){
            Intent email=new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
            String[] recipients=new String[]{"fumier@163.com"};
            email.putExtra(Intent.EXTRA_EMAIL,recipients);
            email.putExtra(Intent.EXTRA_SUBJECT,"Test");
            email.putExtra(Intent.EXTRA_TEXT,"This is a test");
            email.setType("text/plain");
            startActivity(Intent.createChooser(email, "choose an email client from...."));
        }else if (v.getId()==R.id.browser_button){
            String str="chengqianjiayou";
            Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,str);
            startActivity(intent);
        }

    }
}
