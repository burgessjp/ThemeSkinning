package solid.ren.themeskinning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.themeskinning.DataBean;
import solid.ren.themeskinning.R;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:21:15
 */
public class BasicFragment extends SkinBaseFragment {

    private RecyclerView recyclerview;

    private MaterialDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_baseskin, container, false);



        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setAdapter(new BaseQuickAdapter<DataBean>(R.layout.item_layout, getData()) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, DataBean item) {
                baseViewHolder.setText(R.id.tv_title, item.getTitle());
                baseViewHolder.setText(R.id.tv_content, item.getContent());
                baseViewHolder.setText(R.id.tv_date, item.getDate());
                Log.i("test", baseViewHolder.getView(R.id.tv_title).getClass().toString());
            }
        });
        dialog = new MaterialDialog.Builder(getContext())
                .title("换肤中")
                .content("请耐心等待")
                .canceledOnTouchOutside(false)
                .progress(false, 100, true).build();

        Button btn_switch = (Button) view.findViewById(R.id.btn_switch);

        btn_switch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SkinManager.getInstance().loadSkin("theme_style.skin",
                                new SkinLoaderListener() {
                                    @Override
                                    public void onStart() {
                                        Log.i("SkinLoaderListener", "正在切换中");
                                        dialog.show();
                                    }

                                    @Override
                                    public void onSuccess() {
                                        Log.i("SkinLoaderListener", "切换成功");
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onFailed(String errMsg) {
                                        Log.i("SkinLoaderListener", "切换失败:" + errMsg);
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onProgress(int progress) {
                                        Log.i("SkinLoaderListener", "皮肤文件下载中:" + progress);

                                    }
                                }

                        );
                    }
                }

        );

        view.findViewById(R.id.btn_switch_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinManager.getInstance().restoreDefaultTheme();
            }
        });



        return view;
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
