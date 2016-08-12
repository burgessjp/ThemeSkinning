package solid.ren.skinlibrary.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import solid.ren.skinlibrary.attr.base.DynamicAttr;
import solid.ren.skinlibrary.config.SkinConfig;
import solid.ren.skinlibrary.listener.IDynamicNewView;
import solid.ren.skinlibrary.listener.ISkinUpdate;
import solid.ren.skinlibrary.loader.SkinInflaterFactory;
import solid.ren.skinlibrary.loader.SkinManager;
import solid.ren.skinlibrary.statusbar.StatusBarUtil;
import solid.ren.skinlibrary.utils.SkinL;


/**
 * Created by _SOLID
 * Date:2016/4/14
 * Time:10:24
 * 需要实现换肤功能的Activity就需要继承于这个Activity
 */
public class SkinBaseActivity extends AppCompatActivity implements ISkinUpdate, IDynamicNewView {

    private SkinInflaterFactory mSkinInflaterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSkinInflaterFactory = new SkinInflaterFactory();
        mSkinInflaterFactory.setAppCompatActivity(this);
        LayoutInflaterCompat.setFactory(getLayoutInflater(), mSkinInflaterFactory);
        super.onCreate(savedInstanceState);
        changeStatusColor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinManager.getInstance().attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().detach(this);
        mSkinInflaterFactory.clean();
    }

    @Override
    public void onThemeUpdate() {
        Log.i("SkinBaseActivity", "onThemeUpdate");
        mSkinInflaterFactory.applySkin();
        changeStatusColor();
    }

    public void changeStatusColor() {
        if (!SkinConfig.isCanChangeStatusColor() || !requireChangeStatusColor()) {
            return;
        }
        int color = SkinManager.getInstance().getColorPrimaryDark();
        changeStatusColor(color);
    }

    public void changeStatusColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SkinL.i("SkinBaseActivity", "changeStatus");
            StatusBarUtil statusBarBackground = new StatusBarUtil(
                    this, color);
            if (color != -1)
                statusBarBackground.setStatusBarbackColor();
        }
    }

    public boolean requireChangeStatusColor() {
        return true;
    }

    @Override
    public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
    }

    @Override
    public void dynamicAddView(View view, String attrName, int attrValueResId) {
        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, attrName, attrValueResId);
    }

    @Override
    public void dynamicAddFontView(TextView textView) {
        mSkinInflaterFactory.dynamicAddFontEnableView(textView);
    }

}
