package org.mycotinafulica.icecream.logger

class IcConsoleLogger: IcLogger {
    override fun log(value: String): String {
        println(value)
        return "$value\n"
    }
}