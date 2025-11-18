package com.revature.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListDemo {
    public static void main(String[] args){
        ArrayList<Integer> myAL = new ArrayList<Integer>();
        ArrayList<Integer> myAL2 = new ArrayList<Integer>();


        myAL.add(0);
        myAL2.add(1);
        myAL2.add(2);

        myAL.addAll(myAL2);

        if(myAL.contains(0)){
            for(Integer i : myAL){
                System.out.println(i);
            }
        }

        myAL.remove(0);

        if(myAL.equals(myAL2)){
            myAL.removeAll(myAL2);
        }

        myAL2.clear();

        if(myAL.isEmpty()){
            System.out.println("Array list is empty");
        }
    }
}
