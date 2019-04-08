package com.wd.lianxihttps

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.blankj.utilcode.util.PhoneUtils
import com.blankj.utilcode.util.ScreenUtils
import com.wd.lianxihttps.EncryptUtil.EncryptUtil
import com.wd.lianxihttps.bean.Register
import com.wd.lianxihttps.mvp.presenter.RegisterPresenter
import com.wd.lianxihttps.mvp.view.RegisterView
import java.math.BigDecimal


class RegisterActivity : AppCompatActivity(), RegisterView {
    override fun getData(map: Register) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun Faliter(msg: String) {
        Toast.makeText(this, "失败", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val date = findViewById<EditText>(R.id.et_date_reg);
        val email = findViewById<EditText>(R.id.et_email_reg);
        val name = findViewById<EditText>(R.id.et_name_reg);
        val phone = findViewById<EditText>(R.id.et_phone_reg);
        val sex = findViewById<EditText>(R.id.et_sex_reg);
        val pwd = findViewById<EditText>(R.id.et_pwd_reg);

        val reg = findViewById<Button>(R.id.btn_reg);
        val login = findViewById<Button>(R.id.btn_login_reg);


        reg.setOnClickListener(View.OnClickListener {

            val name = name.text.toString()
            val sex = sex.text.toString()
            val date = date.text.toString()
            val email = email.text.toString()
            val phone = phone.text.toString()
            val pwd = pwd.text.toString()
            val mEncrypt = EncryptUtil.encrypt(pwd)

            val registerPresenter = RegisterPresenter(this)
            val map = HashMap<String, String>()
            map.put("nickName", name)
            map.put("sex", sex)
            map.put("phone", phone)
            map.put("email", email)
            map.put("birthday", date)
            map.put("pwd", mEncrypt)
            map.put("pwd2", mEncrypt)
            map.put("imei", PhoneUtils.getDeviceId())
            map.put("ua", "OPPO")
            //屏幕尺寸
            val x = Math.pow((ScreenUtils.getScreenWidth() / ScreenUtils.getScreenDensityDpi()).toDouble(), 2.0)
            val y = Math.pow((ScreenUtils.getScreenHeight() / ScreenUtils.getScreenDensityDpi()).toDouble(), 2.0)
            // 屏幕尺寸
            var decimal = BigDecimal(Math.sqrt(x + y))
            decimal = decimal.setScale(1, BigDecimal.ROUND_UP)
            val mScreenInches = decimal.toDouble()

            map.put("screenSize", mScreenInches.toString())
            map.put("os", "android")
            registerPresenter.getRegData(map)


        })

        login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}
