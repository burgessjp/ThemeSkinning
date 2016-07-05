package solid.ren.skinlibrary.attr;

import android.util.Log;

/**
 * Created by _SOLID
 * Date:2016/4/14
 * Time:9:47
 */
public class AttrFactory {

    private static String TAG = "AttrFactory";

    public static final String BACKGROUND = "background";
    public static final String TEXT_COLOR = "textColor";
    public static final String TAB_INDICATOR_COLOR = "tabIndicatorColor";
    public static final String CONTENT_SCRIM_COLOR = "contentScrimColor";
    public static final String BACKGROUND_TINTLIST = "backgroundTint";
    public static final String NAVIGATION_VIEW_MENU = "navigationViewMenu";


    public static SkinAttr get(String attrName, int attrValueRefId, String attrValueRefName, String typeName) {
        Log.i(TAG, "attrName:" + attrName);
        SkinAttr mSkinAttr = null;

        if (BACKGROUND.equals(attrName)) {
            mSkinAttr = new BackgroundAttr();
            Log.i(TAG, "create:BackgroundAttr");
        } else if (TEXT_COLOR.equals(attrName)) {
            mSkinAttr = new TextColorAttr();
            Log.i(TAG, "create:TextColorAttr");
        } else if (TAB_INDICATOR_COLOR.equals(attrName)) {
            mSkinAttr = new TabLayoutAttr();
            Log.i(TAG, "create:TabLayoutAttr");
        } else if (CONTENT_SCRIM_COLOR.equals(attrName)) {
            mSkinAttr = new CollapsingToolbarLayoutAttr();
            Log.i(TAG, "create:CollapsingToolbarLayoutAttr");
        } else if (BACKGROUND_TINTLIST.equals(attrName)) {
            mSkinAttr = new FabButtonAttr();
            Log.i(TAG, "create:FabButtonAttr");
        } else if (NAVIGATION_VIEW_MENU.equals(attrName)) {
            mSkinAttr = new NavigationViewAttr();
            Log.i(TAG, "create:FabButtonAttr");
        } else {
            return null;
        }

        mSkinAttr.attrName = attrName;
        mSkinAttr.attrValueRefId = attrValueRefId;
        mSkinAttr.attrValueRefName = attrValueRefName;
        mSkinAttr.attrValueTypeName = typeName;
        return mSkinAttr;
    }

    /**
     * 检测属性是否被支持
     *
     * @param attrName
     * @return true : supported <br>
     * false: not supported
     */
    public static boolean isSupportedAttr(String attrName) {
        if (BACKGROUND.equals(attrName)) {
            return true;
        }
        if (TEXT_COLOR.equals(attrName)) {
            return true;
        }
        if (TAB_INDICATOR_COLOR.equals(attrName)) {
            return true;
        }
        if (CONTENT_SCRIM_COLOR.equals(attrName)) {
            return true;
        }
        if (BACKGROUND_TINTLIST.equals(attrName)) {
            return true;
        }
        return NAVIGATION_VIEW_MENU.equals(attrName);
    }
}
