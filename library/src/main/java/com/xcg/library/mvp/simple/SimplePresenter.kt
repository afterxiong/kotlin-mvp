
package com.xcg.library.mvp.simple

import android.content.Context
import android.widget.Toast
import com.xcg.library.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by xiongchengguang on 2018/7/27.
 */
class SimplePresenter @Inject constructor() : BasePresenter<SimpleView>() {

    fun out(context: Context){
        Toast.makeText(context,"成功",Toast.LENGTH_LONG).show()
    }
}