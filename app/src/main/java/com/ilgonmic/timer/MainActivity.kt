package com.ilgonmic.timer

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        timer = object : CountDownTimer(2_000, 100) {
            override fun onFinish() {
                val intent = Intent(this@MainActivity, CountActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
}
