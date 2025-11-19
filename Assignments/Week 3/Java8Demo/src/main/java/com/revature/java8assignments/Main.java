package com.revature.java8assignments;

import java.util.Optional;

public class Main {
    static void main() {
        Person p1 = new Person("Keanu", "555-555-5555", null);
        Person p2 = new Person("Bob","222-222-2222",
                new Address("Main St","New York",98009));

        Optional<Address> checkNull = Optional.ofNullable(p1.address);

        if(checkNull.isPresent()) {
            System.out.println("p1 is not null");
        }
        else {
            System.out.println("p1 has null address");
        }
    }
}
