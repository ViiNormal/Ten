package hsq.org.ten.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import hsq.org.ten.BaseFragment;
import hsq.org.ten.R;
import hsq.org.ten.activity.FavoriteActivity;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class PersonalFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = PersonalFragment.class.getName();
    private ImageView mLogin;
    private RelativeLayout mFavorite;
    private RelativeLayout mFont;
    private RelativeLayout mAboutus;
    private RelativeLayout mFeedback;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView() {
        mLogin = (ImageView) layout.findViewById(R.id.home_personal_avator_login);
        mFavorite = (RelativeLayout) layout.findViewById(R.id.home_personal_favorite);
        mFont = (RelativeLayout) layout.findViewById(R.id.home_personal_font);
        mAboutus = (RelativeLayout) layout.findViewById(R.id.home_personal_aboutus);
        mFeedback = (RelativeLayout) layout.findViewById(R.id.home_personal_feedback);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mFavorite.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_personal_favorite:
                startActivity(new Intent(getContext(), FavoriteActivity.class));
                break;
        }
    }
}
