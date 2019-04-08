package com.wd.lianxihttps.mvp.model

import com.wd.lianxihttps.RetrofitUtils
import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.ShowData
import com.wd.lianxihttps.mvp.LoginService
import com.wd.lianxihttps.mvp.callback.LoginCallback
import com.wd.lianxihttps.mvp.callback.ShowCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowModel{

    fun getShowData(map: HashMap<String,String>,showCallback: ShowCallback){
        val showData = RetrofitUtils.getInstance().creatApi(LoginService::class.java).getShowDta(map)
        showData.enqueue(object : Callback<ShowData> {
            override fun onResponse(call: Call<ShowData>, response: Response<ShowData>) {
                val body = response.body()
                showCallback.getData(body)
            }

            override fun onFailure(call: Call<ShowData>, t: Throwable) {
                showCallback.Faliter(t.message!!)
            }
        })
    }

}
