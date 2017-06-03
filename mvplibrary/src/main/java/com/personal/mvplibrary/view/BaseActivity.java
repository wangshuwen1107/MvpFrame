package com.personal.mvplibrary.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.personal.mvplibrary.presenter.BaseActivityPresenter;
import com.personal.mvplibrary.utils.Logger;
import com.personal.mvplibrary.MvpBindException;


/**
 * Created by wangshuwen on 2017/6/3.
 * 1.这里判断P层是否为空没有抛异常是考虑到有的页面只显示没有业务层可以没有P层 没必要强制抛异常
 */

public abstract class BaseActivity<P extends BaseActivityPresenter> extends Activity {

    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initVariables(getIntent().getData(), savedInstanceState);
        initListener();
        initPresenter();
        if (null!=mPresenter){
            mPresenter.onCreate();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onStart();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (null!=mPresenter){
            mPresenter.onNewIntent(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onStop();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onRestart();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i(getClass().getSimpleName());
        if (null != mPresenter) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }

    //子类实现提供布局
    protected abstract int getLayoutId();

    //初始化监听
    protected abstract void initListener();

    // 初始化成员变量
    protected abstract void initVariables(Uri data, Bundle savedInstanceState);

    // 初始化P层
    protected abstract P initPresenter();

    //获取P层
    public P getPresenter() {
        if (null == mPresenter) {
            throw new MvpBindException("currentActivity not bind presenter ");
        } else {
            return mPresenter;
        }
    }

    public void showToastShort(final CharSequence text) {
        Logger.i("The toast context: " + text);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToastLong(final CharSequence text) {
        Logger.i("The toast context: " + text);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }


}
