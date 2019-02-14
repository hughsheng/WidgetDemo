package com.example.sztangli.widgedemo.weather.api;


import com.example.sztangli.widgedemo.base.api.bean.ResultBean;
import com.example.sztangli.widgedemo.utils.HttpUtil;
import com.example.sztangli.widgedemo.weather.mvp.PunchBean;
import com.example.sztangli.widgedemo.weather.mvp.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * created by tl on 2018-10-23
 */
public interface WeatherApiService {
  String CITY = "city";
  String TOKEN = "token";
  String MAC = "mac";
  String LLI_UNICODE = "LliUnicode";
  String PHONE_OS = "PhoneOs";
  String SIGNATURE = "signature";


  @GET(HttpUtil.WEATHERAPI)
  Observable<ResultBean<WeatherBean>> getWeather(@Query(CITY) String city);

  @FormUrlEncoded
  @POST("https://mthttp.fangte.com/api/Attendance/ClockIn")
  Observable<PunchBean> NewGetPlayCard(@Field(TOKEN) String token, @Field(MAC) String mac,
                                       @Field(LLI_UNICODE) String lliUnicode,
                                       @Field(PHONE_OS) String phoneOS,
                                       @Field(SIGNATURE) String signature);
}
