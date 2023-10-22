package org.mycotinafulica.icecream

import org.mycotinafulica.icecream.extension.SimpleObjectExtension
import org.mycotinafulica.icecream.logger.ConsoleLogger
import org.mycotinafulica.icecream.logger.IcLogger
import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.javaField

class Ic {
    companion object {
        var prefix = ""
        var appPackageName = ""
        var logger: IcLogger = ConsoleLogger()
        val extensions = ArrayList<SimpleObjectExtension>()
        private var includeFileName = false
        private var includeClassName = true
        private var includeMethodName = true
        private var includeLineNumber = true

        fun enableFileNamePrint() { includeFileName = true }
        fun enableClassNamePrint(){ includeClassName = true }
        fun enableMethodNamePrint(){ includeMethodName = true }
        fun enableLineNumberPrint(){ includeLineNumber = true }

        fun disableFileNamePrint() { includeFileName = false }
        fun disableClassNamePrint() { includeClassName = false }
        fun disableMethodNamePrint() { includeMethodName = false }
        fun disableLineNumberPrint() { includeLineNumber = false }


        fun inspect(vararg args: Any): String{
            val result = StringBuilder()
            val details = retrieveCallerInformation()

            val sb = StringBuilder()
            printCommon(sb, details)

            sb.append("(")
            args.forEachIndexed { inx, arg ->
                if(inx != args.size - 1){
                    sb.append(arg)
                    sb.append(", ")
                }
                else{
                    sb.append(arg)
                }
            }
            sb.append(")")
            result.append(logger.log("$sb"))

            return normalizeResult(result.toString())
        }

        fun log(): String {
            val result = StringBuilder()
            val details = retrieveCallerInformation()

            var sb = StringBuilder()
            sb = printCommon(sb, details)
            result.append(logger.log("$sb"))

            return normalizeResult(result.toString())
        }

        fun <T: Any> log(obj: T): String {
            val result = StringBuilder()
            val details = retrieveCallerInformation()

            var sb = StringBuilder()
            sb = printCommon(sb, details)
            if(isSimpleDataType(obj)){
                val type = getSimpleType(obj)
                if(obj is Array<*>){
                    result.append(logger.log("$sb > $type: ${obj.contentToString()}"))
                }
                else{
                    result.append(logger.log("$sb > $type: ${obj}"))
                }
            }
            else{
                if(!obj.javaClass.canonicalName.contains(appPackageName)){
                    val loggerExtension = getSupportingExtension(obj)
                    if(loggerExtension != null){
                        val logExtension = loggerExtension.printObject(obj, 0)
                        result.append(logger.log("$sb > $logExtension"))
                    }
                    else{
                        result.append(logger.log("$sb > ${obj.javaClass.canonicalName}"))
                    }
                }
                else{
                    result.append(logger.log("$sb"))
                    result.append(logger.log("\tproperties of ${obj.javaClass.canonicalName}:"))
                    prettyPrintObject(obj, 1, result)
                }
            }

            return normalizeResult(result.toString())
        }

        private fun <T: Any> prettyPrintObject(obj: T, indent: Int, result: StringBuilder) {

            val properties = obj::class.members
                .filterIsInstance<KProperty1<T, *>>()
                .map {
                    if(it.javaField != null) {
                        it.javaField!!.isAccessible = true
                    }
                    it.name to it.get(obj)
                }

            val sb = StringBuilder()
            for(i in 0 until indent){
                sb.append("\t")
            }
            properties.forEach {
                if(isSimpleDataType(it.second)){
                    if(it.second is Array<*>){
                        result.append(logger.log("$sb> ${it.first} : ${(it.second as Array<*>).contentToString()}"))
                    }
                    else{
                        result.append(logger.log("$sb> ${it.first} : ${it.second}"))
                    }
                }
                else{
                    if(!it.second!!.javaClass.canonicalName.contains(appPackageName)){
                        val loggerExtension = getSupportingExtension(it.second!!)
                        if(loggerExtension != null){
                            val logExtension = loggerExtension.printObject(it.second!!, indent)
                            result.append(logger.log("$sb> ${it.first} : $logExtension"))
                        }
                        else{
                            result.append(logger.log("$sb> ${it.first} : ${it.second!!.javaClass.canonicalName}"))
                        }
                    }
                    else{
                        result.append(logger.log("$sb> ${it.first} (${it.second!!.javaClass.canonicalName})"))
                        prettyPrintObject(it.second!!, indent + 1, result)
                    }
                }
            }
        }

        private fun normalizeResult(result: String): String{
            if(result[result.length - 1] == '\n'){
                return result.substring(0, result.length - 1)
            }
            else{
                return result
            }
        }

        private fun getSupportingExtension(obj: Any): SimpleObjectExtension?{
            extensions.forEach {
                if(it.isSupported(obj)) return it
            }

            return null
        }

        private fun getSimpleType(obj: Any?): String{
            if(obj == null) return "null"

            return when(obj){
                is String -> "String"
                is Byte -> "Byte"
                is Short -> "Short"
                is Int -> "Int"
                is Long -> "Long"
                is Float -> "Float"
                is Double -> "Double"
                is Boolean -> "Boolean"
                is Char -> "Char"
                is Array<*> -> "Array"
                is List<*> -> "List"
                is Enum<*> -> "Enum"
                else -> ""
            }
        }

        private fun isSimpleDataType(obj : Any?): Boolean {
            return (obj is String || obj is Number
                    || obj is Boolean || obj is Char
                    || obj is List<*> || obj is Array<*> || obj is Enum<*>
                    || obj == null)
        }

        private fun printCommon(sb: StringBuilder, details: CallerDetails): StringBuilder {
            sb.append("$prefix > ")
            if(includeFileName){
                sb.append(details.fileName)
                sb.append(" > ")
            }
            if(includeClassName) {
                sb.append(details.className)
                sb.append(" > ")
            }
            sb.append(details.methodName)

            if(includeLineNumber){
                sb.append(":${details.lineNumber}")
            }

            return sb
        }

        private fun retrieveCallerInformation(): CallerDetails {
            val caller = Thread.currentThread().stackTrace[3]

            return CallerDetails(caller.fileName, caller.className, caller.methodName, caller.lineNumber.toString())
        }
    }
}

data class CallerDetails(val fileName: String?, val className: String, val methodName: String, val lineNumber: String)