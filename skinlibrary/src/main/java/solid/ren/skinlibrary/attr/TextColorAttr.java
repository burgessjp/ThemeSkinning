package solid.ren.skinlibrary.attr;

import android.view.View;
import android.widget.TextView;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.loader.SkinManager;


/**
 * Created by _SOLID
 * Date:2016/4/13
 * Time:22:53
 */
public class TextColorAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            if (RES_TYPE_NAME_COLOR.equals(attrValueTypeName)) {
                tv.setTextColor(SkinManager.getInstance().getColorStateList(attrValueRefId));
            }
        }
    }
}
