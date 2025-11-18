package com.revature.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
//HashSet is unordered and random insertion
//TreeSet is ordered based on natural ordering
//LinkedHashSet is ordered based on insertion
public class SetDemo {
    static void main(String[] args) {
        Set<String> names = new HashSet<String>();
        //Set<String> names = new TreeSet<String>();
        //Set<String> names = new LinkedHashSet<String>();


        names.add("Keanu");
        names.add("Bob");
        names.add("Joe");

        System.out.println(names);

        for(String name : names){
            System.out.println(name);
        }

        names.clear();
    }
}
