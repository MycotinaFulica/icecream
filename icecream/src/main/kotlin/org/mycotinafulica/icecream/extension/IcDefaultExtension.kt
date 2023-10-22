package org.mycotinafulica.icecream.extension

import java.io.File

class IcDefaultExtension: IcObjectExtension {
    override fun isSupported(obj: Any): Boolean {
        if(obj is File){
            return true
        }
        return false
    }

    override fun printObject(obj: Any, currentIndent: Int): String {
        if(obj is File){
            return "${obj.javaClass.canonicalName}[${obj.absolutePath}]"
        }
        throw IllegalArgumentException("Object of type ${obj.javaClass.canonicalName} " +
                "is not supported by ${IcDefaultExtension::class.java.canonicalName}")
    }
}