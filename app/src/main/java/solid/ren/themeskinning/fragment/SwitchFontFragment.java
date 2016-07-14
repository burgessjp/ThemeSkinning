package solid.ren.themeskinning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.HashMap;

import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.themeskinning.R;
import solid.ren.themeskinning.activity.TestActivity;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:22:07
 */
public class SwitchFontFragment extends SkinBaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_switch_font, container, false);
        view.findViewById(R.id.btn_font).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFont();
            }
        });
        view.findViewById(R.id.btn_open_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), TestActivity.class));
            }
        });
        return view;
    }

    HashMap<String, String> map = new HashMap<>();

    private void switchFont() {
        map.put("默认", null);
        map.put("时尚细黑", "SSXHZT.ttf");
        map.put("大梁体", "DLTZT.ttf");
        map.put("微软雅黑", "WRYHZT.ttf");
        new MaterialDialog.Builder(getContext())
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
    }
}
