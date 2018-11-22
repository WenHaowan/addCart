package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.XiangQingActivity;
import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;

/**
 * Created by HP on 2018/11/7.
 */

public class ShowListAdapter extends RecyclerView.Adapter<ShowListAdapter.ListViewHolder>{
    private Context context;
    private List<ShowBean.DataBean.ListBean> list;

    public ShowListAdapter(Context context, List<ShowBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_list_adapter_layout, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(inflate);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowListAdapter.ListViewHolder holder, final int position) {
        holder.list_title.setText(list.get(position).getTitle());
        holder.list_price.setText("价格："+list.get(position).getPrice());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.list_image);
        holder.linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,XiangQingActivity.class);
                intent.putExtra("link",list.get(position).getDetailUrl());
                intent.putExtra("pid",list.get(position).getPid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linear_layout;
        private ImageView list_image;
        private TextView list_price;
        private TextView list_title;

        public ListViewHolder(View itemView) {
            super(itemView);
            list_image = (ImageView) itemView.findViewById(R.id.list_image);
            list_price = (TextView) itemView.findViewById(R.id.list_price);
            list_title = (TextView) itemView.findViewById(R.id.list_title);
            linear_layout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}
