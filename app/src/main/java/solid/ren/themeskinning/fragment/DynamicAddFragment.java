package solid.ren.themeskinning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.themeskinning.R;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:21:37
 */
public class DynamicAddFragment extends SkinBaseFragment {
    private LinearLayout ll_dynamic_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_add, container, false);
        ll_dynamic_view = (LinearLayout) view.findViewById(R.id.ll_dynamic_view);
        createDynamicView();
        return view;
    }

    private void createDynamicView() {

        for (int i = 0; i < 10; i++) {
            TextView textView1 = new TextView(getContext());
            textView1.setText("我是动态创建的TextView" + i + ",我也可以换肤");
            textView1.setTextColor(getResources().getColor(R.color.item_tv_title_color));

            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(20, 20, 20, 20);
            textView1.setLayoutParams(params);


            dynamicAddView(textView1, "textColor", R.color.item_tv_title_color);
            ll_dynamic_view.addView(textView1);
            dynamicAddFontView(textView1);
        }

    }
}
