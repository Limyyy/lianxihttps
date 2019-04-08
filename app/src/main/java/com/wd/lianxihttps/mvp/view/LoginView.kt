package com.wd.lianxihttps.mvp.view

import com.wd.lianxihttps.bean.LoginData

interface LoginView {
    fun getData(map: LoginData)
    fun Faliter(msg : String)
}
