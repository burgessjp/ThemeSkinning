package solid.ren.themeskinning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.themeskinning.DataBean;
import solid.ren.themeskinning.R;
import solid.ren.themeskinning.activity.SecondActivity;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:21:15
 */
public class BasicFragment extends SkinBaseFragment {

    private RecyclerView recyclerview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_baseskin, container, false);


        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setAdapter(new BaseQuickAdapter<DataBean>(R.layout.item_layout, getData()) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, DataBean item) {
                baseViewHolder.setText(R.id.tv_title, item.getTitle());
                baseViewHolder.setText(R.id.tv_content, item.getContent());
                baseViewHolder.setText(R.id.tv_date, item.getDate());
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SecondActivity.start(getContext());
                    }
                });
            }
        });
        return view;
    }


    private List<DataBean> getData() {
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            DataBean bean = new DataBean();
            bean.setTitle("title" + i);
            bean.setContent("content" + i);
            bean.setDate("2016-7-5");
            list.add(bean);
        }
        return list;
    }
}
