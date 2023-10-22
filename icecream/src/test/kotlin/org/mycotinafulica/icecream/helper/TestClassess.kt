package org.mycotinafulica.icecream.helper

import java.io.File

class ComplexClass(private val prop1: String, private val prop2: Int,
                   private val prop3: SomeDataClass ){
    private val file = File("/some/file/path")
    private val nested = NestedClass(NestedNestedClass())
}

data class SomeDataClass(val list: List<String>, val arr: Array<Int>)

class NestedClass(val nestedNested: NestedNestedClass){
    private val arg1: String = "Something is here"
    private val arg2: String = "or nothing at all"
}

class NestedNestedClass{
    val x = 10
    val y = 20
}

enum class SomeEnum {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    OCTOBER,
    NOVEMBER,
    DECEMBER
}
