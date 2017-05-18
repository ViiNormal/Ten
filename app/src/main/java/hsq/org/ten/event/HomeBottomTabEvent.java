package hsq.org.ten.event;

/**
 * Created by 黄上清 on 2017/5/18.
 */

public class HomeBottomTabEvent extends BaseEvent {
    private boolean isVisible;
    public HomeBottomTabEvent(int what) {
        super(what);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
