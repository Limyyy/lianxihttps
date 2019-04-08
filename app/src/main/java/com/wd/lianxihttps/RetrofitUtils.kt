package com.wd.lianxihttps

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils private constructor(){

    private val mRetrofit:Retrofit
    private val mlOkhttp = OkHttpClient()

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl("http://mobile.bwstudent.com/movieApi/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(mlOkhttp)
            .build();
    }

    fun <T> creatApi(clas:Class<T>): T{
        return mRetrofit.create(clas)
    }

    companion object {
        private var instance : RetrofitUtils ?= null

        fun getInstance() : RetrofitUtils{
            if(instance == null){
                instance = RetrofitUtils()
            }
            return instance as RetrofitUtils
        }
    }
}
