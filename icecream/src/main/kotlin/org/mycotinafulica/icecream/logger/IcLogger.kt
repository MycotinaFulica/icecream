package org.mycotinafulica.icecream.logger

/*
* This interface allows us to change log implementation, from simple console logging to a framework specific logging
* such as Log.d()/Log.i() in android, or maybe to stream the log into some monitoring tools, or maybe even to enrich
* your Log4J logging.
* */
interface IcLogger {
    fun log(value: String): String
}