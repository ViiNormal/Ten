package hsq.org.ten.bean;

import java.util.List;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class NovelListBean {
    /**
     * result : [{"id":100268,"type":2,"publishtime":636304896000000000,"title":"我故去的少年朋友","summary":"想起了很多故事，看到每一个被你描述的故事，感觉都很舒服。你说你特别特别难过，我也常这样说，想告诉别人我有多难受，可是话说出来就轻了，轻飘飘的都感受不到，但文字不一样，看到了就体会到。","image":""},{"id":100267,"type":2,"publishtime":636304032000000000,"title":"山中遇仙记","summary":"彼此刚刚厌烦的时候仙人就要升天了，临行之际还帮书生觅得一房好妻。\u201d","image":""},{"id":100266,"type":2,"publishtime":636303168000000000,"title":"父亲的事业","summary":"父亲六十岁了。\r\n\r\n父亲一生去过很多地方，最南端的地方是海南，最西边的是新疆，广东、广西，山东、山西\u2026\u2026从年轻到老，脚步一直都没有停歇过。父亲的主业是建筑工人，所以哪里有工程做，就跟着人去哪里。父亲做过的其他事业也很多，但最后总是会回到主业上。","image":""},{"id":100265,"type":2,"publishtime":636302304000000000,"title":"在香港的又一次搬家","summary":"想起去年搬家，有时间时就开着车，一车一车的拉，真的像蚂蚁搬家，不过好在车够大，洗衣机都可以装走。对没做就是五菱宏光S。","image":""},{"id":100264,"type":2,"publishtime":636301440000000000,"title":"朋友圈爱情故事","summary":"有的人就这样，一辈子只会爱上一个人，不管其他人有多好。","image":""},{"id":100262,"type":2,"publishtime":636300576000000000,"title":"记蒲公英丨转瞬即逝的忧伤","summary":"曾经的我们，总爱扮演蒲公英的命运之神，一口气，白色的降落伞随风而去，落到哪里便是哪里。后来才发现，就连我们自己，也不过是人世的沉浮者，不过，不可知的未来，总好过没有未来。","image":""},{"id":100261,"type":2,"publishtime":636299712000000000,"title":"窥","summary":"如果十五岁就读了卡夫卡，我想未来你一定不会差，我十五岁时不知道卡夫卡的存在。","image":""},{"id":100263,"type":2,"publishtime":636298848000000000,"title":"你可不能白玩啊！","summary":"春游就像逛窑子，白玩可耻，瞎逛丢人。","image":""},{"id":100260,"type":2,"publishtime":636297120000000000,"title":"许愿","summary":"人生需要回味，带有一种体悟会发现回首是多么的珍贵。","image":""}]
     * status : 0
     * errMsg : null
     */

    private int status;
    private Object errMsg;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 100268
         * type : 2
         * publishtime : 636304896000000000
         * title : 我故去的少年朋友
         * summary : 想起了很多故事，看到每一个被你描述的故事，感觉都很舒服。你说你特别特别难过，我也常这样说，想告诉别人我有多难受，可是话说出来就轻了，轻飘飘的都感受不到，但文字不一样，看到了就体会到。
         * image :
         */

        private int id;
        private int type;
        private long publishtime;
        private String title;
        private String summary;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(long publishtime) {
            this.publishtime = publishtime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
