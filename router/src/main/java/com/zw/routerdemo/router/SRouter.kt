package com.zw.routerdemo.router

import android.content.Context

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:10:55 AM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class SRouter private constructor(){

    //双重校验锁
    companion object{
        val instance:SRouter by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            SRouter()
        }
        val mActions: MutableMap<String,SAction> ?= mutableMapOf()

    }


    fun registerAction(action:String,sAction: SAction){
        if(mActions!!.containsKey(action)) {
            return
        }
        mActions!!.put(action,sAction)
    }


    fun sendMessage(c:Context,mSRouterRequest: SRouterRequest):SRouterResponse{
        var mSRouterResponse = SRouterResponse()
        var sAction = findRequest(mSRouterRequest)
        if(sAction != null){
            var any = sAction.startAction(c,mSRouterRequest.datas)
            mSRouterResponse.setStaus(SRouterResponse.SUCCESS_CODE,SRouterResponse.SUCCESS_DESC,any)
        }else{
            mSRouterResponse.setStaus(SRouterResponse.FAIL_CODE,SRouterResponse.FAIL_DESC,
                "can not find this action,check to see if you have been registered!")
        }
        return mSRouterResponse
    }

    fun findRequest(sRouterRequest: SRouterRequest):SAction{
        var action = sRouterRequest.action
        if(mActions!!.containsKey(action)){
            return mActions!!.get(action)!!
        }
        return null!!
    }

}