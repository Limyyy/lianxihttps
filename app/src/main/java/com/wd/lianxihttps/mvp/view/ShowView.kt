package com.wd.lianxihttps.mvp.view

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.ShowData

interface ShowView {
    fun getData(show: ShowData)
    fun Faliter(msg : String)
}
