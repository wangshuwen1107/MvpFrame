package com.personal.mvplibrary.presenter;

import com.personal.mvplibrary.MvpBindException;
import com.personal.mvplibrary.utils.Logger;
import com.personal.mvplibrary.view.BaseFragment;

/**
 *  Fragment 业务逻辑处理基类
 * @param <F> 代表Fragment的泛型
 */

public abstract class BaseFragmentPresenter<F extends BaseFragment> {

    private F mFragment;

    public abstract void onLoadData();

    public BaseFragmentPresenter(F fragment) {
        this.mFragment = fragment;
        Logger.d("BindFragment: " + (null != fragment ? fragment.getClass().getSimpleName() : "Null"));
    }

    public void onStart() {
        Logger.i(getClass().getSimpleName());
    }

    public void onResume() {
        Logger.i(getClass().getSimpleName());
    }

    public void onPause() {
        Logger.i(getClass().getSimpleName());
    }

    public void onStop() {
        Logger.i(getClass().getSimpleName());
    }

    public void onDestroyView() {
        Logger.i(getClass().getSimpleName());
    }

    public void onDestroy() {
        Logger.i(getClass().getSimpleName());
        Logger.d("UnBindFragment: " + (null != mFragment ? mFragment.getClass().getSimpleName() : "Null"));
        mFragment = null;
    }

    //判断是否绑定fragment
    protected boolean isFragmentBind() {
        return null == mFragment ? false : true;
    }

    //获取View层
    protected F getFragment() {
        if (null == mFragment) {
            throw new MvpBindException("currentPresenter not bind presenter");
        } else {
            return mFragment;
        }
    }


}
