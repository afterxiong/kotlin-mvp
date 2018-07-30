package com.xcg.library

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/** 单例 线程安全
 * Created by xiongchengguang on 2018/7/27.
 */
class AppManager private constructor() {

    private var activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activityStack.remove(activity)
    }

    fun currentActivity(activity: Activity): Activity {
        return activityStack.lastElement()
    }

    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    fun exit(context: Context) {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        manager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}

