package com.xcg.library.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xcg.library.AppManager
import javax.inject.Inject

/**
 * Created by xiongchengguang on 2018/7/27.
 */
abstract class BaseActivity<V : BaseView, P : BasePresenter<*>> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        createPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.removeActivity(this)
    }

    abstract fun createPresenter()

}