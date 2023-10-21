package org.mycotinafulica.icecream

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class IcTest {


    @Test
    fun testSimpleTypes(){
        var result = Ic.log(5)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:12 > Int: 5", result)
        result = Ic.log(5L)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:15 > Long: 5", result)
        result = Ic.log(5f)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:18 > Float: 5.0", result)
        result = Ic.log(5.0)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:21 > Double: 5.0", result)
        result = Ic.log('a')
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:24 > Char: a", result)
        result = Ic.log(false)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:27 > Boolean: false", result)

        val byte: Byte = 105
        result = Ic.log(byte)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:32 > Byte: 105", result)
        val short: Short = 10
        result = Ic.log(short)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:36 > Short: 10", result)

        val array = arrayOf("str1", "str2", "str3")
        val list = listOf(1, 2, 3, 4 ,5)

        result = Ic.log(array)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:43 > Array: [str1, str2, str3]", result)

        result = Ic.log(list)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> testSimpleTypes:47 > List: [1, 2, 3, 4, 5]", result)
    }

    @Test
    fun inspectTest() {
        inspectFun("arg1", 2, listOf("arr1", "arr2"))
        inspectEmptyFun()
    }

    private fun inspectFun(x: String, y: Int, z: List<String>){
        val result = Ic.inspect(x, y ,z)
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest " +
                "> inspectFun:59(arg1, 2, [arr1, arr2])", result)
    }

    private fun inspectEmptyFun(){
        val result = Ic.inspect()
        assertEquals("MYC > org.mycotinafulica.icecream.IcTest > inspectEmptyFun:65()", result)
    }

    init {
        Ic.appPackageName = "org.mycotinafulica.icecream"
        Ic.prefix = "MYC"
    }
}