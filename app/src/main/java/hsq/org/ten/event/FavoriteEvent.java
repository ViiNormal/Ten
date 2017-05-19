package hsq.org.ten.event;

import hsq.org.ten.bean.FavoriteBean;

/**
 * Created by 黄上清 on 2017/5/19.
 */

public class FavoriteEvent extends BaseEvent {
    private boolean isFavorite;
    private FavoriteBean bean;
    public FavoriteEvent(int what) {
        super(what);
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public FavoriteBean getBean() {
        return bean;
    }

    public void setBean(FavoriteBean bean) {
        this.bean = bean;
    }
}
