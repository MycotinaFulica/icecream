package org.mycotinafulica.icecream

import org.junit.jupiter.api.Test
import org.mycotinafulica.icecream.extension.IcDefaultExtension
import org.mycotinafulica.icecream.helper.ComplexClass
import org.mycotinafulica.icecream.helper.SomeDataClass
import kotlin.test.assertEquals

class IcComplexObjTest {
    init {
        Ic.appPackageName = "org.mycotinafulica.icecream"
        Ic.prefix = "MYC"
        Ic.extensions.add(IcDefaultExtension())
    }

    @Test
    fun testComplexObj(){
        val dataClass = SomeDataClass(listOf("lst1", "lst2", "lst3"), arrayOf(1, 2, 3))
        val myComplexObj = ComplexClass("myprop1", 5, dataClass)
        val result = Ic.log(myComplexObj)

        assertEquals("MYC > org.mycotinafulica.icecream.IcComplexObjTest > testComplexObj:20\n" +
                "\tproperties of org.mycotinafulica.icecream.helper.ComplexClass:\n" +
                "\t> file : java.io.File[E:\\some\\file\\path]\n" +
                "\t> nested (org.mycotinafulica.icecream.helper.NestedClass)\n" +
                "\t\t> arg1 : Something is here\n" +
                "\t\t> arg2 : or nothing at all\n" +
                "\t\t> nestedNested (org.mycotinafulica.icecream.helper.NestedNestedClass)\n" +
                "\t\t\t> x : 10\n" +
                "\t\t\t> y : 20\n" +
                "\t> prop1 : myprop1\n" +
                "\t> prop2 : 5\n" +
                "\t> prop3 (org.mycotinafulica.icecream.helper.SomeDataClass)\n" +
                "\t\t> arr : [1, 2, 3]\n" +
                "\t\t> list : [lst1, lst2, lst3]", result)
    }
}