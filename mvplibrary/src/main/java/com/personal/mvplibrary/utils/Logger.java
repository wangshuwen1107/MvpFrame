package com.personal.mvplibrary.utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.Locale;

/**
 * This is the class to do print log of all levels.
 *
 * Author: Shper
 * Version: V0.1 2017/3/8
 */
public class Logger {

    /** This is a log tag and it also contains the source of a log message. */
    private static String TAG = "RokidCommon - %1$s.%2$s(L:%3$d)";
    private static boolean isDebug = false;

    /**
     * Private constructor, avoid this class wall be instantiated.
     */
    private Logger() {
    }

    public static void initialization(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        TAG = tag + " - %1$s.%2$s(L:%3$d)";
    }

    public static void openDebug() {
        isDebug = true;
    }

    /**
     * Send a verbose log message.
     *
     * @param messages These messages you would like logged.
     */
    public static void v(String... messages) {
        Log.v(generateTag(), concatMessage(messages));
    }

    /**
     * Send a debug log message.
     *
     * @param messages These messages you would like logged.
     */
    public static void d(String... messages) {
        if (isDebug) {
            Log.d(generateTag(), concatMessage(messages));
        }
    }

    /**
     * Send a info log message.
     *
     * @param messages These messages you would like logged.
     */
    public static void i(String... messages) {
        Log.i(generateTag(), concatMessage(messages));
    }

    /**
     * Send a warning log message.
     *
     * @param messages These messages you would like logged.
     */
    public static void w(String... messages) {
        Log.w(generateTag(), concatMessage(messages));
    }

    /**
     * Send a error log message.
     *
     * @param messages These messages you would like logged.
     */
    public static void e(String... messages) {
        Log.e(generateTag(), concatMessage(messages));
    }

    /**
     * Returns the log tag,
     * the tag contains the caller class name, method name, and source line number.
     */
    private static String generateTag() {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[4];
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        return String.format(Locale.getDefault(),
                TAG, callerClazzName, caller.getMethodName(), caller.getLineNumber());
    }

    /**
     * This method is used to concat all of the log message.
     *
     * @param messages These messages you would like logged.
     * @return The string representation of the data in this messages.
     */
    private static String concatMessage(String... messages) {
        if (null == messages || messages.length < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message);
        }
        return sb.toString();
    }

}
