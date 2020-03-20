package com.zw.routerdemo.router

import android.app.Application
import android.content.res.Configuration

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:1:36 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
abstract class SApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        registerAction()
    }

    abstract fun registerAction()

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}