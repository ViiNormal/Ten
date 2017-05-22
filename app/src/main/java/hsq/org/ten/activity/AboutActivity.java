package hsq.org.ten.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;

public class AboutActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.about_back);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
