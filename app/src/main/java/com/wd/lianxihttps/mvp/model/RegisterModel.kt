package com.wd.lianxihttps.mvp.model

import com.wd.lianxihttps.RetrofitUtils
import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.Register
import com.wd.lianxihttps.mvp.LoginService
import com.wd.lianxihttps.mvp.callback.LoginCallback
import com.wd.lianxihttps.mvp.callback.RegisterCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.HashMap

class RegisterModel {


    fun getData(map: HashMap<String, String>, registerCallback: RegisterCallback) {
        val loginService = RetrofitUtils.getInstance().creatApi(LoginService::class.java)
        val regData = loginService.getRegDta(map)
        regData.enqueue(object : Callback<Register> {
            override fun onResponse(call: Call<Register>, response: Response<Register>) {
                val body = response.body()
                registerCallback.getData(body)
            }

            override fun onFailure(call: Call<Register>, t: Throwable) {
                registerCallback.Faliter(t.message!!)
            }
        })
    }
}
