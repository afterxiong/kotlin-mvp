package com.xcg.tp.main

import android.os.Bundle

import com.xcg.library.mvp.BaseActivity
import com.xcg.tp.R
import com.xcg.tp.ext.DaggerMainComponent



class MainActivity : BaseActivity<MainView, MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.get(this)
    }

    override fun createPresenter() {
        DaggerMainComponent.builder().build().inject(this)
    }


}
