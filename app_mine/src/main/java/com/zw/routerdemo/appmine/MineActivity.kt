package com.zw.routerdemo.appmine

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zw.routerdemo.library.ActionConstant
import com.zw.routerdemo.router.SRouter
import com.zw.routerdemo.router.SRouterRequest
import com.zw.routerdemo.router.SRouterResponse
import kotlinx.android.synthetic.main.activity_mine.*

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:2:51 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class MineActivity :AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)
        title = if (intent.getStringExtra("from") != null) {
            "Mine(" + intent.getStringExtra("from").toString() + ")"
        } else {
            "Mine"
        }

        go.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.go) {
            val mSRouterResponse: SRouterResponse = SRouter.instance.sendMessage(
                this@MineActivity, SRouterRequest.creat()
                    .action(ActionConstant.main_name)
                    .data("from", "from Mine")
            )
            Toast.makeText(
                this@MineActivity
                , mSRouterResponse.getResult().toString()
                , Toast.LENGTH_SHORT
            ).show()
        }

    }

}