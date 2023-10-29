package org.mycotinafulica.icecream.client

import org.mycotinafulica.icecream.Ic

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Ic.appPackageName = "org.mycotinafulica.icecream.client"
            Ic.prefix = "MYC"

            Ic.log()

            Ic.log(5)
            Ic.log(5L)
            Ic.log(5f)
            Ic.log(5.0)
            Ic.log('a')
            Ic.log(false)

            val list = listOf(1, 2, 3, 4 ,5)

            Ic.log(list)

            val dataClass = SomeDataClass(listOf("lst1", "lst2", "lst3"), arrayOf(1, 2, 3))
            val myComplexObj = ComplexClass("myprop1", 5, dataClass)
            Ic.log(myComplexObj)

            myFun("myString", 20, listOf("str1", "str2", "str3"))
        }

        fun myFun(arg1: String, arg2: Int, arg3: List<String>){
            Ic.inspect(arg1, arg2, arg3)
        }
    }
}