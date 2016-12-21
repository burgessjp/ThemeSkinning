package solid.ren.skinlibrary.attr;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.loader.SkinManager;

/**
 * Created by _SOLID
 * Date:2016/12/21
 * Time:13:49
 * Desc:
 */

public class StyleAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof TextView) {
//            TextView tv = (TextView) view;
//            int styleId = SkinManager.getInstance().getStyle(attrValueRefName);
//            if (styleId > 0) {
//                tv.setTextAppearance(SkinManager.getInstance().getContext(), styleId);
//            }
        }
    }
}