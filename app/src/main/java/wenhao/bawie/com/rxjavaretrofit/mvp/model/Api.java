package wenhao.bawie.com.rxjavaretrofit.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.rxjavaretrofit.bean.AddCartsBean;
import wenhao.bawie.com.rxjavaretrofit.bean.QueryCartsBean;
import wenhao.bawie.com.rxjavaretrofit.bean.ShowBean;

/**
 * Created by HP on 2018/11/7.
 */

public interface Api {
    //首页底部展示
    @GET("product/getCarts?source=android")
    Observable<ShowBean> toget(@Query("uid") String uid);
    //添加购物车
    @GET("product/addCart?source=android")
    Observable<AddCartsBean> addget(@Query("uid") String uid,@Query("token") String token,@Query("pid") String pid);
    //查询购物车
    @GET("product/getCarts?source=android")
    Observable<QueryCartsBean> query(@Query("uid") String uid,@Query("token") String token);
}
