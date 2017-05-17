package hsq.org.ten.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.api.ApiClient;
import hsq.org.ten.bean.CriticContentBean;
import hsq.org.ten.config.TranslateConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄上清 on 2017/5/17.
 */

public class CriticContentFragment extends BaseFragment {
    private ScrollView mScroll;
    private ImageView mImageForPlay;
    private TextView mTitle;
    private TextView mInfo;
    private TextView mText1;
    private ImageView mImage1;
    private TextView mText2;
    private TextView mRealTitle;
    private ImageView mImage2;
    private TextView mText3;
    private ImageView mImage3;
    private ImageView mImage4;
    private TextView mAuthor;
    private TextView mAuthorBrief;
    private ProgressBar mProgress;
    private LinearLayout mLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_critic_content;
    }

    @Override
    protected void initView() {
        mScroll = (ScrollView) layout.findViewById(R.id.home_critic_content_scroll);
        mLayout = (LinearLayout) layout.findViewById(R.id.home_critic_content_layout);
        mImageForPlay = (ImageView) layout.findViewById(R.id.home_critic_content_imageforplay);
        mTitle = (TextView) layout.findViewById(R.id.home_critic_content_title);
        mInfo = (TextView) layout.findViewById(R.id.home_critic_content_info);
        mText1 = (TextView) layout.findViewById(R.id.home_critic_content_text1);
        mImage1 = (ImageView) layout.findViewById(R.id.home_critic_content_image1);
        mText2 = (TextView) layout.findViewById(R.id.home_critic_content_text2);
        mRealTitle = (TextView) layout.findViewById(R.id.home_critic_content_realtitle);
        mImage2 = (ImageView) layout.findViewById(R.id.home_critic_content_image2);
        mText3 = (TextView) layout.findViewById(R.id.home_critic_content_text3);
        mImage3 = (ImageView) layout.findViewById(R.id.home_critic_content_image3);
        mImage4 = (ImageView) layout.findViewById(R.id.home_critic_content_image4);
        mAuthor = (TextView) layout.findViewById(R.id.home_critic_content_author);
        mAuthorBrief = (TextView) layout.findViewById(R.id.home_critic_content_authorbrief);
        mProgress = (ProgressBar) layout.findViewById(R.id.home_critic_content_progress);
    }

    @Override
    protected void initData() {
        int id = getArguments().getInt(TranslateConfig.ID);
        Call<CriticContentBean> call = ApiClient.getApiService().getCriticContent(id);
        call.enqueue(new Callback<CriticContentBean>() {
            @Override
            public void onResponse(Call<CriticContentBean> call, Response<CriticContentBean> response) {
                CriticContentBean bean = response.body();
                Log.d("1611", "onResponse: "+bean.getAuthor());
                Picasso.with(getContext()).load(bean.getImageforplay()).into(mImageForPlay);
                mTitle.setText(bean.getTitle());
                mInfo.setText(String.format("作者:%s | 阅读量:%d", bean.getAuthor(), bean.getTimes()));
                mText1.setText(bean.getText1());
                Picasso.with(getContext()).load(bean.getImage1()).into(mImage1);
                mText2.setText(bean.getText2());
                mRealTitle.setText(bean.getRealtitle());
                Picasso.with(getContext()).load(bean.getImage2()).into(mImage2);
                mText3.setText(bean.getText3() + bean.getText4() + bean.getText5());
                Picasso.with(getContext()).load(bean.getImage3()).into(mImage3);
                Picasso.with(getContext()).load(bean.getImage4()).into(mImage4);
                mAuthor.setText(bean.getAuthor());
                mAuthorBrief.setText(bean.getAuthorbrief());
                mProgress.setVisibility(View.GONE);
                mLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<CriticContentBean> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setData() {

    }
}
