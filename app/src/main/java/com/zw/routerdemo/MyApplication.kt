package com.zw.routerdemo

import com.zw.routerdemo.action.MainAction
import com.zw.routerdemo.apphome.action.HomeAction
import com.zw.routerdemo.appmine.action.MineAction
import com.zw.routerdemo.library.ActionConstant
import com.zw.routerdemo.router.SApplication
import com.zw.routerdemo.router.SRouter

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:2:15 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class MyApplication: SApplication() {

    override fun registerAction() {

        SRouter.instance.registerAction(ActionConstant.main_name, MainAction())
        SRouter.instance.registerAction(ActionConstant.home_name, HomeAction())
        SRouter.instance.registerAction(ActionConstant.mine_name, MineAction())

    }
}