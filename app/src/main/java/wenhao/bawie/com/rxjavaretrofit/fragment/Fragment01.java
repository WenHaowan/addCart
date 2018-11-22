package wenhao.bawie.com.rxjavaretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.adapter.ShowAdapter;
import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.presenter.ShowPresenter;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.ShowView;

/**
 * Created by HP on 2018/11/7.
 */

public class Fragment01 extends Fragment implements ShowView{

    private View view;
    private RecyclerView show_recy_view;
    private String uid = "71";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment01, container, false);
        initView();
        return view;
    }

    private void initView() {
        show_recy_view = (RecyclerView) view.findViewById(R.id.show_recy_view);
        show_recy_view.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        ShowPresenter showPresenter = new ShowPresenter(this);
        showPresenter.getShowList(uid);
    }

    @Override
    public void onSuccess(List<ShowBean.DataBean> list) {
        ShowAdapter adapter = new ShowAdapter(getActivity(),list);
        show_recy_view.setAdapter(adapter);
    }
}
