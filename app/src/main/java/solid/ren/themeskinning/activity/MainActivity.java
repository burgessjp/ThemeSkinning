package solid.ren.themeskinning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.skinlibrary.listener.ILoaderListener;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.themeskinning.DataBean;
import solid.ren.themeskinning.DataProvider;
import solid.ren.themeskinning.R;
import solid.ren.themeskinning.adapter.TabViewpagerAdapter;

public class MainActivity extends SkinBaseActivity {


    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("我是Toolbar");
        setSupportActionBar(toolbar);
        dynamicAddView(toolbar, "background", R.color.colorPrimaryDark);


        tablayout = (TabLayout) findViewById(R.id.tablayout);

        for (int i = 0; i < DataProvider.getTitleList().size(); i++) {
            tablayout.addTab(tablayout.newTab().setText(DataProvider.getTitleList().get(i)));
        }
        dynamicAddView(tablayout, "tabLayoutIndicator", R.color.colorPrimaryDark);


        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new TabViewpagerAdapter(getSupportFragmentManager(), DataProvider.getTitleList()));
        tablayout.setupWithViewPager(viewpager);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
