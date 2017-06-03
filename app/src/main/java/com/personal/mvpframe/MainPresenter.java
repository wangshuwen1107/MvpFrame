package com.personal.mvpframe;

import com.personal.mvplibrary.presenter.BaseActivityPresenter;
import com.personal.mvplibrary.utils.Logger;

/**
 * Created by wangshuwen on 2017/6/3.
 */

public class MainPresenter extends BaseActivityPresenter<MainActivity> {

    public MainPresenter(MainActivity view) {
        super(view);
    }

    @Override
    protected void onLoadDate() {

    }

    public void getSomeData(){
        Logger.i("getSomeData is called");
        getActivity().setContent("我是加载的数据");
    }


}
