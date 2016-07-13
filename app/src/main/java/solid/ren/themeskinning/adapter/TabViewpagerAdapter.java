package solid.ren.themeskinning.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.themeskinning.fragment.BasicFragment;
import solid.ren.themeskinning.fragment.DynamicAddFragment;
import solid.ren.themeskinning.fragment.FromNetWorkFragment;
import solid.ren.themeskinning.fragment.SwitchFontFragment;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:21:12
 */
public class TabViewpagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> list;

    public TabViewpagerAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        CharSequence title = getPageTitle(position);

        SkinBaseFragment fragment = new BasicFragment();
        if ("基本换肤".equals(title)) {
            fragment = new BasicFragment();
        } else if ("动态添加".equals(title)) {
            fragment = new DynamicAddFragment();
        } else if ("加载网络皮肤".equals(title)) {
            fragment = new FromNetWorkFragment();
        } else if ("切换字体".equals(title)) {
            fragment = new SwitchFontFragment();
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
