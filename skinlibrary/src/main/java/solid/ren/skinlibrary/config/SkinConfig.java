package solid.ren.skinlibrary.config;

import android.content.Context;

import solid.ren.skinlibrary.utils.PreferencesUtils;


/**
 * Created by _SOLID
 * Date:2016/4/13
 * Time:21:29
 */
public class SkinConfig {
    public static final String NAMESPACE = "http://schemas.android.com/android/skin";
    public static final String PREF_CUSTOM_SKIN_PATH = "skin_custom_path";
    public static final String DEFAULT_SKIN = "skin_default";//默认皮肤
    public static final String ATTR_SKIN_ENABLE = "enable";

    public static final String SKIN_DIR_NAME = "skin";
    public static final String FONT_DIR_NAME = "font";
    private static boolean isCanChangeStatusColor = false;

    /**
     * get path of last skin package path
     *
     * @param context
     * @return path of skin package
     */
    public static String getCustomSkinPath(Context context) {
        return PreferencesUtils.getString(context, PREF_CUSTOM_SKIN_PATH, DEFAULT_SKIN);
    }

    /**
     * save the skin's path
     *
     * @param context
     * @param path
     */
    public static void saveSkinPath(Context context, String path) {
        PreferencesUtils.putString(context, PREF_CUSTOM_SKIN_PATH, path);
    }

    public static boolean isDefaultSkin(Context context) {
        return DEFAULT_SKIN.equals(getCustomSkinPath(context));
    }

    public static void setCanChangeStatusColor(boolean isCan) {
        isCanChangeStatusColor = isCan;
    }

    public static boolean isCanChangeStatusColor() {
        return isCanChangeStatusColor;
    }
}
