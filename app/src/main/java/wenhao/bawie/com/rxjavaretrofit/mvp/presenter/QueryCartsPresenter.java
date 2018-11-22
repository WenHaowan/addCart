package wenhao.bawie.com.rxjavaretrofit.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.model.HttpUtils;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.QueryCartsView;

/**
 * Created by HP on 2018/11/7.
 */

public class QueryCartsPresenter implements IPresenter{
    private QueryCartsView queryCartsView;

    public QueryCartsPresenter(QueryCartsView queryCartsView) {
        this.queryCartsView = queryCartsView;
    }

    public void queryCarts(String uid,String token){
        Observable<QueryCartsBean> query = HttpUtils.getUtilsInstance().api.query(uid, token);
        query.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<QueryCartsBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull QueryCartsBean queryCartsBean) {
                            queryCartsView.success(queryCartsBean.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        if (queryCartsView!=null){
            queryCartsView=null;
        }
    }
}
