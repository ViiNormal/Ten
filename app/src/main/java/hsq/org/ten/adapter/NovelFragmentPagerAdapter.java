package hsq.org.ten.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import hsq.org.ten.bean.NovelListBean;
import hsq.org.ten.config.TranslateConfig;
import hsq.org.ten.fragment.NovelContentFragment;

/**
 * Created by 黄上清 on 2017/5/17.
 */

public class NovelFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<NovelListBean.ResultBean> data;

    public NovelFragmentPagerAdapter(FragmentManager fm, List<NovelListBean.ResultBean> data) {
        super(fm);
        this.data = data;
        fragments = new ArrayList<>();
        int count = data.size();
        for (int i = 0; i < count; i++) {
            NovelContentFragment fragment = new NovelContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(TranslateConfig.ID, data.get(i).getId());
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
    }

    public NovelListBean.ResultBean getDataItem(int position){
        if (position >= 0 && position < data.size()){
            return data.get(position);
        }
        return null;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
