package com.wd.lianxihttps.mvp.presenter

import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.bean.Register
import com.wd.lianxihttps.mvp.callback.LoginCallback
import com.wd.lianxihttps.mvp.callback.RegisterCallback
import com.wd.lianxihttps.mvp.model.LoginModel
import com.wd.lianxihttps.mvp.model.RegisterModel
import com.wd.lianxihttps.mvp.view.LoginView
import com.wd.lianxihttps.mvp.view.RegisterView

import java.util.HashMap

class RegisterPresenter(private val registerView: RegisterView) {
    private val registerModel: RegisterModel

    init {
        registerModel = RegisterModel()
    }

    fun getRegData(map: HashMap<String, String>) {

        registerModel.getData(map, object : RegisterCallback {
            override fun getData(register: Register) {
                registerView.getData(register)
            }

            override fun Faliter(msg: String) {
                registerView.Faliter(msg)
            }
        })

    }
}
