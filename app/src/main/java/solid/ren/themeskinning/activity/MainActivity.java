package solid.ren.themeskinning.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.HashMap;

import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.themeskinning.DataProvider;
import solid.ren.themeskinning.R;
import solid.ren.themeskinning.adapter.TabViewpagerAdapter;

public class MainActivity extends SkinBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("我是Toolbar");
        setSupportActionBar(toolbar);
        dynamicAddView(toolbar, "background", R.color.colorPrimaryDark);


        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        for (int i = 0; i < DataProvider.getTitleList().size(); i++) {
            tablayout.addTab(tablayout.newTab().setText(DataProvider.getTitleList().get(i)));
        }
        dynamicAddView(tablayout, "tabLayoutIndicator", R.color.colorPrimaryDark);


        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new TabViewpagerAdapter(getSupportFragmentManager(), DataProvider.getTitleList()));
        tablayout.setupWithViewPager(viewpager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                break;
            case R.id.action_load_default:
                SkinManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.action_load_local:
                SkinManager.getInstance().loadSkin("theme_style.skin",
                        new SkinLoaderListener() {
                            @Override
                            public void onStart() {
                                Log.i("SkinLoaderListener", "正在切换中");
                                //dialog.show();
                            }

                            @Override
                            public void onSuccess() {
                                Log.i("SkinLoaderListener", "切换成功");
                            }

                            @Override
                            public void onFailed(String errMsg) {
                                Log.i("SkinLoaderListener", "切换失败:" + errMsg);
                            }

                            @Override
                            public void onProgress(int progress) {
                                Log.i("SkinLoaderListener", "皮肤文件下载中:" + progress);

                            }
                        }

                );
                break;
            case R.id.action_night_mode:
                SkinManager.getInstance().NightMode();
                break;
            case R.id.action_from_net:
                fromNetWork();
                break;
            case R.id.action_switch_font:
                final HashMap<String, String> map = new HashMap<>(5);
                map.put("默认", null);
                map.put("时尚细黑", "SSXHZT.ttf");
                map.put("大梁体", "DLTZT.ttf");
                map.put("微软雅黑", "WRYHZT.ttf");
                new MaterialDialog.Builder(this)
                        .title("选择字体")
                        .items(map.keySet())
                        .itemsCallbackSingleChoice(1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                SkinManager.getInstance().loadFont(map.get(text));
                                return true;
                            }
                        })
                        .positiveText("确定")
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void fromNetWork() {
        SkinManager.getInstance().loadSkinFromUrl(DataProvider.netSkinUrl, new SkinLoaderListener() {
            @Override
            public void onStart() {
                Log.i("SkinLoaderListener", "正在切换中");
            }

            @Override
            public void onSuccess() {
                Log.i("SkinLoaderListener", "切换成功");
            }

            @Override
            public void onFailed(String errMsg) {
                Log.i("SkinLoaderListener", "切换失败:" + errMsg);
            }

            @Override
            public void onProgress(int progress) {
                Log.i("SkinLoaderListener", "皮肤文件下载中:" + progress);
            }
        });
    }
}
