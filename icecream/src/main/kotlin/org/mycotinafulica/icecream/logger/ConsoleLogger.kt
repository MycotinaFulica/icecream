package org.mycotinafulica.icecream.logger

class ConsoleLogger: IcLogger {
    override fun log(value: String): String {
        println(value)
        return "$value\n"
    }
}