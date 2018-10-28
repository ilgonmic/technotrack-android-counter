package com.ilgonmic.timer

import android.widget.Button

class Toggler(
    private val button: Button,
    private val onEnable: (Button) -> Unit,
    private val onDisable: (Button) -> Unit,
    var enabled: Boolean = false
) {
    init {
        if (enabled) {
            onEnable(button)
        }
    }

    fun toggle() {
        enabled = !enabled

        if (enabled) {
            onEnable(button)
        } else {
            onDisable(button)
        }
    }
}