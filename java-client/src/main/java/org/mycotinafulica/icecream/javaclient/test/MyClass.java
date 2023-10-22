package org.mycotinafulica.icecream.javaclient.test;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    private NestedClass nestedClass;
    private NestedNestedClass nestedNestedClass;

    private List<String> list = new ArrayList<>();
    private String[] arr = new String[]{"arr1", "arr2", "arr4"};

    public MyClass(NestedClass nestedClass, NestedNestedClass nestedNestedClass) {
        this.nestedClass = nestedClass;
        this.nestedNestedClass = nestedNestedClass;
    }
}
