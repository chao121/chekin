package com.dayouzc.e2eapp.ebusiness.checkin.vertical;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dayouzc.e2e.core.DYUtils;
import com.dayouzc.e2e.core.E2EContextManager;
import com.dayouzc.e2e.core.util.LogUtils;
import com.dayouzc.e2e.core.view.webview.DyWebViewManager;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.Api;
import com.google.gson.GsonBuilder;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.AppModule;
import com.jess.arms.di.module.ClientModule;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.http.imageloader.glide.GlideImageLoaderStrategy;
import com.jess.arms.integration.ConfigModule;

import java.util.List;

import io.rx_cache2.internal.RxCache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ================================================
 *
 * @Description: 配置参数
 * @Author qc
 * ================================================
 */
public final class GlobalConfiguration implements ConfigModule {
//    public static String sDomain = Api.APP_DOMAIN;

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlobalConfigModule.Builder builder) {

        builder.baseurl(Api.BaseUrl)
                //强烈建议自己自定义图片加载逻辑, 因为 arms-imageloader-glide 提供的 GlideImageLoaderStrategy 并不能满足复杂的需求
                .imageLoaderStrategy(new GlideImageLoaderStrategy())
                .gsonConfiguration(new AppModule.GsonConfiguration() {
                    @Override
                    public void configGson(@NonNull Context context1, @NonNull GsonBuilder gsonBuilder) {//这里可以自己自定义配置 Gson 的参数
                        gsonBuilder
                                .serializeNulls()//支持序列化值为 null 的参数
                                .enableComplexMapKeySerialization();//支持将序列化 key 为 Object 的 Map, 默认只能序列化 key 为 String 的 Map
                    }
                })
                .retrofitConfiguration(new ClientModule.RetrofitConfiguration() {
                    @Override
                    public void configRetrofit(@NonNull Context context1, @NonNull Retrofit.Builder retrofitBuilder) {//这里可以自己自定义配置 Retrofit 的参数, 甚至您可以替换框架配置好的 OkHttpClient 对象 (但是不建议这样做, 这样做您将损失框架提供的很多功能)
                        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());//比如使用 FastJson 替代 Gson
                    }
                })
                .okhttpConfiguration(new ClientModule.OkhttpConfiguration() {
                    @Override
                    public void configOkhttp(@NonNull Context context1, @NonNull OkHttpClient.Builder okhttpBuilder) {//这里可以自己自定义配置 Okhttp 的参数
                    }
                })
                .rxCacheConfiguration(new ClientModule.RxCacheConfiguration() {
                    @Override
                    public RxCache configRxCache(@NonNull Context context1, @NonNull RxCache.Builder rxCacheBuilder) {//这里可以自己自定义配置 RxCache 的参数
                        rxCacheBuilder.useExpiredDataIfLoaderNotAvailable(true);
                        //想自定义 RxCache 的缓存文件夹或者解析方式, 如改成 FastJson, 请 return rxCacheBuilder.persistence(cacheDirectory, new FastJsonSpeaker());
                        //否则请 return null;
                        return null;
                    }
                });
    }

    @Override
    public void injectAppLifecycle(@NonNull final Context context, @NonNull List<AppLifecycles> lifecycles) {
        //AppLifecycles 中的所有方法都会在基类 Application 的对应生命周期中被调用, 所以在对应的方法中可以扩展一些自己需要的逻辑
        lifecycles.add(new AppLifecycles() {
            @Override
            public void attachBaseContext(@NonNull Context base) {

            }

            @Override
            public void onCreate(@NonNull Application application) {
                LogUtils.init(true, true, true);
                E2EContextManager.instance().register(application);
                // 主要是添加下面这句代码
                MultiDex.install(context);
                DyWebViewManager.init(application);

//                if (isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
                    ARouter.openLog();     // Print log
                    ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
//                }
                ARouter.init(application); // As early as possible, it is recommended to initialize in the Application
            }

            @Override
            public void onTerminate(@NonNull Application application) {

            }
        });

    }

    @Override
    public void injectActivityLifecycle(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //ActivityLifecycleCallbacks 中的所有方法都会在 Activity (包括三方库) 的对应生命周期中被调用, 所以在对应的方法中可以扩展一些自己需要的逻辑
        //可以根据不同的逻辑添加多个实现类
    }

    @Override
    public void injectFragmentLifecycle(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        //FragmentLifecycleCallbacks 中的所有方法都会在 Fragment (包括三方库) 的对应生命周期中被调用, 所以在对应的方法中可以扩展一些自己需要的逻辑
        //可以根据不同的逻辑添加多个实现类
    }
}
