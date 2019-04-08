package com.wd.lianxihttps

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.wd.lianxihttps.EncryptUtil.EncryptUtil
import com.wd.lianxihttps.bean.LoginData
import com.wd.lianxihttps.mvp.presenter.LoginPresenter
import com.wd.lianxihttps.mvp.view.LoginView

class MainActivity : AppCompatActivity(),LoginView{
    override fun getData(map: LoginData) {

        val intent = Intent()
        val clazz = intent.setClass(this, ShowActivity().javaClass)
        startActivity(clazz)

    }

    override fun Faliter(msg: String) {
        Toast.makeText(this,"失败",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPhone = findViewById<EditText>(R.id.et_phone)
        val etPwd = findViewById<EditText>(R.id.et_pwd)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btngoRegister = findViewById<Button>(R.id.btn_goRegister)

        val loginPresenter =  LoginPresenter(this)

       btnLogin.setOnClickListener(View.OnClickListener {
           val phone = etPhone.text.toString()
           val pwd = etPwd.text.toString()
           val map = HashMap<String,String>()
           val encrypt = EncryptUtil.encrypt(pwd)
           map.put("phone",phone)
           map.put("pwd",encrypt)

           loginPresenter.getLoginData(map)
       })

        btngoRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            val clazz = intent.setClass(this, RegisterActivity().javaClass)
            startActivity(clazz)
        })

    }
}
