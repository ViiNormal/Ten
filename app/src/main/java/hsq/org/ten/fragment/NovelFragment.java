package hsq.org.ten.fragment;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.adapter.NovelFragmentPagerAdapter;
import hsq.org.ten.api.ApiClient;
import hsq.org.ten.api.ApiService;
import hsq.org.ten.bean.FavoriteBean;
import hsq.org.ten.bean.NovelListBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.db.dao.FavoriteDao;
import hsq.org.ten.event.HomeFavoriteEvent;
import hsq.org.ten.event.HomeTabEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class NovelFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    public static final String TAG = NovelFragment.class.getName();
    private ViewPager mViewPager;
    private NovelFragmentPagerAdapter adapter;
    private FavoriteDao mDao;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_novel;
    }

    @Override
    protected void initView() {
        mViewPager = (ViewPager) layout.findViewById(R.id.home_novel_viewpager);
    }

    @Override
    protected void initData() {
        mDao = new FavoriteDao(getContext());
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
        Call<NovelListBean> listBeanCall = apiService.getNovelList();
        listBeanCall.enqueue(new Callback<NovelListBean>() {
            @Override
            public void onResponse(Call<NovelListBean> call, Response<NovelListBean> response) {
                List<NovelListBean.ResultBean> data = response.body().getResult();
                adapter = new NovelFragmentPagerAdapter(getChildFragmentManager(), data);
                mViewPager.setAdapter(adapter);
                mViewPager.addOnPageChangeListener(NovelFragment.this);
            }

            @Override
            public void onFailure(Call<NovelListBean> call, Throwable t) {

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


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void favorite(HomeFavoriteEvent event){
        if (event.WHAT == EventConfig.HOME_FAVORITE && TextUtils.equals(TAG, event.getTag())){
            NovelListBean.ResultBean dataItem = adapter.getDataItem(event.getPosition());
            if (dataItem != null) {
                if (event.isFavorite()) {
                    FavoriteBean favoriteBean = new FavoriteBean(dataItem.getId(), dataItem.getType(), event.getMonth(), event.getWeek(), event.getDay(), dataItem.getTitle(), dataItem.getSummary());
                    if (mDao.insertItem(favoriteBean)) {
                        Toast.makeText(getContext(), "收藏成功了！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mDao.deleteItemByTypeAndId(dataItem.getType(), dataItem.getId())) {
                        Toast.makeText(getContext(), "取消收藏成功了！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
