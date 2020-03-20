package com.zw.routerdemo.router


/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:11:13 AM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class SRouterRequest {

    var action:String ?=""

    val datas = mutableMapOf<String,Any>()


    companion object{
        fun creat():SRouterRequest{
            return SRouterRequest()
        }
    }

    fun data(key:String,value:Any):SRouterRequest{
        this.datas.put(key, value)
        return this
    }

    fun action(action:String):SRouterRequest{
        this.action = action
        return this
    }






}