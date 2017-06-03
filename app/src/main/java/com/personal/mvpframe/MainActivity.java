package com.personal.mvpframe;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.personal.mvplibrary.utils.Logger;
import com.personal.mvplibrary.view.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> {


    @BindView(R.id.main_activity_contentTv)
    TextView contentTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initVariables(Uri data, Bundle savedInstanceState) {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @OnClick(R.id.main_activity_bt)
    public void onBtClick() {
        Logger.i("onBtClick is called");
        getPresenter().getSomeData();
    }

    public void setContent(String text){
        Logger.i("setContent text ="+text);
        if (TextUtils.isEmpty(text)){
            Logger.e("text is empty do nothing !");
            return;
        }
        contentTv.setText(text);
    }
}
