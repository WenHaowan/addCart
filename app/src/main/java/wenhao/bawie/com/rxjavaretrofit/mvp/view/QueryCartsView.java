package wenhao.bawie.com.rxjavaretrofit.mvp.view;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;

/**
 * Created by HP on 2018/11/7.
 */

public interface QueryCartsView {
    void success(List<QueryCartsBean.DataBean> data);
}
