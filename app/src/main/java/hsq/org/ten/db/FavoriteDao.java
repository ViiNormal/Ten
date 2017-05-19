package hsq.org.ten.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

import hsq.org.ten.bean.FavoriteBean;

/**
 * Created by 黄上清 on 2017/5/19.
 */

public class FavoriteDao {
    private Dao<FavoriteBean, Long> mDao;
    public FavoriteDao(Context context){
        DBHelper dbHelper = DBHelper.getInstance(context.getApplicationContext());
        try {
            mDao = dbHelper.getDao(FavoriteBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入一条数据
     */
    public boolean insertItem(FavoriteBean favorite) {
        try {
            int i = mDao.create(favorite);
            if (i == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除一条数据
     */
    public boolean deleteItem(FavoriteBean favorite) {
        try {
            int num = mDao.delete(favorite);
            if (num == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 修改一条数据
     */
    public boolean updateItem(FavoriteBean favorite) {
        try {
            int update = mDao.update(favorite);
            if (update == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询所有数据
     */
    public List<FavoriteBean> queryAll() {
        try {
            return mDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteItemByTypeAndId(int type, int id){
        try {
            DeleteBuilder<FavoriteBean, Long> deleteBuilder = mDao.deleteBuilder();
            deleteBuilder.where().eq("type", type).and().eq("id", id);
            int delete = deleteBuilder.delete();
            if (delete == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
