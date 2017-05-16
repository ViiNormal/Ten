package hsq.org.ten.bean;

import java.util.List;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class DiagramListBean {
    /**
     * result : [{"id":100277,"type":3,"publishtime":636304896000000000,"title":"孤独论","summary":"孤独为一个精神禀赋优异的人带来双重的好处：他可以与自己为伴；他用不着和别人在一起。一个人的自身拥有越多，别人能够给予他的也就越少。自身具有非凡思想热力的人是不需要与别人拥挤在一块的。有一个有思想头脑的同伴就足够了。孤独是精神卓越人士的注定命运。  ","image":"images/A39EABDA533B48CE090B34251DD79D80.png"},{"id":100276,"type":3,"publishtime":636304032000000000,"title":"守望灯塔","summary":"没有什么会被忘记，也没有什么会失去。宇宙自身是一个广大无边的记忆系统。如果你回头看，你就会发现这世界在不断的开始。\r\n\r\n","image":"images/59751257683F5279EA0EAB42AD71147D.png"},{"id":100275,"type":3,"publishtime":636303168000000000,"title":"茶花女","summary":"一切都存在于渺小之中，我就是相信这种说法的人。孩子虽然幼小，但他是未来的成人；脑袋虽然狭窄，但它蕴藏着无限的思想；眼珠才不过一丁点儿大，它却可以看到广袤的天地。","image":"images/3196CC8CB5B6E34B1864C3D8F0795676.png"},{"id":100273,"type":3,"publishtime":636302304000000000,"title":"自己的声音","summary":"只有一个人在旅行时，才听得到自己的声音。它会告诉你，这世界比想象中的宽阔。你的人生不会没有出口，你会发现自己有一双翅膀，不必经过任何人同意就能飞。","image":"images/F2F58D47DDFE5FADDB97242A205F0FA1.png"},{"id":100272,"type":3,"publishtime":636301440000000000,"title":"起点和终点","summary":"我们在路上不是像驿夫那样追赶路程，而是像旅游家似的沿途观赏。我们心中不只是想到一个起点和终点，而且还想到起点和终点之间相隔的距离。","image":"images/653739DB238C829D8D67F727E60F8553.png"},{"id":100270,"type":3,"publishtime":636300576000000000,"title":"所见和所知","summary":"我们所见和所知之间的关系从不确定。每天傍晚我们看到夕阳西下。我们知道大地正在旋转远离它。然而，这种了解与解释，从未与这景观相符。","image":"images/9BC45CF15B50524DFCE1E8B826F6D266.png"},{"id":100269,"type":3,"publishtime":636299712000000000,"title":"痛苦有多种多样","summary":"痛苦有多种多样。 \r\n人世间的不幸也是万象森罗。 \r\n犹如那道横过寥寥天边的彩虹，其色彩也是千变万化：\r\n有时各色清晰可辨，有时又融合交织在一起。 \r\n犹如那道横过寥寥天边的彩虹！ \r\n我为什么从美中却生发出不爱？ \r\n为什么从宁静中却得到悲哀？ \r\n不过，正如在伦理学中恶乃善之果，悲哀实际上产生于欢乐。 \r\n不论是过去幸福的记忆变为今朝之痛苦， \r\n还是今天实实在在的痛苦起源于过去莫须有的狂喜极乐。 ","image":"images/D6A7EC2BB87ECAE936506BFAE8C41F01.png"},{"id":100271,"type":3,"publishtime":636298848000000000,"title":"腼腆","summary":"腼腆是心灵的一个奇异特性，是一个范畴，是人格中敞向孤独的一面。它还是一种挥之不去的痛苦，仿佛我们有两层皮，里面的那层在生活中容易受刺激而收缩。在人的构成中，这一特质，也可以说是这种毛病，从长远来看，是自我得以永存不朽的合金基座的一部分。","image":"images/EDA68AAD9338715870FF3086A0AD3967.png"},{"id":100268,"type":3,"publishtime":636297120000000000,"title":"回忆被留在身后","summary":"回忆被留在身后，就像一列火车继续向前行驶，把一座城市留在其后一样。我可以随时驶向它，得到它。但是，我不必非这样做不可。","image":"images/6D6693737EC882F3230B2DFB0D07CCF2.png"}]
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
         * id : 100277
         * type : 3
         * publishtime : 636304896000000000
         * title : 孤独论
         * summary : 孤独为一个精神禀赋优异的人带来双重的好处：他可以与自己为伴；他用不着和别人在一起。一个人的自身拥有越多，别人能够给予他的也就越少。自身具有非凡思想热力的人是不需要与别人拥挤在一块的。有一个有思想头脑的同伴就足够了。孤独是精神卓越人士的注定命运。
         * image : images/A39EABDA533B48CE090B34251DD79D80.png
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
