package hsq.org.ten.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.InvocationTargetException;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;
import hsq.org.ten.bean.FavoriteBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.config.FavoriteConfig;
import hsq.org.ten.config.TranslateConfig;
import hsq.org.ten.db.FavoriteDao;
import hsq.org.ten.event.FavoriteEvent;
import hsq.org.ten.fragment.CriticContentFragment;
import hsq.org.ten.fragment.DiagramContentFragment;
import hsq.org.ten.fragment.NovelContentFragment;

import static hsq.org.ten.R.id.favorite_content_back;

public class FavoriteContentActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ImageView mBack;
    private ImageView mMonth;
    private ImageView mWeek;
    private ImageView mDate0;
    private ImageView mDate1;
    private ImageView mFavoriteTip;
    private RelativeLayout mShare;
    private CheckBox mShareFavorite;
    private FavoriteBean mFavoriteBean;
    private FavoriteDao mDao;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_content);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(favorite_content_back);
        mWeek = (ImageView) findViewById(R.id.favorite_content_week);
        mMonth = (ImageView) findViewById(R.id.favorite_content_month);
        mDate1 = (ImageView) findViewById(R.id.favorite_content_date1);
        mDate0 = (ImageView) findViewById(R.id.favorite_content_date0);
        mFavoriteTip = (ImageView) findViewById(R.id.favorite_content_favorite_tip);
        mShare = (RelativeLayout) findViewById(R.id.favorite_content_share);
        mShareFavorite = (CheckBox) findViewById(R.id.favorite_content_share_favorite);
    }

    @Override
    protected void initData() {
        mFavoriteBean = (FavoriteBean) getIntent().getSerializableExtra(FavoriteConfig.TAG);
        mDao = new FavoriteDao(this);
        setupTabTime();
        setupContainer();
        isFavorite = true;
        mShareFavorite.setChecked(isFavorite);
    }

    private void setupContainer() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt(TranslateConfig.ID, mFavoriteBean.getId());
        String tag = null;
        switch (mFavoriteBean.getType()) {
            case FavoriteConfig.TYPE_CRITIC:
                tag = CriticContentFragment.TAG;
                break;
            case FavoriteConfig.TYPE_NOVEL:
                tag = NovelContentFragment.TAG;
                break;
            case FavoriteConfig.TYPE_DIAGRAM:
                tag = DiagramContentFragment.TAG;
                break;
        }
        try {
            Fragment fragment = (Fragment) Class.forName(tag).getConstructor().newInstance();
            fragment.setArguments(bundle);
            transaction.add(R.id.favorite_content_container, fragment, tag);
            transaction.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
        mFavoriteTip.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mShareFavorite.setOnCheckedChangeListener(this);
    }

    @Override
    protected void setData() {

    }

    public void setupTabTime() {
        //设置月份
        switch (mFavoriteBean.getMonth()) {
            case 0:
                mMonth.setImageResource(R.drawable.month_1);
                break;
            case 1:
                mMonth.setImageResource(R.drawable.month_2);
                break;
            case 2:
                mMonth.setImageResource(R.drawable.month_3);
                break;
            case 3:
                mMonth.setImageResource(R.drawable.month_4);
                break;
            case 4:
                mMonth.setImageResource(R.drawable.month_5);
                break;
            case 5:
                mMonth.setImageResource(R.drawable.month_6);
                break;
            case 6:
                mMonth.setImageResource(R.drawable.month_7);
                break;
            case 7:
                mMonth.setImageResource(R.drawable.month_8);
                break;
            case 8:
                mMonth.setImageResource(R.drawable.month_9);
                break;
            case 9:
                mMonth.setImageResource(R.drawable.month_10);
                break;
            case 10:
                mMonth.setImageResource(R.drawable.month_11);
                break;
            case 11:
                mMonth.setImageResource(R.drawable.month_12);
                break;
        }
        //设置星期
        switch (mFavoriteBean.getWeek()) {
            case 1:
                mWeek.setImageResource(R.drawable.week_7);
                break;
            case 2:
                mWeek.setImageResource(R.drawable.week_1);
                break;
            case 3:
                mWeek.setImageResource(R.drawable.week_2);
                break;
            case 4:
                mWeek.setImageResource(R.drawable.week_3);
                break;
            case 5:
                mWeek.setImageResource(R.drawable.week_4);
                break;
            case 6:
                mWeek.setImageResource(R.drawable.week_5);
                break;
            case 7:
                mWeek.setImageResource(R.drawable.week_6);
                break;
        }
        //设置日期
        switch (mFavoriteBean.getDay() / 10) {
            case 0:
                mDate0.setImageResource(R.drawable.date_0);
                break;
            case 1:
                mDate0.setImageResource(R.drawable.date_1);
                break;
            case 2:
                mDate0.setImageResource(R.drawable.date_2);
                break;
            case 3:
                mDate0.setImageResource(R.drawable.date_3);
                break;
        }
        //设置日期
        switch (mFavoriteBean.getDay() % 10) {
            case 0:
                mDate1.setImageResource(R.drawable.date_0);
                break;
            case 1:
                mDate1.setImageResource(R.drawable.date_1);
                break;
            case 2:
                mDate1.setImageResource(R.drawable.date_2);
                break;
            case 3:
                mDate1.setImageResource(R.drawable.date_3);
                break;
            case 4:
                mDate1.setImageResource(R.drawable.date_4);
                break;
            case 5:
                mDate1.setImageResource(R.drawable.date_5);
                break;
            case 6:
                mDate1.setImageResource(R.drawable.date_6);
                break;
            case 7:
                mDate1.setImageResource(R.drawable.date_7);
                break;
            case 8:
                mDate1.setImageResource(R.drawable.date_8);
                break;
            case 9:
                mDate1.setImageResource(R.drawable.date_9);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.favorite_content_back:
                finish();
                break;
            case R.id.favorite_content_favorite_tip:
                mShare.setVisibility(View.VISIBLE);
                break;
            case R.id.favorite_content_share:
                mShare.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.favorite_content_share_favorite:
                FavoriteEvent event = new FavoriteEvent(EventConfig.FAVORITE);
                event.setBean(mFavoriteBean);
                event.setFavorite(isChecked);
                isFavorite = isChecked;
                EventBus.getDefault().post(event);
                if (isChecked) {
                    if (mDao.insertItem(mFavoriteBean)) {
                        Toast.makeText(this, "收藏成功了！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mDao.deleteItem(mFavoriteBean)) {
                        Toast.makeText(this, "取消收藏成功了！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}

