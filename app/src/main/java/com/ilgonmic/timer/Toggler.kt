package com.ilgonmic.timer

import android.widget.Button

class Toggler(
    private val button: Button,
    private val actionEnable: (Button) -> Unit,
    private val actionDisable: (Button) -> Unit,
    private var enabled: Boolean = true
) {
    fun toggle() {
        val savedEnabled = enabled
        enabled = !enabled

        if (savedEnabled) {
            actionEnable(button)
        } else {
            actionDisable(button)
        }
    }
}