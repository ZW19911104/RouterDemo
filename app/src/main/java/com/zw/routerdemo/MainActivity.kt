package com.zw.routerdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zw.routerdemo.library.ActionConstant
import com.zw.routerdemo.router.SRouter
import com.zw.routerdemo.router.SRouterRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = if (intent.getStringExtra("from") != null) {
            "main(" + intent.getStringExtra("from").toString() + ")"
        } else {
            "main"
        }
        goSameProcess.setOnClickListener(this)
        goDifferentProcess.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.goSameProcess) {
            val mSRouterResponse = SRouter.instance.sendMessage(
                this@MainActivity, SRouterRequest.creat()
                    .action(ActionConstant.home_name)
                    .data("from", "from main")
            )
            Toast.makeText(
                this@MainActivity
                , mSRouterResponse.getResult().toString()
                , Toast.LENGTH_LONG
            ).show()
        } else if (v.id == R.id.goDifferentProcess) {
            val mSRouterResponse = SRouter.instance.sendMessage(
                this@MainActivity, SRouterRequest.creat()
                    .action(ActionConstant.mine_name)
                    .data("from", "from main")
            )
            Toast.makeText(
                this@MainActivity
                , mSRouterResponse.getResult().toString()
                , Toast.LENGTH_LONG
            ).show()
        }
    }
}
