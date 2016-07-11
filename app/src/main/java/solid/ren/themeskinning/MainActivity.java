package solid.ren.themeskinning;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

public class MainActivity extends SkinBaseActivity {

    private RecyclerView recyclerview;
    private LinearLayout ll_dynamic_view;
    private MaterialDialog dialog;
    private Toolbar toolbar;
    private TabLayout tablayout;

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
        dynamicAddSkinEnableView(toolbar, "background", R.color.colorPrimaryDark);


        tablayout = (TabLayout) findViewById(R.id.tablayout);

        for (int i = 1; i < 6; i++) {
            tablayout.addTab(tablayout.newTab().setText("tab" + i));
        }
        dynamicAddSkinEnableView(tablayout, "tabLayoutIndicator", R.color.colorPrimaryDark);

        ll_dynamic_view = (LinearLayout) findViewById(R.id.ll_dynamic_view);

        createDynamicView();
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new BaseQuickAdapter<DataBean>(R.layout.item_layout, getData()) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, DataBean item) {
                baseViewHolder.setText(R.id.tv_title, item.getTitle());
                baseViewHolder.setText(R.id.tv_content, item.getContent());
                baseViewHolder.setText(R.id.tv_date, item.getDate());
                Log.i("test", baseViewHolder.getView(R.id.tv_title).getClass().toString());
            }
        });
        dialog = new MaterialDialog.Builder(this)
                .title("换肤中")
                .content("请耐心等待")
                .canceledOnTouchOutside(false)
                .progress(false, 100, true).build();

        Button btn_switch = (Button) findViewById(R.id.btn_switch);

        btn_switch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SkinManager.getInstance().loadSkin("theme.skin",
                                new ILoaderListener() {
                                    @Override
                                    public void onStart() {
                                        Log.i("ILoaderListener", "正在切换中");
                                        dialog.show();
                                    }

                                    @Override
                                    public void onSuccess() {
                                        Log.i("ILoaderListener", "切换成功");
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onFailed(String errMsg) {
                                        Log.i("ILoaderListener", "切换失败:" + errMsg);
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onProgress(int progress) {
                                        Log.i("ILoaderListener", "皮肤文件下载中:" + progress);

                                    }
                                }

                        );
                    }
                }

        );

        findViewById(R.id.btn_switch_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinManager.getInstance().restoreDefaultTheme();
            }
        });


        final String skinUrl = "https://raw.githubusercontent.com/burgessjp/ThemeSkinning/master/skinpackage/skin_net.skin";
        findViewById(R.id.btn_from_net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinManager.getInstance().loadSkinFromUrl(skinUrl, new ILoaderListener() {
                    @Override
                    public void onStart() {
                        Log.i("ILoaderListener", "正在切换中");
                        dialog.setContent("正在从网络下载皮肤文件");
                        dialog.show();
                    }

                    @Override
                    public void onSuccess() {
                        Log.i("ILoaderListener", "切换成功");
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailed(String errMsg) {
                        Log.i("ILoaderListener", "切换失败:" + errMsg);
                        dialog.setContent("换肤失败:" + errMsg);
                    }

                    @Override
                    public void onProgress(int progress) {
                        Log.i("ILoaderListener", "皮肤文件下载中:" + progress);
                        dialog.setProgress(progress);
                    }
                });
            }
        });
    }

    private void createDynamicView() {

        TextView textView1 = new TextView(this);
        textView1.setText("我是动态创建的TextView1");
        textView1.setTextColor(getResources().getColor(R.color.item_tv_title_color));
        dynamicAddSkinEnableView(textView1, "textColor", R.color.item_tv_title_color);
        ll_dynamic_view.addView(textView1);

    }


    private List<DataBean> getData() {
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataBean bean = new DataBean();
            bean.setTitle("title" + i);
            bean.setContent("content" + i);
            bean.setDate("2016-7-5");
            list.add(bean);
        }
        return list;
    }

}
