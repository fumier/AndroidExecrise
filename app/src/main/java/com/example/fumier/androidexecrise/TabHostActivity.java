package com.example.fumier.androidexecrise;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.support.v4.app.FragmentTabHost;

/**
 * 该实例是为了练习TabHost和Selector的使用
 */
public class TabHostActivity extends FragmentActivity implements TabHost.OnTabChangeListener {

    private static final String TAB_HOME = "tab_home";
    private static final String TAB_WEITAO = "tab_weitao";
    private static final String TAB_COMMUNITY = "tab_community";
    private static final String TAB_CART = "tab_cart";
    private static final String TAB_USER = "tab_user";

    private  FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec(TAB_HOME).setIndicator(createTabView("首页", R.drawable.ic_tab_home)), BlankFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec(TAB_WEITAO).setIndicator(createTabView("微淘",R.drawable.ic_tab_weitao)),BlankFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_COMMUNITY).setIndicator(createTabView("社区",R.drawable.ic_tab_community)),BlankFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_CART).setIndicator(createTabView("购物车",R.drawable.ic_tab_cart)),BlankFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_USER).setIndicator(createTabView("我的淘宝",R.drawable.ic_tab_user)),BlankFragment.class,null);

        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);

    }

    private View createTabView(String text, int icon) {
        TextView textView = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_main_tab_item, null);
        textView.setText(text);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0);
        return textView;
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
