package solid.ren.themeskinning.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import solid.ren.themeskinning.DataProvider;

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

        return DataProvider.getFragment(title.toString());
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
