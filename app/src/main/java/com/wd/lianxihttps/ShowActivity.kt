package com.wd.lianxihttps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.wd.lianxihttps.bean.ShowData
import com.wd.lianxihttps.mvp.presenter.ShowPresenter
import com.wd.lianxihttps.mvp.view.ShowView
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity(),ShowView {

    override fun getData(show: ShowData) {

        recy.layoutManager = LinearLayoutManager(this)
        recy.adapter = ShowAdapter(this,show)

    }

    override fun Faliter(msg: String) {
        Toast.makeText(this,"失败",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
       //


        val showPresenter = ShowPresenter(this)

        val map = HashMap<String,String>()
        map.put("page","1")
        map.put("count","100")

        showPresenter.getShowDta(map)
    }
}
