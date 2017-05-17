package hsq.org.ten.event;

/**
 * Created by 黄上清 on 2017/5/17.
 */

public class HomeTabEvent extends BaseEvent {
    private int position;
    private String tag;

    public HomeTabEvent(int what) {
        super(what);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
