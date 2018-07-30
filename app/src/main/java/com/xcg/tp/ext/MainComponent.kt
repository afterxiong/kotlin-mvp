package com.xcg.tp.ext

import com.xcg.tp.WelcomeActivity
import com.xcg.tp.main.MainActivity
import dagger.Component

/**
 * Created by xiongchengguang on 2018/7/27.
 */
@Component
interface MainComponent {

    fun inject(activity: MainActivity);

    fun inject(activity: WelcomeActivity)
}