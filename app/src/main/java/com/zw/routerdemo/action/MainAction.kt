package com.zw.routerdemo.action

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.zw.routerdemo.MainActivity
import com.zw.routerdemo.router.SAction

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:2:22 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class MainAction :SAction() {
    override fun startAction(context: Context, mutableMap: MutableMap<String, Any>): Any {
        if (context is Activity) {
            val i = Intent(context, MainActivity::class.java)
            i.putExtra("from", mutableMap.get("from").toString())
            context.startActivity(i)
        } else {
            val i = Intent(context, MainActivity::class.java)
            i.putExtra("from", mutableMap.get("from").toString())
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
        return "arrive main success!"
    }
}