package hsq.org.ten.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import hsq.org.ten.BaseActivity;
import hsq.org.ten.R;
import hsq.org.ten.adapter.FavoriteAdapter;
import hsq.org.ten.bean.FavoriteBean;
import hsq.org.ten.config.EventConfig;
import hsq.org.ten.config.FavoriteConfig;
import hsq.org.ten.db.dao.FavoriteDao;
import hsq.org.ten.event.FavoriteEvent;

public class FavoriteActivity extends BaseActivity implements FavoriteAdapter.OnItemClickListener, View.OnClickListener {

    private ImageView mBack;
    private LinearLayout mContent;
    private TextView mNum;
    private RecyclerView mRecycler;
    private RelativeLayout mNull;
    private FavoriteDao mDao;
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.favorite_back);
        mContent = (LinearLayout) findViewById(R.id.favorite_content);
        mNum = (TextView) findViewById(R.id.favorite_num);
        mRecycler = (RecyclerView) findViewById(R.id.favorite_recycler);
        mNull = (RelativeLayout) findViewById(R.id.favorite_null);
    }

    @Override
    protected void initData() {
        mDao = new FavoriteDao(this);
        List<FavoriteBean> data = mDao.queryAll();
        if (data != null && data.size() != 0){
            mRecycler.setLayoutManager(new LinearLayoutManager(this));
            adapter = new FavoriteAdapter(this, data);
            mRecycler.setAdapter(adapter);
            adapter.setOnItemClickListener(this);
            mNum.setText(String.format("%d个内容被你收藏，愿他们曾伴你好梦", data.size()));
            mNull.setVisibility(View.GONE);
            mContent.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onItemClick(int position) {
        FavoriteBean item = adapter.getItem(position);
        if (item != null) {
            Intent intent = new Intent(this, FavoriteContentActivity.class);
            intent.putExtra(FavoriteConfig.TAG, item);
            intent.putExtra(FavoriteConfig.POSTION, position);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void isFavorite(FavoriteEvent event){
        if (event.WHAT == EventConfig.FAVORITE) {
            FavoriteBean bean = event.getBean();
            if (event.isFavorite()) {
                adapter.addItem(event.getPosition(), bean);
            } else {
                adapter.deleteItem(event.getPosition());
            }
            mNum.setText(String.format("%d个内容被你收藏，愿他们曾伴你好梦", adapter.getItemCount()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
