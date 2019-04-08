package com.wd.lianxihttps.mvp.callback

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.ShowData

interface ShowCallback {
    fun getData(show: ShowData)
    fun Faliter(msg : String)
}
