package com.personal.mvplibrary.presenter;

import android.content.Intent;

import com.personal.mvplibrary.utils.Logger;
import com.personal.mvplibrary.MvpBindException;
import com.personal.mvplibrary.view.BaseActivity;

/**
 * Created by wangshuwen on 2017/6/3.
 */

public abstract class BaseActivityPresenter<A extends BaseActivity> {

    private A mView;

    public BaseActivityPresenter(A view) {
        this.mView = view;
    }

    public void onCreate() {
        Logger.i(getClass().getSimpleName());
        onLoadDate();
    }

    protected abstract void onLoadDate();

    public void onStart() {
        Logger.i(getClass().getSimpleName());
    }

    public void onResume() {
        Logger.i(getClass().getSimpleName());
    }

    public void onNewIntent(Intent intent) {
        Logger.i(getClass().getSimpleName());
    }

    public void onPause() {
        Logger.i(getClass().getSimpleName());
    }

    public void onStop() {
        Logger.i(getClass().getSimpleName());
    }

    public void onRestart() {
        Logger.i(getClass().getSimpleName());
    }

    public void onDestroy() {
        Logger.i(getClass().getSimpleName());
        mView = null;
    }

    //检查View层是否绑定
    protected boolean isViewBind() {
        return null == mView ? false : true;
    }


    protected A getActivity() {
        if (null == mView) {
            throw new MvpBindException("currentPresenter not bind activity  ");
        } else {
            return mView;
        }
    }

}
