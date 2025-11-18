package com.revature.collection;


import java.util.ArrayList;
import java.util.List;

//Create a list to add and iterate over five objects of person having ID,Name,and Age
public class PersonListDemo {
    public static void main(String[] args){
        List<Person> myL = new ArrayList<Person>();

        myL.add(new Person(1,"Keanu",25));
        myL.add(new Person(2,"Bob",20));
        myL.add(new Person(3,"Joe",27));
        myL.add(new Person(4,"John",30));
        myL.add(new Person(5,"George",23));

        for(Person p : myL){
            System.out.println(p);
        }

        myL.clear();

        if(myL.isEmpty()){
            System.out.println("List is empty");
        }
    }
}
