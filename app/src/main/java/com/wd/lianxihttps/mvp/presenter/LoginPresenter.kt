package com.wd.lianxihttps.mvp.presenter

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.mvp.callback.LoginCallback
import com.wd.lianxihttps.mvp.model.LoginModel
import com.wd.lianxihttps.mvp.view.LoginView

class LoginPresenter(private val loginView: LoginView) {

    private val loginModel: LoginModel

    init {
        loginModel = LoginModel()
    }


    fun getLoginData(map: HashMap<String, String>) {
        loginModel.getLoginData(map, object : LoginCallback {
            override fun getData(login: LoginData) {
                loginView.getData(login)
            }

            override fun Faliter(msg: String) {
                loginView.Faliter(msg)
            }

        })
    }

}
