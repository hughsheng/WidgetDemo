# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}   b
#混淆基本配置
-dontwarn
#指定代码的压缩级别
-optimizationpasses 5
#包明不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#预校验
-dontpreverify
#优化  不优化输入的类文件
-verbose
# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#保护注解
-keepattributes *Annotation*
# 抑制警告
-ignorewarnings
#不混淆系统文件
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.app.IntentService
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends com.hytch.ftthemepark.base.api.bean.** { *; }
-keep public class **.mvp.**Bean { *; }
-keep public class **.mvp.**Bean$**Entity { *; }
-keep public class **.extra.** { *; }

-dontwarn android.support.**
-keep class android.support.** { *; }
#apk 包内所有 class 的内部结构
-dump class_files.txt

# --------- 忽略异常提示 --------------------
#butterknife start
-dontwarn butterknife.internal.**
-keep class butterknife.** { *; }
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}
#butterknife end
#支付宝 start
-dontwarn com.alipay.**
-keep class com.alipay.** { *; }
-keep class HttpUtils.HttpFetcher { *; }
-dontwarn com.ta.utdid2.**
-keep class com.ta.utdid2.** { *; }
-dontwarn com.ut.device.**
-keep class com.ut.device.** { *; }
#支付宝 end
-dontwarn com.mikepenz.**
-dontwarn com.amap.**
-dontwarn com.rey.**
-dontwarn com.testin.**
# ---------------- eventbus避免混淆 start------------
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(Java.lang.Throwable);
}
# ---------------- eventbus避免混淆 end------------
# --------------- 友盟统计避免混淆 -------------------------
-dontwarn android.support.v4.**
-dontwarn org.apache.commons.net.**
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}
-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.WebView
-dontwarn com.umeng.**
-dontwarn u.aly.**
-keep class u.aly.** {*;}

-keep public class com.umeng.**{ *;}
# 源文件和行号的信息不混淆
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes SourceFile,LineNumberTable
-keep public interface com.umeng.socialize.**
-keep public class com.umeng.socialize.** {*;}
-keep class com.umeng.socialize.sensor.**{ *;}
#不混淆资源类(友盟统计)
-keep public class com.hytch.ftthemepark.R$*{
    public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}

#腾讯start
-dontwarn com.tencent.**
-dontwarn com.tencent.weibo.sdk.**
-keep public interface com.tencent.**
-keep public class com.tencent.** {*;}
-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}
#腾讯end

#不混淆自定义的第三方包
#square strat
-dontwarn com.squareup.**
-keep class com.squareup.** { *; }
#square end
#okhttp3 start
-dontwarn okhttp3.**
-keep class okhttp3.** { *;}
-dontwarn okio.**
-keep class okio.** { *;}
#okhttp3 end
#retrofit2 and adapter start
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
#retrofit2 and adapter end
#rx start
-dontwarn rx.**
-keep class rx.** { *; }
-dontwarn com.jakewharton.rxbinding.**
-keep class com.jakewharton.rxbinding.** { *; }
#rx end
#注解 start
-dontwarn javax.**
-keep class javax.** { *; }
#注解 end
#dagger start
-dontwarn dagger.**
-keep class dagger.** { *; }
#dagger end
#加密包 start
-dontwarn org.bouncycastle.**
-keep class org.bouncycastle.** { *; }
#加密包 end
#极光push
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
#apache网络访问包
-dontwarn org.apache.http.**
-keep class org.apache.http.** { *; }
#不混淆卡片布局
-dontwarn com.bartoszlipinski.flippablestackview.**
-keep class com.bartoszlipinski.flippablestackview.** { *; }

#不混淆通用适配器
-dontwarn com.lfp.lfp_base_recycleview_library.**
-keep class com.lfp.lfp_base_recycleview_library.** { *; }
-dontwarn in.srain.cube.views.ptr.**
-keep class in.srain.cube.views.ptr.** { *; }

-dontwarn com.ashokvarma.bottomnavigation.**
-keep class com.ashokvarma.bottomnavigation.** { *; }

-dontwarn com.bigkoo.convenientbanner.**
-keep class com.bigkoo.convenientbanner.** { *; }

#高的地图 start
-dontwarn com.amap.api.**
-keep class com.amap.api.** {*;}
-dontwarn com.autonavi.**
-keep class com.autonavi.** {*;}
-dontwarn com.loc.**
-keep class com.loc.** { *; }
#高的地图 end

#百度地图 start
-keep class com.baidu.** {*;}
-dontwarn com.baidu.**
-keep class vi.com.** {*;}
-dontwarn vi.com.**
#百度地图 end

#科大讯飞start
-dontwarn com.iflytek.**
-keep class com.iflytek.** {*;}
-dontwarn com.iflytek.sunflower.**
-keep class com.iflytek.sunflower.** {*;}
#科大讯飞end

#gson和zxing start
-dontwarn com.google.**
-keep class com.google.** {*; }
#gson和zxing end
#glide start
-dontwarn com.bumptech.glide.**
-keep class com.bumptech.glide.** { *; }
#glide end
#本地项目 start
-dontwarn com.hytch.ftthemepark.base.**
-keep class com.hytch.ftthemepark.base.** { *; }
-dontwarn com.hytch.ftthemepark.activity.**
-keep class com.hytch.ftthemepark.activity.** { *; }
-dontwarn com.hytch.ftthemepark.beahavior.**
-keep class com.hytch.ftthemepark.beahavior.** { *; }
-keep class com.hytch.ftthemepark.socketprotocol.** { *; }

#长链接 start
-dontwarn hytch.com.ftlvyou_lib.**
-keep class com.ftlvyou_lib.** { *; }
-dontwarn org.apache.mina.**
-keep class org.apache.mina.** { *; }
-dontwarn org.slf4j.**
-keep class org.slf4j.** { *; }
#长链接 end
#本地项目 end
#bugly start
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.** { *; }
#bugly end