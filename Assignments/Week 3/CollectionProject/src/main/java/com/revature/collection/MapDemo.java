package com.revature.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Hashtable
// - Thread safe
// - does not allow null keys and null values
// - uses enumeration to iterate key set
// - legacy class
//Hashmap
// - not thread safe
// - allows one null key and any number of null values
// - uses iterator for:each loop to iterate over key ser
// - better performance
public class MapDemo {
    static void main() {
        Map<String, Double> persons = new HashMap<String, Double>();

        //for duplicate keys the latest value is updated
        persons.put("Alex", 10000.0);
        persons.put("Rebecca", 250000.0);
        persons.put("Peter", 200000.0);
        //persons.put("Alex", 150000.0);

        System.out.println(persons.get("Alex"));

        //get the set of keys to iterate through a map
        Set<String> names = persons.keySet();

        for (String name : names)
                System.out.println(name + " , " + persons.get(name));
    }
}
