package hsq.org.ten.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;

public class WelcomeActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_welcome);
        //自动跳转
        autoJump();
    }

    /**
     * 自动跳转
     */
    private void autoJump() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //跳转到主界面
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }
        }).start();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void setData() {

    }
}
