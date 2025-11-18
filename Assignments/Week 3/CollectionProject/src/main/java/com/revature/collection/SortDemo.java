package com.revature.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortDemo {
    static void main() {
        List<String> names = new ArrayList<String>();

        names.add("Brandon");
        names.add("Alex");
        names.add("Peter");
        names.add("Nikhil");

        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);

        //modify this same program to sort in reverse order
    }
}
