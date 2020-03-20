package com.zw.routerdemo.appmine.action

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.zw.routerdemo.appmine.MineActivity
import com.zw.routerdemo.router.SAction

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:2:58 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class MineAction: SAction() {
    override fun startAction(context: Context, mutableMap: MutableMap<String, Any>): Any {
        if(context is Activity){
            var i = Intent(context,MineActivity::class.java)
            i.putExtra("form",mutableMap.get("from").toString())
            context.startActivity(i)
        }else{
            var i = Intent(context,MineActivity::class.java)
            i.putExtra("form",mutableMap.get("from").toString())
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
        return "arrive Mine success!"

    }
}