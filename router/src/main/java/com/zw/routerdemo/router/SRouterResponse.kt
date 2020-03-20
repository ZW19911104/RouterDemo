package com.zw.routerdemo.router

import org.json.JSONObject

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:11:22 AM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class SRouterResponse {

    companion object {
        val SUCCESS_CODE: Int = 1

        val FAIL_CODE: Int = 0

        val SUCCESS_DESC: String = "success"

        val FAIL_DESC: String = "fail"

    }

    var statusCode: Int? = 0

    var statusDesc: String? = ""

    var body: Any? =null

    fun getResult():JSONObject{
        var json = JSONObject()
        json.put("statusCode",statusCode)
        json.put("statusDesc",statusDesc)
        json.put("body",body)
        return json
    }

    fun setStaus(statusCode:Int,statusDesc:String,body:Any){
        this.statusCode= statusCode
        this.statusDesc = statusDesc
        this.body = body
    }




}