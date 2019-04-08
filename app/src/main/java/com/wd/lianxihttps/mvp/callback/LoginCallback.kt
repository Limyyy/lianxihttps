package com.wd.lianxihttps.mvp.callback

import com.wd.lianxihttps.bean.LoginData

interface LoginCallback {
    fun getData(login: LoginData)
    fun Faliter(msg : String)
}
