package com.guyuan.handlein.base.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.guyuan.handlein.base.app.HandleInApplication;


/**
 * .
 * 开启后台下载服务
 */
public class BackService extends IntentService {

    public static final String LOGIN = "service_action_login";
    public static final String NOT_HANDLE_CONTROL_MESSAGE = "service_not_handle_message";
    private HandleInApplication mApplication;

    public BackService() {
        super("BackService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = HandleInApplication.getInstance();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            final Bundle bundle = intent.getExtras();
            if (LOGIN.equals(action)) {

            }
        }
    }
}
