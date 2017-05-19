package hsq.org.ten.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.config.TimeConfig;
import hsq.org.ten.event.HomeBottomTabEvent;
import hsq.org.ten.event.HomeFavoriteEvent;
import hsq.org.ten.event.HomeTabEvent;
import hsq.org.ten.fragment.CriticFragment;
import hsq.org.ten.fragment.DiagramFragment;
import hsq.org.ten.fragment.NovelFragment;
import hsq.org.ten.fragment.PersonalFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Fragment mShowFragment;
    private RadioGroup mBottomTab;
    private FragmentManager fragmentManager;
    private boolean isExit;
    private RelativeLayout mTab;
    private ImageView mLogo;
    private ImageView mMonth;
    private ImageView mWeek;
    private ImageView mDate0;
    private ImageView mDate1;
    private ImageView mFavoriteTip;
    private RelativeLayout mShare;
    private long mTime;
    private Map<String, HomeTabEvent> mTabEventMap;
    private HomeTabEvent mHomeEvent;
    private CheckBox mShareFavorite;
    private String mTag;
//    private Map<String, Map<Integer, HomeFavoriteEvent>> mFavoriteEventMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initView() {
        mTab = (RelativeLayout) findViewById(R.id.home_tab);
        mFavoriteTip = (ImageView) findViewById(R.id.home_favorite_tip);
        mLogo = (ImageView) findViewById(R.id.home_logo);
        mMonth = (ImageView) findViewById(R.id.home_month);
        mWeek = (ImageView) findViewById(R.id.home_week);
        mDate0 = (ImageView) findViewById(R.id.home_date0);
        mDate1 = (ImageView) findViewById(R.id.home_date1);
        mBottomTab = (RadioGroup) findViewById(R.id.home_bottomtab);
        mShare = (RelativeLayout) findViewById(R.id.home_share);
        mShareFavorite = (CheckBox) findViewById(R.id.home_share_favorite);
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        mTabEventMap = new HashMap<>();
        //初始化时间
        mHomeEvent = new HomeTabEvent(EventConfig.HOME_TAB_TIME);
        mTime = new Date().getTime();
        mHomeEvent.setPosition(0);
        setupTabTime(mHomeEvent);
    }

    //初始化时间
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setupTabTime(HomeTabEvent event) {
        if (event == null) {
            event = mHomeEvent;
        }
        if (event.WHAT == EventConfig.HOME_TAB_TIME) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(mTime - event.getPosition() * TimeConfig.DAY_TIME);
            int month = calendar.get(Calendar.MONTH);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            event.setMonth(month);
            event.setWeek(week);
            event.setDay(day);
            String tag = event.getTag();
            if (tag != null) {
                mTabEventMap.put(tag, event);
            }
            //设置月份
            switch (month) {
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
            switch (week) {
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
            switch (day / 10) {
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
            switch (day % 10) {
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
    }

    @Override
    protected void initListener() {
        mBottomTab.setOnCheckedChangeListener(this);
        mFavoriteTip.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mShareFavorite.setOnCheckedChangeListener(this);
    }

    @Override
    protected void setData() {
        mBottomTab.check(R.id.home_critic);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home_critic:
                mTag = CriticFragment.TAG;
                switchPage(CriticFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mFavoriteTip.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_critic);
                setupTabTime(mTabEventMap.get(CriticFragment.TAG));
                break;
            case R.id.home_novel:
                mTag = NovelFragment.TAG;
                switchPage(NovelFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mFavoriteTip.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_novel);
                setupTabTime(mTabEventMap.get(NovelFragment.TAG));
                break;
            case R.id.home_diagram:
                mTag = DiagramFragment.TAG;
                switchPage(DiagramFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mFavoriteTip.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_diagram);
                setupTabTime(mTabEventMap.get(DiagramFragment.TAG));
                break;
            case R.id.home_personal:
                mTag = PersonalFragment.TAG;
                switchPage(PersonalFragment.TAG);
                mTab.setVisibility(View.GONE);
                mFavoriteTip.setVisibility(View.GONE);
                break;
        }
    }

    private void switchPage(String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏当前正在显示的页面
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        // 显示将要显示的页面
        mShowFragment = fragmentManager.findFragmentByTag(tag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        } else {
            try {
                mShowFragment = (Fragment) Class.forName(tag).getConstructor().newInstance();
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
            transaction.add(R.id.home_container, mShowFragment, tag);
        }
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                isExit = true;
                // 计时任务，在3s后还原状态 isExit 变为false
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // 定时任务的操作
                        isExit = false;
                    }
                }, 3000);

                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_favorite_tip:
                mShare.setVisibility(View.VISIBLE);
                break;
            case R.id.home_share:
                mShare.setVisibility(View.GONE);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setupBottomTabVisible(HomeBottomTabEvent event) {
        if (event.isVisible()) {
            mBottomTab.setVisibility(View.VISIBLE);
            mFavoriteTip.setVisibility(View.VISIBLE);
        } else {
            mBottomTab.setVisibility(View.GONE);
            mFavoriteTip.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.home_share_favorite:
                HomeFavoriteEvent favoriteEvent = new HomeFavoriteEvent(EventConfig.HOME_FAVORITE);
                favoriteEvent.setTag(mTag);
                favoriteEvent.setFavorite(isChecked);
                HomeTabEvent tabEvent = mTabEventMap.get(mTag);
                if (tabEvent == null) {
                    tabEvent = mHomeEvent;
                }
                favoriteEvent.setPosition(tabEvent.getPosition());
                favoriteEvent.setMonth(tabEvent.getMonth());
                favoriteEvent.setWeek(tabEvent.getWeek());
                favoriteEvent.setDay(tabEvent.getDay());

                EventBus.getDefault().post(favoriteEvent);
                break;
        }
    }
}
