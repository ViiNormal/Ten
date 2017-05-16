package hsq.org.ten.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;
import hsq.org.ten.fragment.CriticFragment;
import hsq.org.ten.fragment.DiagramFragment;
import hsq.org.ten.fragment.NovelFragment;
import hsq.org.ten.fragment.PersonalFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initView() {
        mTab = (RelativeLayout) findViewById(R.id.home_tab);
        mLogo = (ImageView) findViewById(R.id.home_logo);
        mMonth = (ImageView) findViewById(R.id.home_month);
        mWeek = (ImageView) findViewById(R.id.home_week);
        mDate0 = (ImageView) findViewById(R.id.home_date0);
        mDate1 = (ImageView) findViewById(R.id.home_date1);
        mBottomTab = (RadioGroup) findViewById(R.id.home_bottomtab);
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        //初始化时间
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //设置月份
        switch (month){
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
        switch (week){
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
        switch (day/10){
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
        switch (day%10){
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
    protected void initListener() {
        mBottomTab.setOnCheckedChangeListener(this);
    }

    @Override
    protected void setData() {
        mBottomTab.check(R.id.home_critic);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home_critic:
                switchPage(CriticFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_critic);
                break;
            case R.id.home_novel:
                switchPage(NovelFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_novel);
                break;
            case R.id.home_diagram:
                switchPage(DiagramFragment.TAG);
                mTab.setVisibility(View.VISIBLE);
                mLogo.setImageResource(R.drawable.logo_diagram);
                break;
            case R.id.home_personal:
                switchPage(PersonalFragment.TAG);
                mTab.setVisibility(View.GONE);
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
            transaction.add(R.id.home_fragment, mShowFragment, tag);
        }
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit){
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
}
