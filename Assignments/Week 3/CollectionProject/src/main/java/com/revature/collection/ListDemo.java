package com.revature.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args){
        List<String> myList = new ArrayList<String>();
        //myList.add(1);
        myList.add("Keanu");
        myList.add("Bob");
        myList.add("Joe");
        myList.add(1,"John");
        //myList.add(10.3);

        System.out.println(myList.get(1));

        //instantiate iterator for my list
        Iterator iterator = myList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(int i = 0; i < myList.size();i++){
            System.out.println(myList.get(i));
        }

        //enhanced for loop
        for(String str : myList){
            System.out.println(str);
        }

        myList.remove(1);

        System.out.println(myList);

        //Iterate through a list reverse
    }
}
