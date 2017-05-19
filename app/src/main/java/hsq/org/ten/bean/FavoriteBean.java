package hsq.org.ten.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by 黄上清 on 2017/5/19.
 */
@DatabaseTable(tableName = "tb_favorite")
public class FavoriteBean implements Serializable{
    @DatabaseField(generatedId = true)
    private long _id;
    @DatabaseField(canBeNull = false)
    private int id;
    @DatabaseField(canBeNull = false)
    private int type;
    @DatabaseField(canBeNull = false)
    private int month;
    @DatabaseField(canBeNull = false)
    private int week;
    @DatabaseField(canBeNull = false)
    private int day;
    @DatabaseField(canBeNull = false)
    private String title;
    @DatabaseField(canBeNull = false)
    private String summary;

    public FavoriteBean() {
    }

    public FavoriteBean(int id, int type, int month, int week, int day, String title, String summary) {
        this.id = id;
        this.type = type;
        this.month = month;
        this.week = week;
        this.day = day;
        this.title = title;
        this.summary = summary;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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
}
