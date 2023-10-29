## IceCream - Never Use println() to debug again

This is kotlin-adapted implementation of the original icecream implementation in python [python icecream](https://github.com/gruns/icecream). Thus, it is suitable to be used in Kotlin/Java projects, as well as android.

Since jvm based language doesn't have the luxury to access the ast at runtime, the adaptation is a bit different, yet the spirit is the same, that is, to make your debugging sweet!

Like the original icecream, this one is also [permissively licensed](LICENSE).

## Features

#### Logging with Ic.log()

```kotlin
// Ic.log() without argument prints the class in which Ic.log() is called, including the function and the line number

Ic.log() // prints > org.mycotinafulica.icecream.client.Main$Companion > main:12

// You can add prefix by specifying :
Ic.prefix = "MYC"

Ic.log() // prints MYC > org.mycotinafulica.icecream.client.Main$Companion > main:12

// Ic.log() can receive argument, when given simple type :
Ic.log(5) // prints MYC > org.mycotinafulica.icecream.client.Main$Companion > main:14 > Int: 5
```

#### Inspecting function

```kotlin
// You can inspect function call with Ic.inspect()

fun myFun(){
    Ic.inspect()
}

// prints : MYC > org.mycotinafulica.icecream.client.Main$Companion > myFun:33()

// It can also inspect arguments for you:

myFun("myString", 20, listOf("str1", "str2", "str3"))

fun myFun(arg1: String, arg2: Int, arg3: List<String>){
    Ic.inspect(arg1, arg2, arg3)
}

// prints : MYC > org.mycotinafulica.icecream.client.Main$Companion > myFun:33(myString, 20, [str1, str2, str3])
```

#### Complex object

```kotlin
// Ic can also help you print complex object. To do so you need to configure your app package name first:

// This will tell Ic to pretty print all objects residing in org.mycotinafulica.icecream.client.*
Ic.appPackageName = "org.mycotinafulica.icecream.client"

// Now consider the following classes :
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

 val dataClass = SomeDataClass(listOf("lst1", "lst2", "lst3"), arrayOf(1, 2, 3))
 val myComplexObj = ComplexClass("myprop1", 5, dataClass)

 Ic.log(myComplexObj)
 // It prints :

/*
 MYC > org.mycotinafulica.icecream.client.Main$Companion > main:27
	properties of org.mycotinafulica.icecream.client.ComplexClass:
	> file : java.io.File
	> nested (org.mycotinafulica.icecream.client.NestedClass)
		> arg1 : Something is here
		> arg2 : or nothing at all
		> nestedNested (org.mycotinafulica.icecream.client.NestedNestedClass)
			> x : 10
			> y : 20
	> prop1 : myprop1
	> prop2 : 5
	> prop3 (org.mycotinafulica.icecream.client.SomeDataClass)
		> arr : [1, 2, 3]
		> list : [lst1, lst2, lst3]
*/
```

Notice that the java.io.File is not pretty printed, because it is not part of your app package. You can override this behavior by implementing IcObjectExtension interface.