package hsq.org.ten.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import hsq.org.ten.R;
import hsq.org.ten.bean.FavoriteBean;
import hsq.org.ten.config.FavoriteConfig;

/**
 * Created by 黄上清 on 2017/5/19.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private Context context;
    private List<FavoriteBean> data;
    private RecyclerView mRecycler;
    private OnItemClickListener onItemClickListener;

    public FavoriteAdapter(Context context, List<FavoriteBean> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addItem(FavoriteBean data){
        if (data != null) {
            this.data.add(data);
            notifyDataSetChanged();
        }
    }
    public void deleteItem(FavoriteBean data){
        if (data != null) {
            this.data.remove(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.favorite_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FavoriteBean bean = data.get(position);
        switch (bean.getType()){
            case FavoriteConfig.TYPE_CRITIC:
                holder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
                holder.type.setText(FavoriteConfig.CRITIC);
                break;
            case FavoriteConfig.TYPE_NOVEL:
                holder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorBack20));
                holder.type.setText(FavoriteConfig.NOVEL);
                break;
            case FavoriteConfig.TYPE_DIAGRAM:
                holder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorGray7B));
                holder.type.setText(FavoriteConfig.DIAGRAM);
                break;
        }
        int day = bean.getDay();
        holder.day.setText(day < 10 ? "0" + day : day + "");
        int month = bean.getMonth();
        holder.month.setText(month < 10 ? "0" + month : month + "");
        holder.title.setText(bean.getTitle());
        holder.summary.setText(bean.getSummary());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecycler = recyclerView;
    }

    @Override
    public void onClick(View v) {
        if (mRecycler != null && onItemClickListener != null) {
            int childAdapterPosition = mRecycler.getChildAdapterPosition(v);
            onItemClickListener.onItemClick(childAdapterPosition);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public FavoriteBean getItem(int position){
        if (position > 0 && position < data.size()){
            return data.get(position);
        }
        return null;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout layout;
        private  TextView type;
        private  TextView day;
        private  TextView month;
        private  TextView title;
        private  TextView summary;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = (RelativeLayout) itemView.findViewById(R.id.favorite_item_layout);
            type = (TextView) itemView.findViewById(R.id.favorite_item_type);
            day = (TextView) itemView.findViewById(R.id.favorite_item_day);
            month = (TextView) itemView.findViewById(R.id.favorite_item_month);
            title = (TextView) itemView.findViewById(R.id.favorite_item_title);
            summary = (TextView) itemView.findViewById(R.id.favorite_item_summary);
        }
    }
}
