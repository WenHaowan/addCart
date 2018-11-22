package wenhao.bawie.com.rxjavaretrofit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import wenhao.bawie.com.rxjavaretrofit.fragment.Fragment01;
import wenhao.bawie.com.rxjavaretrofit.fragment.Fragment02;

public class MainActivity extends AppCompatActivity{

    private BottomTabBar bottombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottombar = (BottomTabBar) findViewById(R.id.bottombar);
        bottombar.init(getSupportFragmentManager())
                .setFontSize(15)
                .setImgSize(70,70)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .setTabPadding(4,6,10)
                .addTabItem("首页",R.drawable.index_no,Fragment01.class)
                .addTabItem("购物车",R.drawable.car_no,Fragment02.class)
                .isShowDivider(false);
    }
}
