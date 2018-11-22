package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;

/**
 * Created by HP on 2018/11/7.
 */

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.QueryViewHolder>{
    private Context context;
    private List<QueryCartsBean.DataBean> list;

    public QueryAdapter(Context context, List<QueryCartsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public QueryAdapter.QueryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.query_adapter_layout, parent, false);
        QueryViewHolder queryViewHolder = new QueryViewHolder(inflate);
        return queryViewHolder;
    }

    @Override
    public void onBindViewHolder(QueryAdapter.QueryViewHolder holder, int position) {
        holder.query_shang.setText(list.get(position).getSellerName());
        holder.query_list_recy_view.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        QueryListAdapter queryListAdapter = new QueryListAdapter(context, list.get(position).getList());
        holder.query_list_recy_view.setAdapter(queryListAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class QueryViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView query_list_recy_view;
        private TextView query_shang;

        public QueryViewHolder(View itemView) {
            super(itemView);
            query_shang = (TextView) itemView.findViewById(R.id.query_shang);
            query_list_recy_view = (RecyclerView) itemView.findViewById(R.id.query_list_recy_view);
        }
    }
}
