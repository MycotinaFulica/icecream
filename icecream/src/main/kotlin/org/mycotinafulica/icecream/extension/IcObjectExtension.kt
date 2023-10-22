package org.mycotinafulica.icecream.extension

/*
* Implement this interface if you want to provide printing extension for non-simple object outside of
* the applicationPackage
* */
interface IcObjectExtension {
    fun isSupported(obj: Any): Boolean

    fun printObject(obj: Any, currentIndent: Int): String
}