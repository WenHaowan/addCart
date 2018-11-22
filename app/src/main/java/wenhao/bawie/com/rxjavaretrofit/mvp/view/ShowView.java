package wenhao.bawie.com.rxjavaretrofit.mvp.view;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;

/**
 * Created by HP on 2018/11/7.
 */

public interface ShowView {
    void onSuccess(List<ShowBean.DataBean> list);
}
