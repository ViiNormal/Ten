package hsq.org.ten.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
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
    private RadioGroup mTab;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private boolean isExit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initView() {
        mTab = (RadioGroup) findViewById(R.id.home_tab);
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }

    @Override
    protected void initListener() {
        mTab.setOnCheckedChangeListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home_critic:
                switchPage(CriticFragment.TAG);
                break;
            case R.id.home_novel:
                switchPage(NovelFragment.TAG);
                break;
            case R.id.home_diagram:
                switchPage(DiagramFragment.TAG);
                break;
            case R.id.home_personal:
                switchPage(PersonalFragment.TAG);
                break;
        }
    }

    private void switchPage(String tag) {
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
