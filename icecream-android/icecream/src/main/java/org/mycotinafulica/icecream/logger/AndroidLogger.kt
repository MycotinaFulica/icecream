package org.mycotinafulica.icecream.logger

import android.util.Log

class AndroidLogger: IcLogger {
    var currentMode = Mode.DEBUG
    var tag = "AIC"

    override fun log(value: String): String {
        when(currentMode){
            Mode.VERBOSE -> Log.v(tag, value)
            Mode.DEBUG -> Log.d(tag, value)
            Mode.INFO -> Log.i(tag, value)
            Mode.WARN -> Log.w(tag, value)
            Mode.ERROR -> Log.e(tag, value)
            Mode.WTF -> Log.wtf(tag, value)
        }

        return "$value\n"
    }
}

enum class Mode{
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    WTF
}