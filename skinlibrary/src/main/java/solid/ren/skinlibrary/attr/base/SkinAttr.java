package solid.ren.skinlibrary.attr.base;

import android.view.View;

/**
 * Created by _SOLID
 * Date:2016/4/13
 * Time:21:38
 */
public abstract class SkinAttr implements Cloneable {
    protected static final String RES_TYPE_NAME_COLOR = "color";
    protected static final String RES_TYPE_NAME_DRAWABLE = "drawable";
    /**
     * 属性名, 例如: background、textSize、textColor
     */
    public String attrName;

    /**
     * 属性值的引用id
     */
    public int attrValueRefId;

    /**
     * 资源的名字, 例如 [app_exit_btn_background]
     */
    public String attrValueRefName;

    /**
     * type of the value , such as color or drawable
     */
    public String attrValueTypeName;

    /**
     * Use to apply view with new TypedValue
     *
     * @param view
     */
    public abstract void apply(View view);

    @Override
    public String toString() {
        return "SkinAttr \n[\nattrName=" + attrName + ", \n"
                + "attrValueRefId=" + attrValueRefId + ", \n"
                + "attrValueRefName=" + attrValueRefName + ", \n"
                + "attrValueTypeName=" + attrValueTypeName
                + "\n]";
    }

    @Override
    public SkinAttr clone() {
        SkinAttr o = null;
        try {
            o = (SkinAttr) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
