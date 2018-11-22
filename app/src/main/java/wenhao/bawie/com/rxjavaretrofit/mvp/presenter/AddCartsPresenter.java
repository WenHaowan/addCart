package wenhao.bawie.com.rxjavaretrofit.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.rxjavaretrofit.bean.AddCartsBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.model.HttpUtils;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.AddCartsView;

/**
 * Created by HP on 2018/11/7.
 */

public class AddCartsPresenter implements IPresenter{
    private AddCartsView addCartsView;

    public AddCartsPresenter(AddCartsView addCartsView) {
        this.addCartsView = addCartsView;
    }

    public void getAddCarts(String uid,String token,String pid){
        Observable<AddCartsBean> addget = HttpUtils.getUtilsInstance().api.addget(uid, token, pid);
        addget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddCartsBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull AddCartsBean addCartsBean) {
                        addCartsView.onSuccess(addCartsBean.getMsg());
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
        if (addCartsView!=null){
            addCartsView=null;
        }
    }
}
