package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//该代码实例参考https://github.com/keeganlee/kstyle.git
public class SelectorActivity extends Activity implements View.OnClickListener{

    private Button activateBtn;
    private Button selectBtn;
    private ListView listView;
    private ArrayList<String> mArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        activateBtn=(Button)findViewById(R.id.btn_activate);
        activateBtn.setOnClickListener(this);

        selectBtn=(Button)findViewById(R.id.btn_selected);
        selectBtn.setOnClickListener(this);

        listView=(ListView)findViewById(R.id.list);
        getData();
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectorActivity.this, "Item Click on " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private ArrayList<String> getData(){
        mArrayList.add("测试数据0");
        mArrayList.add("测试数据1");
        mArrayList.add("测试数据2");
        mArrayList.add("测试数据3");
        mArrayList.add("测试数据4");
        mArrayList.add("测试数据5");
        return mArrayList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selector, menu);
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
        if (v==activateBtn){
            if(activateBtn.isActivated()){
                activateBtn.setActivated(false);
                activateBtn.setText("未激活");
            }else{
                activateBtn.setActivated(true);
                activateBtn.setText("已激活");
            }
        }else if(v==selectBtn){
            if(selectBtn.isSelected()){
                selectBtn.setSelected(false);
                selectBtn.setText("未选中");
            }else{
                selectBtn.setSelected(true);
                selectBtn.setText("已选中");
            }
        }

    }


    class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        @Override
        public int getCount() {
            inflater= LayoutInflater.from(SelectorActivity.this);
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                convertView=inflater.inflate(R.layout.item_list,parent,false);
                holder=new ViewHolder();
                holder.titleText=(TextView)convertView.findViewById(R.id.txt_title);
                holder.button=(Button)convertView.findViewById(R.id.btn);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }

            holder.titleText.setText(mArrayList.get(position));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SelectorActivity.this,"Button"+ position + "click",Toast.LENGTH_LONG).show();
                }
            });

            return convertView;
        }
    }

    class ViewHolder{
        TextView titleText;
        Button button;
    }

}
