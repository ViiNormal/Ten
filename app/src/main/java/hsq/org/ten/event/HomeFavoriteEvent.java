package hsq.org.ten.event;

/**
 * Created by 黄上清 on 2017/5/19.
 */

public class HomeFavoriteEvent extends BaseEvent {
    private String tag;
    private boolean isFavorite;
    private int position;
    private int month;
    private int week;
    private int day;
    public HomeFavoriteEvent(int what) {
        super(what);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
