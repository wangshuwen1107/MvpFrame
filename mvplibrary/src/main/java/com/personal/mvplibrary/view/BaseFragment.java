package com.personal.mvplibrary.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.personal.mvplibrary.MvpBindException;
import com.personal.mvplibrary.presenter.BaseFragmentPresenter;
import com.personal.mvplibrary.utils.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment View层
 * @param <P>代表绑定的P层类型
 * 如果用到FragmentPagerAdapter由于viewpager的原因会默认加载左右两边的fragment，可以在setUserVisibleHint里面实现lazy load
 */

public abstract class BaseFragment<P extends BaseFragmentPresenter> extends Fragment {

    private View mRootView;

    private P mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {

            mRootView = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, mRootView);
            //初始化成员变量
            initVariables(mRootView, container, savedInstanceState);
            // 初始化监听
            initListeners();
            // 绑定化P层
            mPresenter = initPresenter();

            if (null != mPresenter) {
                mPresenter.onLoadData();
            }

        }
        return mRootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null != mPresenter) {
            mPresenter.onStart();
        }
        Logger.i(getClass().getSimpleName());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mPresenter) {
            mPresenter.onResume();
        }
        Logger.i(getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != mPresenter) {
            mPresenter.onPause();
        }
        Logger.i(getClass().getSimpleName());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (null != mPresenter) {
            mPresenter.onStop();
        }
        Logger.i(getClass().getSimpleName());
    }

    //fragment移除视图的时候滴啊用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null!=mPresenter){
            mPresenter.onDestroyView();
        }
        Logger.i(getClass().getSimpleName());
    }

    //Fragment 释放支资源的时候
    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i(getClass().getSimpleName());
        unbinder.unbind();
        if (null != mPresenter) {
            Logger.i(mPresenter.getClass().getSimpleName()+" unbind ");
            mPresenter.onDestroy();
            mPresenter = null;
        }
        mRootView = null;
    }

    public Intent getMIntent() {
        Logger.d(this.getClass().getSimpleName());
        return getActivity().getIntent();
    }

    public void showToastShort(final CharSequence text) {
        Logger.i("The toast context: " + text);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToastLong(final CharSequence text) {
        Logger.i("The toast context: " + text);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
            }
        });
    }

    //初始化成员变量
    protected abstract void initVariables(View mRootView, ViewGroup container, Bundle savedInstanceState);

    //初始化监听
    protected abstract void initListeners();

    //绑定业务层
    protected abstract P initPresenter();

    //子类体统视图布局
    protected abstract int getLayoutId();

    //获取presenter
    protected P getPresenter() {
        if (null == mPresenter) {
            throw new MvpBindException("currentFragment not bind presenter ");
        } else {
            return mPresenter;
        }
    }

}
