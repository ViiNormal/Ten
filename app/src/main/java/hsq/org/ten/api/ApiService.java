package hsq.org.ten.api;

import hsq.org.ten.bean.CriticContentBean;
import hsq.org.ten.bean.CriticListBean;
import hsq.org.ten.bean.DiagramContentBean;
import hsq.org.ten.bean.DiagramListBean;
import hsq.org.ten.bean.NovelContentBean;
import hsq.org.ten.bean.NovelListBean;
import hsq.org.ten.config.HttpConfig;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public interface ApiService {
    //影评电影
    @GET(HttpConfig.CRITIC_LIST_PATH)
    Call<CriticListBean> getCriticList();
    //影评内容
    @GET(HttpConfig.CRITIC_CONTENT_PATH)
    Call<CriticContentBean> getCriticContent(@Query("id") int id);
    //美文
    @GET(HttpConfig.NOVEL_LIST_PATH)
    Call<NovelListBean> getNovelList();
    //美文详情
    @GET(HttpConfig.NOVEL_CONTENT_PATH)
    Call<NovelContentBean> getNovelContent(@Query("id") int id);
    //美图
    @GET(HttpConfig.DIAGRAM_LIST_PATH)
    Call<DiagramListBean> getDiagramList();
    //美图详情
    @GET(HttpConfig.DIAGRAM_CONTENT_PATH)
    Call<DiagramContentBean> getDiagramContent(@Query("id") int id);
}
