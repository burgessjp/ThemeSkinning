package solid.ren.skinlibrary.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

import solid.ren.skinlibrary.loader.SkinManager;

/**
 * Created by _SOLID
 * Date:2016/7/9
 * Time:13:56
 */
public class SkinResourcesUtils {

    public static int getColor(int resId) {
        return SkinManager.getInstance().getColor(resId);
    }

    public static Drawable getDrawable(int resId) {
        return SkinManager.getInstance().getDrawable(resId);
    }

    public static ColorStateList getColorStateList(int resId) {
        return SkinManager.getInstance().getColorStateList(resId);
    }
}
