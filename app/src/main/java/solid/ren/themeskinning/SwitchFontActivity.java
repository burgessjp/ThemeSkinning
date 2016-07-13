package solid.ren.themeskinning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.HashMap;
import java.util.Map;

import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.skinlibrary.loader.SkinManager;

/**
 * Created by _SOLID
 * Date:2016/7/12
 * Time:23:48
 */
public class SwitchFontActivity extends SkinBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_font);
        findViewById(R.id.btn_font).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFont();
            }
        });
        findViewById(R.id.btn_open_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SwitchFontActivity.this, TestActivity.class));
            }
        });
    }

    HashMap<String, String> map = new HashMap<>();

    private void switchFont() {
        map.put("默认", null);
        map.put("时尚细黑", "SSXHZT.ttf");
        map.put("大梁体", "DLT.ttf");
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
    }
}
