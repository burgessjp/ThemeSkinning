package solid.ren.themeskinning.custom_attr;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

/**
 * Created by _SOLID
 * Date:2017/6/26
 * Time:13:51
 * Desc:
 */

public class RadioButtonAttr extends SkinAttr {
    @Override
    protected void applySkin(View view) {
        if (view instanceof RadioButton) {
            if (isDrawable()) {
                RadioButton radioButton = (RadioButton) view;
                Drawable drawable = SkinResourcesUtils.getDrawable(attrValueRefId);
                radioButton.setButtonDrawable(drawable);
            }

        }
    }
}
