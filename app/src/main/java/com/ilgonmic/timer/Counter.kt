package com.ilgonmic.timer

import android.os.CountDownTimer

class Counter(
    private val min: Int = 1,
    private val max: Int,
    private val onTick: (Int) -> Unit,
    private val onFinish: () -> Unit
) {
    companion object {
        val GAP = 2000L
    }

    private val timer: CountDownTimer

    var count = min
        private set(value) {
            field = value
        }

    init {
        timer = object : CountDownTimer((max - min + 1) * 1000 + GAP, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                this@Counter.onTick(count)

                if (count == max) {
                    clear()
                    this@Counter.onFinish()
                    return
                }

                count++
            }

            override fun onFinish() {
            }
        }
    }

    fun start() {
        timer.start()
    }

    fun clear() {
        count = 1
        timer.cancel()
    }
}