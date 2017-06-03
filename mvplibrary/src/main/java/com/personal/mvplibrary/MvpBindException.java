package com.personal.mvplibrary;

/**
 * Created by wangshuwen on 2017/6/3.
 */

public class MvpBindException extends RuntimeException {

    private String errorMsg;

    public MvpBindException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
