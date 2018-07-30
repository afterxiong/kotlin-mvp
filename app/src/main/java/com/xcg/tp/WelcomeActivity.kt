package com.xcg.tp

import android.Manifest
import android.os.Bundle

import com.xcg.library.mvp.simple.SimpleActivity
import com.xcg.tp.ext.DaggerMainComponent
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

/**
 * Created by xiongchengguang on 2018/7/27.
 */

@RuntimePermissions
class WelcomeActivity : SimpleActivity() {
    override fun createPresenter() {
        DaggerMainComponent.builder().build().inject(this)
        showPhoneStateWithPermissionCheck()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.out(this)
    }

    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    fun showPhoneState() {

    }

    @NeedsPermission(Manifest.permission.KILL_BACKGROUND_PROCESSES)
    fun showKillBackgroup() {

    }

}
