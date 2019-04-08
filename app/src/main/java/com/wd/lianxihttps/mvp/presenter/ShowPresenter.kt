package com.wd.lianxihttps.mvp.presenter

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.ShowData
import com.wd.lianxihttps.mvp.callback.LoginCallback
import com.wd.lianxihttps.mvp.callback.ShowCallback
import com.wd.lianxihttps.mvp.model.LoginModel
import com.wd.lianxihttps.mvp.model.ShowModel
import com.wd.lianxihttps.mvp.view.LoginView
import com.wd.lianxihttps.mvp.view.ShowView

class ShowPresenter(private val showView: ShowView) {

    private val showModel: ShowModel

    init {
        showModel = ShowModel()
    }


    fun getShowDta(map: HashMap<String, String>) {
        showModel.getShowData(map, object : ShowCallback {
            override fun getData(login: ShowData) {
                showView.getData(login)
            }

            override fun Faliter(msg: String) {
                showView.Faliter(msg)
            }

        })
    }

}
