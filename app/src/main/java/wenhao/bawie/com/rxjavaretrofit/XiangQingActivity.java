package wenhao.bawie.com.rxjavaretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import wenhao.bawie.com.rxjavaretrofit.mvp.presenter.AddCartsPresenter;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.AddCartsView;

public class XiangQingActivity extends AppCompatActivity implements AddCartsView{

    private WebView web_view;
    private ImageView image_button;
    private RelativeLayout add_shop_car;
    private String pid;
    private AddCartsPresenter addCartsPresenter;
    private String uid = "21201";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        web_view = (WebView) findViewById(R.id.web_view);
        add_shop_car = (RelativeLayout) findViewById(R.id.add_shop_car);
        image_button = (ImageView) findViewById(R.id.image_button);
        //获取传过来的值
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        pid = intent.getStringExtra("pid");
        web_view.loadUrl(link);
        //获取p层方法
        addCartsPresenter = new AddCartsPresenter(this);
        add_shop_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCartsPresenter.getAddCarts(uid,"EF3C9826956CF9F48F3B67FA55910191",pid);
            }
        });
        //销毁当前页面
        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onSuccess(final String msg) {
        Toast.makeText(XiangQingActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
