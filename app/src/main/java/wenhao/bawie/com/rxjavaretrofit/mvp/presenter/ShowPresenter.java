package wenhao.bawie.com.rxjavaretrofit.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.model.HttpUtils;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.ShowView;

/**
 * Created by HP on 2018/11/7.
 */

public class ShowPresenter implements IPresenter{
    private ShowView showView;

    public ShowPresenter(ShowView showView) {
        this.showView = showView;
    }

    public void getShowList(String uid){
        Observable<ShowBean> toget = HttpUtils.getUtilsInstance().api.toget(uid);
        toget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override

                    public void onNext(@NonNull ShowBean showListBean) {
                        showView.onSuccess(showListBean.getData());
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
        if (showView!=null){
            showView=null;
        }
    }
}
