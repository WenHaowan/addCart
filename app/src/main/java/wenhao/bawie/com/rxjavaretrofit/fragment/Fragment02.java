package wenhao.bawie.com.rxjavaretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.adapter.QueryAdapter;
import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.presenter.QueryCartsPresenter;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.QueryCartsView;

/**
 * Created by HP on 2018/11/7.
 */

public class Fragment02 extends Fragment implements QueryCartsView{

    private View view;
    private XRecyclerView x_recy_view;
    private String uid = "21201";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        x_recy_view = (XRecyclerView) view.findViewById(R.id.x_recy_view);
        x_recy_view.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        x_recy_view.setLoadingMoreEnabled(false);

        x_recy_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                loadData();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initView() {
        loadData();
    }

    private void loadData() {
        QueryCartsPresenter queryCartsPresenter = new QueryCartsPresenter(this);
        queryCartsPresenter.queryCarts(uid,"EF3C9826956CF9F48F3B67FA55910191");
    }

    @Override
    public void success(List<QueryCartsBean.DataBean> data) {
        QueryAdapter queryListAdapter = new QueryAdapter(getActivity(),data);
        x_recy_view.setAdapter(queryListAdapter);
        x_recy_view.refreshComplete();
    }
}
