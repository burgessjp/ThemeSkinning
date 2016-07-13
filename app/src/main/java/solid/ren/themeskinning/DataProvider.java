package solid.ren.themeskinning;

import java.util.ArrayList;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:17:32
 */
public class DataProvider {

    public static ArrayList<String> getTitleList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("基本换肤");
        list.add("动态添加");
        list.add("加载网络皮肤");
        list.add("切换字体");
        return list;
    }
}
