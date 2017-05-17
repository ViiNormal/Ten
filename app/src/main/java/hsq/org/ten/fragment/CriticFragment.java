package hsq.org.ten.fragment;

import android.support.v4.view.ViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.adapter.CriticFragmentPagerAdapter;
import hsq.org.ten.api.ApiClient;
import hsq.org.ten.api.ApiService;
import hsq.org.ten.bean.CriticListBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.event.HomeTabEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class CriticFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    public static final String TAG = CriticFragment.class.getName();
    private ViewPager mViewPager;
    private CriticFragmentPagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_critic;
    }

    @Override
    protected void initView() {
        mViewPager = (ViewPager) layout.findViewById(R.id.home_critic_viewpager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setData() {
        setupView();
    }

    private void setupView() {
        ApiService apiService = ApiClient.getApiService();
        Call<CriticListBean> listBeanCall = apiService.getCriticList();
        listBeanCall.enqueue(new Callback<CriticListBean>() {
            @Override
            public void onResponse(Call<CriticListBean> call, Response<CriticListBean> response) {
                List<CriticListBean.ResultBean> data = response.body().getResult();
                adapter = new CriticFragmentPagerAdapter(getChildFragmentManager(), data);
                mViewPager.setAdapter(adapter);
                mViewPager.addOnPageChangeListener(CriticFragment.this);
            }

            @Override
            public void onFailure(Call<CriticListBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        HomeTabEvent event = new HomeTabEvent(EventConfig.HOME_TAB_TIME);
        event.setPosition(position);
        event.setTag(TAG);
        EventBus.getDefault().post(event);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
