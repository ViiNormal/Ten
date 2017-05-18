package hsq.org.ten.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.api.ApiClient;
import hsq.org.ten.bean.DiagramContentBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.config.HttpConfig;
import hsq.org.ten.config.TranslateConfig;
import hsq.org.ten.event.HomeBottomTabEvent;
import hsq.org.ten.widget.CustomScrollView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄上清 on 2017/5/17.
 */

public class DiagramContentFragment extends BaseFragment implements CustomScrollView.ScrollViewListener {
    private CustomScrollView mScroll;
    private LinearLayout mLayout;
    private ImageView mImage1;
    private TextView mTitle;
    private TextView mAuthorBrief;
    private TextView mText1;
    private ProgressBar mProgress;
    private boolean isVisible;
    private TextView mText2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_diagram_content;
    }

    @Override
    protected void initView() {
        mScroll = (CustomScrollView) layout.findViewById(R.id.home_diagram_content_scroll);
        mLayout = (LinearLayout) layout.findViewById(R.id.home_diagram_content_layout);
        mImage1 = (ImageView) layout.findViewById(R.id.home_diagram_content_image1);
        mTitle = (TextView) layout.findViewById(R.id.home_diagram_content_title);
        mAuthorBrief = (TextView) layout.findViewById(R.id.home_diagram_content_authorbrief);
        mText1 = (TextView) layout.findViewById(R.id.home_diagram_content_text1);
        mText2 = (TextView) layout.findViewById(R.id.home_diagram_content_text2);
        mProgress = (ProgressBar) layout.findViewById(R.id.home_diagram_content_progress);
    }

    @Override
    protected void initData() {
        isVisible = true;
        int id = getArguments().getInt(TranslateConfig.ID);
        Call<DiagramContentBean> call = ApiClient.getApiService().getDiagramContent(id);
        call.enqueue(new Callback<DiagramContentBean>() {
            @Override
            public void onResponse(Call<DiagramContentBean> call, Response<DiagramContentBean> response) {
                DiagramContentBean bean = response.body();
                Picasso.with(getContext()).load(HttpConfig.BASE_URL + bean.getImage1()).into(mImage1);
                mTitle.setText(bean.getTitle());
                mAuthorBrief.setText(bean.getAuthorbrief());
                mText1.setText(bean.getText1());
                mText2.setText(bean.getText2());
                mProgress.setVisibility(View.GONE);
                mLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<DiagramContentBean> call, Throwable t) {

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
