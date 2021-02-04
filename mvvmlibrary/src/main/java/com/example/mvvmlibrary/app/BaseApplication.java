package com.example.mvvmlibrary.app;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import java.util.List;
import java.util.Map;

import com.example.mvvmlibrary.util.SharedPreferencesUtils;

/**
 * created by com.tl
 * created at 2020/8/20
 */
public class BaseApplication extends Application {
    private int width = 0, height = 0;
    private SharedPreferencesUtils sharedPreferencesUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        //注册App生命周期观察者
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationLifecycleObserver());
        sharedPreferencesUtils = SharedPreferencesUtils.getInstance(this);
    }

    private void initProperty() {
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels; // 屏幕宽度（像素）
        height = metric.heightPixels; // 屏幕高度（像素
    }

    public int getWindowWidth() {
        if (width == 0) {
            initProperty();
        }
        return this.width;
    }

    public int getWindowHeight() {
        if (height == 0) {
            initProperty();
        }
        return this.height;
    }


    private static class ApplicationLifecycleObserver implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private void onAppForeground() {
            onAppForeground();
            Log.i("appState", "Foreground");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private void onAppBackground() {
            onAppBackground();
            Log.i("appState", "Background");
        }
    }


    public void onForeground() {
    }

    ;

    public void onBackground() {
    }

    ;

    /**
     * 采用andriod本身数据格式缓存数据
     * 后期可以更改成其他缓存
     */
    public void saveCacheData(String key, Object data) {
        saveCacheData(SharedPreferencesUtils.SP_NAME, key, data);
    }

    private void saveCacheData(final String fileName, final String key, final Object defaultObject) {
        sharedPreferencesUtils.saveData(fileName, key, defaultObject);
    }


    public Map<String, Integer> getBuriedPointData(String userId) {
        return sharedPreferencesUtils.getBuriedPointData(SharedPreferencesUtils.SP_NAME, userId);
    }

    public void clearBuriedPointData(String userId) {
        sharedPreferencesUtils.clearBuriedPointData(SharedPreferencesUtils.SP_NAME, userId);
    }

    public Object getCacheData(String key, Object defaultObject) {
        return getCacheData(SharedPreferencesUtils.SP_NAME, key, defaultObject);
    }

    private Object getCacheData(final String fileName, final String key, final Object defaultObject) {
        return sharedPreferencesUtils.getData(fileName, key, defaultObject);
    }

    public void saveCacheListData(String key, final List<Map<String, String>> dataList) {
        saveCacheListData(SharedPreferencesUtils.SP_NAME, key, dataList);
    }

    private void saveCacheListData(final String fileName, final String key, final List<Map<String,
            String>> dataList) {
        sharedPreferencesUtils.saveListData(fileName, key, dataList);
    }

    public List<Map<String, String>> getCacheListData(final String key) {
        return getCacheListData(SharedPreferencesUtils.SP_NAME, key);
    }

    private List<Map<String, String>> getCacheListData(final String fileName, final String key) {
        return sharedPreferencesUtils.getListData(fileName, key);
    }

    public void removeListData(final String key) {
        sharedPreferencesUtils.removeListData(SharedPreferencesUtils.SP_NAME, key);
    }

    public void saveCacheStringListData(String key, final List<String> dataList) {
        sharedPreferencesUtils.saveStringListData(SharedPreferencesUtils.SP_NAME, key, dataList);
    }

    public List<String> getCacheStringListData(final String key) {
        return sharedPreferencesUtils.getStringListData(SharedPreferencesUtils.SP_NAME, key);
    }

    public void saveMapData(String key, Map<String, String> mapData) {
        sharedPreferencesUtils.saveMapData(SharedPreferencesUtils.SP_NAME, key, mapData);
    }

    public Map<String, String> getMapData(String key) {
        return sharedPreferencesUtils.getMapData(SharedPreferencesUtils.SP_NAME, key);
    }

    public void saveTreeMapData(String key, Map<String, String> mapData) {
        sharedPreferencesUtils.saveTreeMapData(SharedPreferencesUtils.SP_NAME, key, mapData);
    }

    public Map<String, String> getTreeMapData(String key) {
        return sharedPreferencesUtils.getTreeMapData(SharedPreferencesUtils.SP_NAME, key);
    }
}
