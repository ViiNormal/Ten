package hsq.org.ten.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.api.ApiClient;
import hsq.org.ten.bean.NovelContentBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.config.TranslateConfig;
import hsq.org.ten.event.HomeBottomTabEvent;
import hsq.org.ten.widget.CustomScrollView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄上清 on 2017/5/17.
 */

public class NovelContentFragment extends BaseFragment implements CustomScrollView.ScrollViewListener {

    public static final String TAG = NovelContentFragment.class.getName();
    private CustomScrollView mScroll;
    private LinearLayout mLayout;
    private TextView mTitle;
    private TextView mInfo;
    private TextView mSummary;
    private TextView mText;
    private TextView mAuthor;
    private TextView mAuthorBrief;
    private ProgressBar mProgress;
    private boolean isVisible;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_novel_content;
    }

    @Override
    protected void initView() {
        mScroll = (CustomScrollView) layout.findViewById(R.id.home_novel_content_scroll);
        mLayout = (LinearLayout) layout.findViewById(R.id.home_novel_content_layout);
        mTitle = (TextView) layout.findViewById(R.id.home_novel_content_title);
        mInfo = (TextView) layout.findViewById(R.id.home_novel_content_info);
        mSummary = (TextView) layout.findViewById(R.id.home_novel_content_summary);
        mText = (TextView) layout.findViewById(R.id.home_novel_content_text);
        mAuthor = (TextView) layout.findViewById(R.id.home_novel_content_author);
        mAuthorBrief = (TextView) layout.findViewById(R.id.home_novel_content_authorbrief);
        mProgress = (ProgressBar) layout.findViewById(R.id.home_novel_content_progress);
    }

    @Override
    protected void initData() {
        isVisible = true;
        int id = getArguments().getInt(TranslateConfig.ID);
        Call<NovelContentBean> call = ApiClient.getApiService().getNovelContent(id);
        call.enqueue(new Callback<NovelContentBean>() {
            @Override
            public void onResponse(Call<NovelContentBean> call, Response<NovelContentBean> response) {
                NovelContentBean bean = response.body();
                mTitle.setText(bean.getTitle());
                mInfo.setText(String.format("作者:%s | 阅读量:%d", bean.getAuthor(), bean.getTimes()));
                mSummary.setText(bean.getSummary());
                mText.setText(bean.getText());
                mAuthor.setText(bean.getAuthor());
                mAuthorBrief.setText(bean.getAuthorbrief());
                mProgress.setVisibility(View.GONE);
                mLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<NovelContentBean> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initListener() {
        mScroll.setScrollViewListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onScrollChanged(CustomScrollView scrollView, int x, int y, int oldx, int oldy) {
        if ((y - oldy > 0 && isVisible) || (y - oldy < 0 && !isVisible)){
            isVisible = !isVisible;
            HomeBottomTabEvent event = new HomeBottomTabEvent(EventConfig.HOME_BOTTOM_TAB_VISIBLE);
            event.setVisible(isVisible);
            EventBus.getDefault().post(event);
        }
    }
}
