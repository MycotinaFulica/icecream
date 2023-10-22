package org.mycotinafulica.icecream.javaclient;

import org.mycotinafulica.icecream.Ic;
import org.mycotinafulica.icecream.javaclient.test.MyClass;
import org.mycotinafulica.icecream.javaclient.test.NestedClass;
import org.mycotinafulica.icecream.javaclient.test.NestedNestedClass;

public class Main {
    public static void main(String[] args){
        Ic.Companion.setAppPackageName("org.mycotinafulica.icecream.javaclient");
        Ic.Companion.setPrefix("MYC");
        Ic.Companion.log();

        Ic.Companion.log(5);
        Ic.Companion.log(5L);
        Ic.Companion.log(5f);
        Ic.Companion.log(5.0);
        Ic.Companion.log('a');
        Ic.Companion.log(false);

        MyClass myClass = new MyClass(new NestedClass(), new NestedNestedClass());

        Ic.Companion.log(myClass);
    }
}
