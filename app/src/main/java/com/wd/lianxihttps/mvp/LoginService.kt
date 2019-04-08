package com.wd.lianxihttps.mvp

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.Register
import com.wd.lianxihttps.bean.ShowData
import retrofit2.Call
import retrofit2.http.*

interface LoginService{

    //登录
    @POST("user/v1/login")
    @FormUrlEncoded
    fun getLoginDta(@FieldMap map: HashMap<String,String>):Call<LoginData>


    //注册
    @POST("user/v1/registerUser")
    @FormUrlEncoded
    fun getRegDta(@FieldMap map: HashMap<String,String>):Call<Register>

    //展示
    @GET("cinema/v1/findRecommendCinemas")
    fun getShowDta(@QueryMap map: HashMap<String,String>):Call<ShowData>

}
