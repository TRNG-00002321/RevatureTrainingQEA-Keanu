package com.revature.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList<Integer> myLL = new LinkedList<Integer>();
        LinkedList<Integer> myLL2 = new LinkedList<Integer>();


        myLL.add(0);
        myLL2.add(1);
        myLL2.add(2);

        myLL.addAll(myLL2);

        if(myLL.contains(0)){
            for(Integer i : myLL){
                System.out.println(i);
            }
        }

        myLL.remove(0);

        if(myLL.equals(myLL2)){
            myLL.removeAll(myLL2);
        }

        myLL2.clear();

        if(myLL.isEmpty()){
            System.out.println("Linked list is empty");
        }
    }
}
