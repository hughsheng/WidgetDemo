package com.example.sztangli.widgedemo.weather.mvp;

import com.example.sztangli.widgedemo.base.api.bean.ErrorResultBean;
import com.example.sztangli.widgedemo.base.api.rx.SchedulersCompat;
import com.example.sztangli.widgedemo.base.mvp.HttpDelegate;
import com.example.sztangli.widgedemo.weather.api.WeatherApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * created by tl on 2018-10-23
 */
public class WeatherPresenter extends HttpDelegate implements WeatherContract.Presenter {

  private WeatherContract.IView iView;
  private WeatherApiService weatherApiService;

  @Inject
  public WeatherPresenter(WeatherContract.IView iView, WeatherApiService weatherApiService) {
    this.iView = iView;
    this.weatherApiService = weatherApiService;
  }

  //修饰方法自动执行
  @Inject
  public void setUpPresenter() {
    iView.setPresenter(this);
  }


  @Override
  public void getWeather(String city) {
    Disposable disposable = weatherApiService.getWeather(city)
        .compose(SchedulersCompat.applyIoSchedulers())  //以第一个订阅的线程为准
        .doOnSubscribe(new Consumer<Object>() {
          @Override
          public void accept(Object o) throws Exception {
            iView.show();
          }
        })
        .subscribeOn(AndroidSchedulers.mainThread())
        .doOnTerminate(new Action() {
          @Override
          public void run() throws Exception {
            iView.hide();
          }
        })
        .subscribe(new Consumer<Object>() {
          @Override
          public void accept(Object o) throws Exception {
            WeatherBean weatherBean = (WeatherBean) o;
            iView.getWeatherSuccess(weatherBean);
          }
        }, new ErrorResultBean() {
          @Override
          protected void onError(ErrorResultBean.ErrorBean errorBean) {
            iView.onLoadFail(errorBean);
          }
        });
    addSubscription(disposable);
  }




  @Override
  public void unBindPresent() {
    onUnSubscribe();
  }

}
