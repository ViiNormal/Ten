package hsq.org.ten.bean;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class DiagramContentBean {
    /**
     * id : 100277
     * title : 孤独论
     * author : Hossein Zare
     * authorbrief : 摄影©Hossein Zare
     * text1 : 孤独为一个精神禀赋优异的人带来双重的好处：他可以与自己为伴；他用不着和别人在一起。一个人的自身拥有越多，别人能够给予他的也就越少。自身具有非凡思想热力的人是不需要与别人拥挤在一块的。有一个有思想头脑的同伴就足够了。孤独是精神卓越人士的注定命运。
     * image1 : images/A39EABDA533B48CE090B34251DD79D80.png
     * text2 : —叔本华 《孤独论》
     * times : 4051
     * publishtime : 636304896000000000
     * status : 0
     * errMsg : null
     */

    private int id;
    private String title;
    private String author;
    private String authorbrief;
    private String text1;
    private String image1;
    private String text2;
    private int times;
    private long publishtime;
    private int status;
    private Object errMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public void setAuthorbrief(String authorbrief) {
        this.authorbrief = authorbrief;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

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
}
