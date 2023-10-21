package org.mycotinafulica.icecream.extension

interface SimpleObjectExtension {
    fun isSupported(obj: Any): Boolean

    fun printObject(obj: Any, currentIndent: Int): String
}