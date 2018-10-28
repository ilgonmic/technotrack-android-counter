package com.ilgonmic.timer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ilgonmic.converter.Ordinal
import com.ilgonmic.converter.convert
import kotlinx.android.synthetic.main.activity_count.*

class CountActivity : AppCompatActivity() {

    lateinit var counter: Counter
    lateinit var toggler: Toggler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dictionary = mapOf(
            Ordinal.ZERO to getString(R.string.zero),
            Ordinal.ONE to getString(R.string.one),
            Ordinal.TWO to getString(R.string.two),
            Ordinal.THREE to getString(R.string.three),
            Ordinal.FOUR to getString(R.string.four),
            Ordinal.FIVE to getString(R.string.five),
            Ordinal.SIX to getString(R.string.six),
            Ordinal.SEVEN to getString(R.string.seven),
            Ordinal.EIGHT to getString(R.string.eight),
            Ordinal.NINE to getString(R.string.nine),
            Ordinal.TEN to getString(R.string.ten),

            Ordinal.ELEVEN to getString(R.string.eleven),
            Ordinal.TWELVE to getString(R.string.twelve),
            Ordinal.THIRTEEN to getString(R.string.thirteen),
            Ordinal.FOURTEEN to getString(R.string.fourteen),
            Ordinal.FIFTEEN to getString(R.string.fifteen),
            Ordinal.SIXTEEN to getString(R.string.sixteen),
            Ordinal.SEVENTEEN to getString(R.string.seventeen),
            Ordinal.EIGHTEEN to getString(R.string.eighteen),
            Ordinal.NINETEEN to getString(R.string.nineteen),

            Ordinal.TWENTY to getString(R.string.twenty),
            Ordinal.THIRTY to getString(R.string.thirty),
            Ordinal.FOURTY to getString(R.string.fourty),
            Ordinal.FIFTY to getString(R.string.fifty),
            Ordinal.SIXTY to getString(R.string.sixty),
            Ordinal.SEVENTY to getString(R.string.seventy),
            Ordinal.EIGHTY to getString(R.string.eighty),
            Ordinal.NINETY to getString(R.string.ninety),

            Ordinal.HUNDRED to getString(R.string.hundred),
            Ordinal.HUNDRED_2 to getString(R.string.hundred_2),
            Ordinal.HUNDRED_3 to getString(R.string.hundred_3),
            Ordinal.HUNDRED_4 to getString(R.string.hundred_4),
            Ordinal.HUNDRED_5 to getString(R.string.hundred_5),
            Ordinal.HUNDRED_6 to getString(R.string.hundred_6),
            Ordinal.HUNDRED_7 to getString(R.string.hundred_7),
            Ordinal.HUNDRED_8 to getString(R.string.hundred_8),
            Ordinal.HUNDRED_9 to getString(R.string.hundred_9),

            Ordinal.THOUSAND to getString(R.string.thousand)
        )

        val minCount = savedInstanceState?.getInt("COUNT") ?: 1
        val toggleEnabled = savedInstanceState?.getBoolean("IS_COUNT_ACTIVE") ?: false

        setContentView(R.layout.activity_count)


        counter = Counter(
            min = minCount,
            max = 1_000,
            onTick = {
                this@CountActivity.textBox.text = convert(it, dictionary)
            },
            onFinish = {
                toggler.toggle()
            }
        )

        toggler = Toggler(
            button = control,
            onEnable = {
                it.text = getString(R.string.stop)
                counter.start()
            },
            onDisable = {
                it.text = getString(R.string.start)
                counter.clear()
            },
            enabled = toggleEnabled
        )

        control.setOnClickListener { toggler.toggle() }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt("COUNT", counter.count)
        outState?.putBoolean("IS_COUNT_ACTIVE", toggler.enabled)
        super.onSaveInstanceState(outState)
    }
}
