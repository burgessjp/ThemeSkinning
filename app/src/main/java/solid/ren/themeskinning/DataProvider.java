package solid.ren.themeskinning;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.themeskinning.fragment.BasicFragment;
import solid.ren.themeskinning.fragment.DynamicAddFragment;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:17:32
 */
public class DataProvider {
    public static String netSkinUrl = "https://raw.githubusercontent.com/burgessjp/ThemeSkinning/master/skinpackage/skin_net.skin";

    public static ArrayList<String> getTitleList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("RecyclerView");
        list.add("动态添加");
        return list;
    }

    public static Fragment getFragment(String title) {

        SkinBaseFragment fragment = new BasicFragment();
        if ("RecyclerView".equals(title)) {
            fragment = new BasicFragment();
        } else if ("动态添加".equals(title)) {
            fragment = new DynamicAddFragment();
        }
        return fragment;
    }
}
