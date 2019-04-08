package com.wd.lianxihttps.mvp.callback

import com.wd.lianxihttps.bean.Register

interface RegisterCallback {
    fun getData(map: Register)
    fun Faliter(msg : String)
}
