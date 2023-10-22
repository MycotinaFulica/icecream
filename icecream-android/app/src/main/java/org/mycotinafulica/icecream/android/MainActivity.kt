package org.mycotinafulica.icecream.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.mycotinafulica.icecream.AIc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = AIc.d()
        val dataClass = SomeDataClass(listOf("lst1", "lst2", "lst3"), arrayOf(1, 2, 3))
        val myComplexObj = ComplexClass("myprop1", 5, dataClass)
        AIc.d(myComplexObj)
    }
}