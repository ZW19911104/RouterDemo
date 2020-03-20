package com.zw.routerdemo.router

import android.content.Context

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:10:59 AM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
abstract class SAction {

    abstract fun startAction(context:Context,mutableMap: MutableMap<String,Any>):Any

}