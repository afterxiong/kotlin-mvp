package com.xcg.library.retrofit

import android.text.TextUtils
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/** 单例 工厂模式
 * Created by xiongchengguang on 2018/7/27.
 */
class RetrofitFactory private constructor() {

    /**
     * 单例实现
     */
    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private var baseUrl = ""
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .build()
    }

    private fun client(): OkHttpClient {
        var client = OkHttpClient
                .Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                            .newBuilder()
                            .addHeader("Content_Type", "application/json")
                            .addHeader("charset", "UTF-8")
                            .build()

                    chain.proceed(request)
                }
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()
        return client
    }

    fun <T> create(service: Class<T>) {
        retrofit.create(service)
    }
}
