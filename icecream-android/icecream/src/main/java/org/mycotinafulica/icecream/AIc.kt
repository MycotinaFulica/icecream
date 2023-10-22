package org.mycotinafulica.icecream
import org.mycotinafulica.icecream.extension.IcObjectExtension
import org.mycotinafulica.icecream.logger.AndroidLogger
import org.mycotinafulica.icecream.logger.Mode

class AIc: Ic() {
    companion object {
        init {
            logger = AndroidLogger()
            setStackNum(5)
        }

        fun setAppPackageName(name: String){
            appPackageName = name
        }
        fun setTag(tag: String){
            prefix = tag
            (logger as AndroidLogger).tag = tag
        }
        fun addExtension(extension: IcObjectExtension) {
            extensions.add(extension)
        }

        fun v(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.VERBOSE
            return log(obj)
        }

        fun d(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.DEBUG
            return log(obj)
        }

        fun i(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.INFO
            return log(obj)
        }

        fun w(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.WARN
            return log(obj)
        }

        fun e(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.ERROR
            return log(obj)
        }

        fun wtf(obj: Any): String{
            (logger as AndroidLogger).currentMode = Mode.WTF
            return log(obj)
        }

        fun v(): String{
            (logger as AndroidLogger).currentMode = Mode.VERBOSE
            return log()
        }

        fun d(): String{
            (logger as AndroidLogger).currentMode = Mode.DEBUG
            return log()
        }

        fun i(): String{
            (logger as AndroidLogger).currentMode = Mode.INFO
            return log()
        }

        fun w(): String{
            (logger as AndroidLogger).currentMode = Mode.WARN
            return log()
        }

        fun e(): String{
            (logger as AndroidLogger).currentMode = Mode.ERROR
            return log()
        }

        fun wtf(): String{
            (logger as AndroidLogger).currentMode = Mode.WTF
            return log()
        }

        fun inspect(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.DEBUG
            return inspect(args)
        }

        fun inspectv(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.VERBOSE
            return inspect(args)
        }

        fun inspectd(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.DEBUG
            return inspect(args)
        }

        fun inspecti(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.INFO
            return inspect(args)
        }

        fun inspectw(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.WARN
            return inspect(args)
        }

        fun inspecte(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.ERROR
            return inspect(args)
        }

        fun inspectwtf(vararg args: Any): String {
            (logger as AndroidLogger).currentMode = Mode.WTF
            return inspect(args)
        }

        fun enableFileNamePrint() { Ic.enableFileNamePrint() }
        fun enableClassNamePrint(){ Ic.enableClassNamePrint() }
        fun enableMethodNamePrint(){ Ic.enableMethodNamePrint() }
        fun enableLineNumberPrint(){ Ic.enableLineNumberPrint() }

        fun disableFileNamePrint() { Ic.disableFileNamePrint() }
        fun disableClassNamePrint() { Ic.disableClassNamePrint() }
        fun disableMethodNamePrint() { Ic.disableMethodNamePrint() }
        fun disableLineNumberPrint() { Ic.disableLineNumberPrint() }
    }
}