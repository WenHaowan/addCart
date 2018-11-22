package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;

/**
 * Created by HP on 2018/11/7.
 */

public class QueryListAdapter extends RecyclerView.Adapter<QueryListAdapter.ListViewHolder>{
    private Context context;
    private List<QueryCartsBean.DataBean.ListBean> list;

    public QueryListAdapter(Context context, List<QueryCartsBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public QueryListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.query_list_adapter_layout, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(inflate);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(QueryListAdapter.ListViewHolder holder, int position) {
        holder.price.setText("优惠价：¥" + list.get(position).getPrice());
        holder.title.setText(list.get(position).getTitle());
        String[] imgs = list.get(position).getImages().split("\\|");
        Glide.with(context).load(imgs[0]).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView price;
        private TextView title;
        public ListViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            icon = (ImageView) itemView.findViewById(R.id.product_icon);
        }
    }
}
