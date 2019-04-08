package com.wd.lianxihttps.mvp.model

import com.wd.lianxihttps.RetrofitUtils
import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.mvp.LoginService
import com.wd.lianxihttps.mvp.callback.LoginCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel{

    fun getLoginData(map: HashMap<String,String>,loginCallback: LoginCallback){
        val loginDta = RetrofitUtils.getInstance().creatApi(LoginService::class.java).getLoginDta(map)
        loginDta.enqueue(object : Callback<LoginData> {
            override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                val body = response.body()
                loginCallback.getData(body)
            }

            override fun onFailure(call: Call<LoginData>, t: Throwable) {
                loginCallback.Faliter(t.message!!)
            }
        })
    }

}
