package com.zw.routerdemo.apphome

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zw.routerdemo.library.ActionConstant
import com.zw.routerdemo.router.SRouter
import com.zw.routerdemo.router.SRouterRequest
import com.zw.routerdemo.router.SRouterResponse
import kotlinx.android.synthetic.main.activity_home.*

/**
 * describe:
 *
 * @author:ZhangWei(张伟)
 * data:3/18/2020
 * time:2:30 PM
 * motto:高山仰止，景行行止，虽不能至，心向往之。
 */
class HomeActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = if (intent.getStringExtra("from") != null) {
            "Home(" + intent.getStringExtra("from").toString() + ")"
        } else {
            "Home"
        }

        go.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.go) {
            val mSRouterResponse: SRouterResponse = SRouter.instance.sendMessage(
                this@HomeActivity, SRouterRequest.creat()
                    .action(ActionConstant.mine_name)
                    .data("from", "from Home")
            )
            Toast.makeText(
                this@HomeActivity
                , mSRouterResponse.getResult().toString()
                , Toast.LENGTH_LONG
            ).show()
        }

    }
}