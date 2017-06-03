package com.personal.mvplibrary.presenter;

import com.personal.mvplibrary.MvpBindException;
import com.personal.mvplibrary.utils.Logger;
import com.personal.mvplibrary.view.BaseFragment;

/**
 * Created by wangshuwen on 2017/6/3.
 */

public abstract class BaseFragmentPresenter<F extends BaseFragment> {

    private F mFragment;

    public abstract void onLoadData();

    public BaseFragmentPresenter(F fragment) {
        this.mFragment=fragment;
    }

    public void onStart(){
        Logger.i(getClass().getSimpleName());
    }

    public void onResume(){
        Logger.i(getClass().getSimpleName());
    }

    public void onPause(){
        Logger.i(getClass().getSimpleName());
    }

    public void onStop(){
        Logger.i(getClass().getSimpleName());
    }

    public void onDestroyView(){
        Logger.i(getClass().getSimpleName());
    }

    public void onDestroy(){
        Logger.i(getClass().getSimpleName());
        mFragment=null;
    }

    protected F getFragment() {
        if (null == mFragment) {
            throw new MvpBindException("currentPresenter not bind presenter");
        } else {
            return mFragment;
        }
    }

}
