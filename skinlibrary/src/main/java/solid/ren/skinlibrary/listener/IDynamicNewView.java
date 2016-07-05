package solid.ren.skinlibrary.listener;

import android.view.View;

import java.util.List;

import solid.ren.skinlibrary.attr.DynamicAttr;

/**
 * Created by _SOLID
 * Date:2016/4/14
 * Time:10:26
 */
public interface IDynamicNewView {
    void dynamicAddView(View view, List<DynamicAttr> pDAttrs);
}
