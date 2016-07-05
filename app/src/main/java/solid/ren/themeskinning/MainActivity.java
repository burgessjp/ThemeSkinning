package solid.ren.themeskinning;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.skinlibrary.listener.ILoaderListener;
import solid.ren.skinlibrary.load.SkinManager;

public class MainActivity extends SkinBaseActivity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
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

        Button btn_switch = (Button) findViewById(R.id.btn_switch);
        Log.i("test", btn_switch.getClass().toString());
        btn_switch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SkinManager.getInstance().loadSkin("theme.skin",
                                new ILoaderListener() {
                                    @Override
                                    public void onStart() {
                                        Toast.makeText(getApplicationContext(), "正在切换中", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onSuccess() {
                                        Toast.makeText(getApplicationContext(), "切换成功", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailed() {
                                        Toast.makeText(getApplicationContext(), "切换失败", Toast.LENGTH_SHORT).show();
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
