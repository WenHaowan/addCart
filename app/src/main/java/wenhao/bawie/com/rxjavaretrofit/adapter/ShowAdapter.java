package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;

/**
 * Created by HP on 2018/11/7.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder>{

    private Context context;
    private List<ShowBean.DataBean> list;

    public ShowAdapter(Context context, List<ShowBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowAdapter.ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_adapter_layout, parent, false);
        ShowViewHolder showViewHolder = new ShowViewHolder(inflate);
        return showViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowAdapter.ShowViewHolder holder, int position) {
        holder.text_name.setText(list.get(position).getSellerName());
        holder.show_list_recy_view.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        ShowListAdapter showListAdapter = new ShowListAdapter(context,list.get(position).getList());
        holder.show_list_recy_view.setAdapter(showListAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView show_list_recy_view;
        private TextView text_name;

        public ShowViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            show_list_recy_view = (RecyclerView) itemView.findViewById(R.id.show_list_recy_view);
        }
    }
}
