package com.xcg.tp.main

import android.content.Context
import android.widget.Toast
import com.xcg.library.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by xiongchengguang on 2018/7/27.
 */
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {

    fun get(context: Context) {
        Toast.makeText(context, "success", Toast.LENGTH_LONG).show()
    }
}