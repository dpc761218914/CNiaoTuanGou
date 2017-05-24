package com.dpc.toolbar_package;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class ToolbarActivity extends AppCompatActivity {

    private ToolbarHelper toolbarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        toolbarHelper = new ToolbarHelper(layoutResID,ToolbarActivity.this);
        Toolbar toolbar = toolbarHelper.getToolbar();
        setContentView(toolbarHelper.getmContentView());
        setSupportActionBar(toolbar);
        /**自定义一些自己的操作**/
        onCreateCustomToolbar(toolbar);
    }
    public void onCreateCustomToolbar(Toolbar toolbar) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
