package hsq.org.ten.config;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public interface HttpConfig {
    String DEBUG="";
    String AUTHORITY="api.shigeten.net";
    boolean isDebug=false;
    //判断当前url到底是测试版本还是正版版本
    String BASE_URL = isDebug ? DEBUG : AUTHORITY;
    String CRITIC_LIST_PATH = "/api/Critic/GetCriticList";//影评电影
    String CRITIC_CONTENT_PATH = "/api/Critic/GetCriticContent";//影评内容
    String NOVEL_LIST_PATH = "/api/Novel/GetNovelList";//美文
    String NOVEL_CONTENT_PATH = "/api/Novel/GetNovelContent";//美文详情
    String DIAGRAM_LIST_PATH = "/api/Diagram/GetDiagramList";//美图
    String DIAGRAM_CONTENT_PATH = "/api/Diagram/GetDiagramContent";//美图详情
}
